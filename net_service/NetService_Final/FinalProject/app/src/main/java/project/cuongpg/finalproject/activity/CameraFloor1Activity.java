package project.cuongpg.finalproject.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import project.cuongpg.finalproject.R;

public class CameraFloor1Activity extends AppCompatActivity {
    VideoView video1, video2;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_floor1);
        video1 = (VideoView) findViewById(R.id.video1);
        video2 = (VideoView) findViewById(R.id.video2);
        mediaController = new MediaController(this);
        videoPlay();
    }
    public void videoPlay(){
        String videoPath = "android.resource://project.cuongpg.finalproject/" + R.raw.cam1;
        Uri uri = Uri.parse(videoPath);
        video1.setVideoURI(uri);
        video1.setMediaController(mediaController);
        mediaController.setAnchorView(video1);
        video1.start();
    }
}
