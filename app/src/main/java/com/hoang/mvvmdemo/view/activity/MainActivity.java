package com.hoang.mvvmdemo.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hoang.mvvmdemo.R;
import com.hoang.mvvmdemo.databinding.LoginViewBinding;
import com.hoang.mvvmdemo.model.User;
import com.hoang.mvvmdemo.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity implements LoginViewModel.IFLoginViewModel{

    private User mUser;
    private  LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginViewBinding binding = DataBindingUtil.setContentView(this, R.layout.login_view);

        mUser = new User();
        binding.setUser(mUser);

        mLoginViewModel = new LoginViewModel();
        mLoginViewModel.setLoginViewModelListener(this);
        binding.setLoginViewModel(mLoginViewModel);

        mUser.image.set("https://www.dhresource.com/0x0s/f2-albu-g1-M00-D9-93-rBVaGFZSH1GABJiKAALuDZcoJq4007.jpg/wholesale-1-pcs-for-boy-and-gril-baby-santa.jpg");

    }

    @Override
    public void onLoginSucess() {
        Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(MainActivity.this, "Login fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onChangeUserName(String name) {
        mUser.username.set(name);
    }

    @Override
    public void onChangePassword(String password) {
        mUser.password.set(password);
    }

    @Override
    public void onValidateFail(int i) {
        if (i == 1){
            Toast.makeText(MainActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
        }
    }
}
