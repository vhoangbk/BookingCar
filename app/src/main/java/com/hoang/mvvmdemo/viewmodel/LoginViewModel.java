package com.hoang.mvvmdemo.viewmodel;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.hoang.mvvmdemo.model.User;
import com.squareup.picasso.Picasso;

/**
 * Created by hoangnv on 8/24/17.
 */

public class LoginViewModel   {

    public interface IFLoginViewModel{
        void onLoginSucess();
        void onLoginFail();
        void onChangeUserName(String name);
        void onChangePassword(String password);
        void onValidateFail(int i);
    }

    private IFLoginViewModel loginViewModelListener;

    public void setLoginViewModelListener(IFLoginViewModel loginViewModelListener) {
        this.loginViewModelListener = loginViewModelListener;
    }

    public void login(View view, User user){
        int valid = user.validate();
        if (valid == 0){
            user.loggin();
            if (loginViewModelListener != null){
                loginViewModelListener.onLoginSucess();
            }
        }else{
            if (loginViewModelListener != null){
                loginViewModelListener.onValidateFail(valid);
            }
        }


    }

    @BindingAdapter({"android:src", "app:error"})
    public static void loadImage(ImageView imageView, String url, Drawable error){
        Picasso.with(imageView.getContext())
                .load(url)
                .error(error)
                .into(imageView);
    }

    @BindingAdapter({"app:addTextChangedListener"})
    public static void addTextChangedListener(EditText editText, TextWatcher watcher){
        editText.addTextChangedListener(watcher);
    }

    public TextWatcher watcherUserName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (loginViewModelListener != null){
                loginViewModelListener.onChangeUserName(editable.toString());
            }
        }
    };

    public TextWatcher watcherPassword = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (loginViewModelListener != null){
                loginViewModelListener.onChangePassword(editable.toString());
            }
        }
    };



}
