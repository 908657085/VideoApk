package com.gaoxh.videoapk.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.gaoxh.videoapk.R;
import com.gaoxh.videoapk.bean.Video;
import com.gaoxh.videoapk.util.VideoController;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videoList;
    private Context context;

    public VideoAdapter(Context context) {
        this.context = context;
        this.videoList = new ArrayList<>();
    }

    public VideoAdapter( Context context,List<Video> videoList) {
        this.videoList = videoList;
        this.context = context;
    }

    public void addData(List<Video> data){
        videoList.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_video,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoViewHolder holder, final int position) {
        holder.videoName.setText(videoList.get(position).getName());
        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoController.get().start(holder.videoView,videoList.get(position).getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList!=null?videoList.size():0;
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder{
        private VideoView videoView;
        private TextView videoName;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.v_video_view);
            videoName = itemView.findViewById(R.id.tv_video);
        }
    }
}
