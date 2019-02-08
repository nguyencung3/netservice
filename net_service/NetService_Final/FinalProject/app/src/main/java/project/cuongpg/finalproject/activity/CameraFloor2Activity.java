package project.cuongpg.finalproject.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import project.cuongpg.finalproject.R;

public class CameraFloor2Activity extends AppCompatActivity {
    VideoView video2;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_floor2);
        video2 = (VideoView) findViewById(R.id.video2);
        mediaController = new MediaController(this);
        videoPlay();
    }
    public void videoPlay(){
        String videoPath = "android.resource://project.cuongpg.finalproject/" + R.raw.cam2;
        Uri uri = Uri.parse(videoPath);
        video2.setVideoURI(uri);
        video2.setMediaController(mediaController);
        mediaController.setAnchorView(video2);
        video2.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
