package com.gaoxh.videoapk.ui.vip;

import android.view.View;

import com.gaoxh.videoapk.R;
import com.gaoxh.videoapk.ui.AbsFragment;

public class VipFragment extends AbsFragment {

    @Override
    public int layoutId() {
        return R.layout.fragment_vip;
    }

    @Override
    public String titleText() {
        return getResources().getString(R.string.title_vip);
    }

    @Override
    public void initView(View root) {
    }
}