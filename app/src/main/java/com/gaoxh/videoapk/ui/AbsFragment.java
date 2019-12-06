package com.gaoxh.videoapk.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gaoxh.videoapk.R;
import com.gaoxh.videoapk.VideoApp;

public abstract class AbsFragment extends Fragment {
    protected VideoApp mApp;
    protected LinearLayout mBackBtn;
    protected TextView mTitleTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(layoutId(), container, false);
        mApp = (VideoApp) getActivity().getApplication();
        initTitleBar(root);
        initView(root);
        return root;
    }

    public abstract int layoutId();

    public abstract String titleText();

    public abstract void initView(View root);

    public boolean isTop() {
        return true;
    }

    public boolean hasTitleBar() {
        return true;
    }

    public void onBackEvent() {
        getActivity().finish();
    }

    private void initTitleBar(View root) {
        if (hasTitleBar()) {
            mBackBtn = root.findViewById(R.id.btn_title_bar_back);
            mTitleTv = root.findViewById(R.id.tv_title_bar_text);
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


    public void showLoading() {

    }

    public void dismissLoading() {

    }
}
