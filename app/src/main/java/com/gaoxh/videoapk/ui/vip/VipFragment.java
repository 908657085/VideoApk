package com.gaoxh.videoapk.ui.vip;

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

public class VipFragment extends Fragment {

    private VipViewModel vipViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vipViewModel =
                ViewModelProviders.of(this).get(VipViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vip, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        vipViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}