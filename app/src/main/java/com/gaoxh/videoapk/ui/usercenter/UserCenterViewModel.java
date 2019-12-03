package com.gaoxh.videoapk.ui.usercenter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserCenterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UserCenterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}