package com.gaoxh.videoapk.ui.usercenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.gaoxh.videoapk.R;

public class UserCenterFragment extends Fragment {

    private UserCenterViewModel userCenterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userCenterViewModel =
                ViewModelProviders.of(this).get(UserCenterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_center, container, false);
        return root;
    }
}