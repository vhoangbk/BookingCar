package com.hoang.mvvmdemo.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by hoangnv on 8/24/17.
 */

public class User extends BaseObservable {

    public final ObservableField<String> username = new ObservableField<>();

    public final ObservableField<String> password = new ObservableField<>();

    public final ObservableField<String> image = new ObservableField<>();


    public int validate(){
        if (username.get() == null || username.get().trim().isEmpty()){
            return 1;
        }
        return 0;
    }

    public void loggin(){

    }

}
