package com.gaoxh.videoapk.util;

import android.content.Context;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoController {

    private Context mAppContext;
    private MediaController mediaController;
    private VideoView mLastVideoView;


    private VideoController() {
    }

    public static VideoController get() {
        return SingleTonHolder.sInstance;
    }

    public synchronized void init(Context context) {
        synchronized (VideoController.class) {
            if (mAppContext == null) {
                mAppContext = context.getApplicationContext();
                mediaController = new MediaController(mAppContext);
            }
        }
    }

    public void start(VideoView videoView, String videoUrl) {
        if (mLastVideoView != null && mLastVideoView.isPlaying()) {
            mLastVideoView.suspend();
            mLastVideoView = null;
        }
        videoView.setMediaController(mediaController);
        videoView.setVideoPath(videoUrl);
        videoView.start();
    }

    private static class SingleTonHolder {
        private static final VideoController sInstance = new VideoController();
    }

}
