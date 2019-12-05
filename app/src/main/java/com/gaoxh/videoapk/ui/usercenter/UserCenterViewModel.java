package com.gaoxh.videoapk.ui.usercenter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gaoxh.videoapk.bean.UserInfo;

public class UserCenterViewModel extends ViewModel {

    private MutableLiveData<UserInfo> mUserInfo;

    public UserCenterViewModel() {
        mUserInfo = new MutableLiveData<>();
        mUserInfo.setValue(null);
    }

    public LiveData<UserInfo> getUserInfo(){
        return mUserInfo;
    }

    public void loadUserInfo(){

    }
}