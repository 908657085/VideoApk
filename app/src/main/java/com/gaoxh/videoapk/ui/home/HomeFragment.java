package com.gaoxh.videoapk.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gaoxh.videoapk.R;
import com.gaoxh.videoapk.bean.Video;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView mVideoRV;
    private VideoAdapter videoAdapter;
    private SwipeRefreshLayout videoSW;
    private Handler handler = new Handler();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initView(root);
        return root;
    }

    private void initView(View root){
        mVideoRV = root.findViewById(R.id.rv_video);
        mVideoRV.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Video> data = new ArrayList<>();
        data.add(new Video("","测试1"));
        data.add(new Video("","测试2"));
        data.add(new Video("","测试3"));
        data.add(new Video("","测试4"));
        data.add(new Video("","测afa1"));
        data.add(new Video("","测试adf"));
        data.add(new Video("","测试adf"));
        data.add(new Video("","测试1"));
        data.add(new Video("","测试1"));
        videoAdapter = new VideoAdapter(getContext(),data);
        mVideoRV.setAdapter(videoAdapter);
        videoSW = root.findViewById(R.id.sw_video);
        videoSW.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        videoSW.setRefreshing(false);
                        Toast.makeText(getContext(),"刷新成功！",Toast.LENGTH_SHORT).show();
                    }
                },500);
            }
        });
    }
}