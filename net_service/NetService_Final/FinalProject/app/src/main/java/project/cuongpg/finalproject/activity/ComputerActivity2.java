package project.cuongpg.finalproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import project.cuongpg.finalproject.R;

public class ComputerActivity2 extends AppCompatActivity implements View.OnClickListener{
    LinearLayout line1, line2, line3, line4, line5, line6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        line1 = (LinearLayout) findViewById(R.id.line1);

        line3 = (LinearLayout) findViewById(R.id.line3);
        line4 = (LinearLayout) findViewById(R.id.line4);

        //onclick
        line1.setOnClickListener(this);
        line3.setOnClickListener(this);
        line4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.line1:
                intent = new Intent(this, ComputerDetailActivity1.class);
                startActivity(intent);
                break;
            case R.id.line3:
                intent = new Intent(this, ComputerDetailActivity2.class);
                startActivity(intent);
                break;

            case R.id.line4:
                intent = new Intent(this, ComputerDetailActivity3.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
