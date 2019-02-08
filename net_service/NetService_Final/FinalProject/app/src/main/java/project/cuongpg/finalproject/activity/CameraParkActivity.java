package project.cuongpg.finalproject.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import project.cuongpg.finalproject.R;

public class CameraParkActivity extends AppCompatActivity {
    VideoView video4;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_park);
        video4 = (VideoView) findViewById(R.id.video4);
        mediaController = new MediaController(this);
        videoPlay();
    }
    public void videoPlay(){
        String videoPath = "android.resource://project.cuongpg.finalproject/" + R.raw.cam4;
        Uri uri = Uri.parse(videoPath);
        video4.setVideoURI(uri);
        video4.setMediaController(mediaController);
        mediaController.setAnchorView(video4);
        video4.start();
    }
}
