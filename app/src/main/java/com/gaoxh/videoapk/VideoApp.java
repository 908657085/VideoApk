package com.gaoxh.videoapk;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gaoxh.videoapk.bean.UserInfo;

public class VideoApp extends Application {


    private MutableLiveData<UserInfo> mUserInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        mUserInfo = new MutableLiveData<>();
        mUserInfo.setValue(null);
    }

    public LiveData<UserInfo> getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        mUserInfo.setValue(userInfo);
    }

}
