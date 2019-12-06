package com.gaoxh.videoapk.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gaoxh.videoapk.R;
import com.gaoxh.videoapk.bean.Video;
import com.gaoxh.videoapk.ui.AbsFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends AbsFragment {
    private HomeViewModel homeViewModel;
    private RecyclerView mVideoRV;
    private VideoAdapter videoAdapter;
    private SwipeRefreshLayout videoSW;
    private Handler handler = new Handler();

    @Override
    public int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public String titleText() {
        return getResources().getString(R.string.title_home);
    }

    public void initView(View root){
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        mVideoRV = root.findViewById(R.id.rv_video);
        mVideoRV.setLayoutManager(new LinearLayoutManager(getContext()));
        videoAdapter = new VideoAdapter(getContext());
        mVideoRV.setAdapter(videoAdapter);
        videoSW = root.findViewById(R.id.sw_video);
        videoSW.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadVideoData();
                        videoSW.setRefreshing(false);
                        Toast.makeText(getContext(),"刷新成功！",Toast.LENGTH_SHORT).show();
                    }
                },500);
            }
        });
        loadVideoData();
    }
    private void loadVideoData(){
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
        videoAdapter.addData(data);
    }
}