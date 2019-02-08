package project.cuongpg.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import project.cuongpg.finalproject.R;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView employee, stock, revenue, setting, computer, camera;
    private CollapsingToolbarLayout collapsingToolbar;
    public static Map<String, String> infoAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Define cardview
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        employee = (CardView) findViewById(R.id.employeeId);
        stock = (CardView) findViewById(R.id.stockId);
        revenue = (CardView) findViewById(R.id.revenueId);
        setting = (CardView) findViewById(R.id.settingId);
        computer = (CardView) findViewById(R.id.computerInfoID);
        camera = (CardView) findViewById(R.id.cameraID);

        Intent intent = getIntent();
        infoAccount = (HashMap<String, String>) intent.getSerializableExtra("infoUser");
        collapsingToolbar.setTitle(infoAccount.get("fullName"));


        //Add event for card

        employee.setOnClickListener(this);
        setting.setOnClickListener(this);
        stock.setOnClickListener(this);
        revenue.setOnClickListener(this);
        computer.setOnClickListener(this);
        camera.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.settingId:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.employeeId:
                intent = new Intent(this, EmployeeActivity.class);
                startActivity(intent);
                break;

            case R.id.stockId:
                intent = new Intent(this, StockActivity.class);
                startActivity(intent);
                break;
            case R.id.revenueId:
                intent = new Intent(this, RevenueActivity.class);
                startActivity(intent);
                break;
            case R.id.cameraID:
                intent = new Intent(this, CameraActivity.class);
                startActivity(intent);
                break;
            case R.id.computerInfoID:
                intent = new Intent(this, ComputerActivity2.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "If you want to back,Please Log Out ", Toast.LENGTH_SHORT).show();

    }

    public void clickToViewNotification(View view) {
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }
}
