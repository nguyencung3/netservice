package project.cuongpg.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import project.cuongpg.finalproject.R;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView room1, room2, room3, room4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        room1 = (CardView) findViewById(R.id.room1);
        room2 = (CardView) findViewById(R.id.room2);
        room3 = (CardView) findViewById(R.id.room3);
        room4 = (CardView) findViewById(R.id.room4);

        room1.setOnClickListener(this);
        room2.setOnClickListener(this);
        room3.setOnClickListener(this);
        room4.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.room1 : intent = new Intent(this, CameraFloor1Activity.class);
                startActivity(intent);
                break;
            case R.id.room2 : intent = new Intent(this, CameraFloor2Activity.class);
                startActivity(intent);
                break;
            case R.id.room3 : intent = new Intent(this, CameraFloor1Activity.class);
                startActivity(intent);
                break;
            case R.id.room4 : intent = new Intent(this, CameraParkActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
