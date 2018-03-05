package io.farmed.farmed;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;

public class LearnActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG = "LEARN ACTIVITY";
    MediaSessionCompat mMediaSession;
    MediaControllerCompat mMediaController;
    PlaybackStateCompat.Builder mStateBuilder;
    private VideoView mVideoView;
    private ImageButton mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        mVideoView = findViewById(R.id.videoView);
        mPlayButton = findViewById(R.id.playButton);
        mPlayButton.setOnClickListener(this);
//
//
//
//        mMediaSession = new MediaSessionCompat(this, LOG_TAG);
//
//        mMediaSession.setFlags(
//                MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS |
//                MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS
//        );
//        mStateBuilder = new PlaybackStateCompat.Builder()
//                .setActions(
//                        PlaybackStateCompat.ACTION_PLAY |
//                                PlaybackStateCompat.ACTION_PLAY_PAUSE);
//        mMediaSession.setPlaybackState(mStateBuilder.build());
//
//        // MySessionCallback has methods that handle callbacks from a media controller
//        mMediaSession.setCallback(new MediaSessionCompat.Callback() {
//        });
//
//        // Create a MediaControllerCompat
//        MediaControllerCompat mediaController =
//                new MediaControllerCompat(this, mMediaSession);
//
//        MediaControllerCompat.setMediaController(this, mediaController);
    }


    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse("https://youtu.be/oEgpGv2CF1U");
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mVideoView.start();
            }
        });
    }
}

