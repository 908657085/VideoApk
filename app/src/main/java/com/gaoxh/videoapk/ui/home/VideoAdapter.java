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

import org.w3c.dom.Text;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> data;
    private Context context;

    public VideoAdapter() {
    }

    public VideoAdapter( Context context,List<Video> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_video,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.videoName.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
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
