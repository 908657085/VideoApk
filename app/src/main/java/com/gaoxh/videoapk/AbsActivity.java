package com.gaoxh.videoapk;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbsActivity extends AppCompatActivity {

    protected LinearLayout mBackBtn;
    protected TextView mTitleTv;
    protected VideoApp mApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mApp = (VideoApp) getApplication();
        initTitleBar();
        initView();
    }

    public abstract int layoutId();

    public abstract String titleText();

    public abstract void initView();

    public boolean isTop() {
        return true;
    }

    public boolean hasTitleBar() {
        return true;
    }

    public void onBackEvent() {
        finish();
    }

    private void initTitleBar() {
        if (hasTitleBar()) {
            mBackBtn = findViewById(R.id.btn_title_bar_back);
            mTitleTv = findViewById(R.id.tv_title_bar_text);
            if (isTop()) {
                mBackBtn.setVisibility(View.GONE);
            } else {
                mBackBtn.setVisibility(View.VISIBLE);
                mBackBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackEvent();
                    }
                });
            }
            mTitleTv.setText(titleText());
        }
    }

    public void showLoading(){

    }

    public void dismissLoading(){

    }
}
