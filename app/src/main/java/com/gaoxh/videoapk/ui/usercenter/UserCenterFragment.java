package com.gaoxh.videoapk.ui.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.gaoxh.videoapk.LoginActivity;
import com.gaoxh.videoapk.R;
import com.gaoxh.videoapk.bean.UserInfo;

public class UserCenterFragment extends Fragment {
    private static final String TAG = UserCenterFragment.class.getSimpleName();
    private UserCenterViewModel userCenterViewModel;
    private LinearLayout mLoginView;
    private ImageView mUserIconIv;
    private TextView mUserNameTv;
    private TextView mUserAccountTv;
    private TextView mUserLevelTv;
    private View mIntroductionView;
    private Button mExitBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userCenterViewModel =
                ViewModelProviders.of(this).get(UserCenterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_center, container, false);
        initView(root);
        userCenterViewModel.getUserInfo().observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                refreshUserInfo(userInfo);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    private void initView(View root) {
        mLoginView = root.findViewById(R.id.ll_user_login);

        mUserIconIv = root.findViewById(R.id.iv_user_icon);
        mUserNameTv = root.findViewById(R.id.tv_user_name);
        mUserAccountTv = root.findViewById(R.id.tv_user_account);
        mUserLevelTv = root.findViewById(R.id.tv_user_level);

        mIntroductionView = root.findViewById(R.id.rl_introduction);
        mExitBtn = root.findViewById(R.id.btn_exit);

        mLoginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userCenterViewModel.getUserInfo().getValue() == null) {
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        mIntroductionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "敬请期待!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void refreshUserInfo(UserInfo userInfo) {
        if (userInfo == null) {
            mUserIconIv.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            mUserNameTv.setText("点击登录/注册");
            mUserAccountTv.setText("未登录");
            mUserLevelTv.setText("游客");
            mExitBtn.setVisibility(View.GONE);
        } else {
            loadUserIcon(userInfo.getIcUrl());
            mUserNameTv.setText(userInfo.getName());
            mUserAccountTv.setText(userInfo.getAccount());
            mUserLevelTv.setText(userInfo.getLevel());
            mExitBtn.setVisibility(View.VISIBLE);
        }
    }

    private void loadUserIcon(String iconUrl) {

    }
}