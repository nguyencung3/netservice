package project.cuongpg.finalproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.adapter.NotificationAdapter;
import project.cuongpg.finalproject.model.ModelNotification;

public class NotificationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ModelNotification> notificationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        recyclerView = (RecyclerView) findViewById(R.id.notiList);

        notificationList = new ArrayList<>();
        notificationList.add(new ModelNotification("Số lượng PEPSI gần hết, số lượng còn lại 5 chai"));
        notificationList.add(new ModelNotification("Số lượng STING gần hết, số lượng còn lại 3 chai"));
        notificationList.add(new ModelNotification("Máy tính số 1 đang có nhiệt độ quá cao: 95%"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayoutmanager = layoutManager;
        recyclerView.setLayoutManager(rvLayoutmanager);

        NotificationAdapter notificationAdapter = new NotificationAdapter(this, notificationList);
        recyclerView.setAdapter(notificationAdapter);

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
}
