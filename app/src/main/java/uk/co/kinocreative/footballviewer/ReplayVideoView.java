package uk.co.kinocreative.footballviewer;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.VideoView;

import java.net.URL;

/**
 * Created by nemo on 10/03/17.
 */

public class ReplayVideoView extends LinearLayout {

    private boolean videoBeenPlayed = false;

    public ReplayVideoView(Context context) {
        super(context);
        initializeViews(context);
    }

    public ReplayVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.video_replay_view, this);


    }

    public void setVideo(Uri videoUri, int initialScreen) {

        final VideoView videoView = (VideoView) this.findViewById(R.id.video);
        videoView.setVideoURI(videoUri);
        videoView.seekTo(initialScreen);

        videoView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (videoView.isPlaying()) {
                    videoView.pause();
                } else {

                    if (!videoBeenPlayed) {
                        videoView.seekTo(0);
                    }
                    videoView.start();
                    videoBeenPlayed = true;
                }

                return false;

            }
        });

    }

    public void playVideo(View view) {

        VideoView videoView = (VideoView) this.findViewById(R.id.video);
        videoView.seekTo(0);
        videoView.start();

        if (videoView.isPlaying()) {
            videoView.pause();
        } else {
            videoView.seekTo(10000);
            videoView.start();
        }

    }

}
