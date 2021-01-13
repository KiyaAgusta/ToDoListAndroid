package com.akiraagusta.android_todo.interactor;

import com.akiraagusta.android_todo.contract.MainContract;
import com.akiraagusta.android_todo.util.SharedPreferencesUtil;

public class MainInteractor implements MainContract.Interactor {
    private SharedPreferencesUtil sharedPreferencesUtil;

    public MainInteractor(SharedPreferencesUtil sharedPreferencesUtil) {
        this.sharedPreferencesUtil = sharedPreferencesUtil;
    }

    @Override
    public boolean isUserLogin() {
        if(sharedPreferencesUtil.getToken() != null){
            return true;
        }
        else {
            return false;
        }
    }
}
