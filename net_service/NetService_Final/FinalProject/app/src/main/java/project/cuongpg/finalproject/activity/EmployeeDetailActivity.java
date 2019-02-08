package project.cuongpg.finalproject.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.model.ModelEmployee;
import project.cuongpg.finalproject.util.IpConfig;

public class EmployeeDetailActivity extends AppCompatActivity {

    final String url = "http://" + IpConfig.ipConfig + "/image/staff?name=";

    private String phoneNumber;
    ImageView imgDetail;
    Button btnCall, btnSendMess;
    TextView name, birthdate, role, address, email, nameStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);
        reflect();
        callFunction();
        sendMessageFunction();
    }

    public void reflect() {
        Intent intent = getIntent();
        ModelEmployee employeeDTO = (ModelEmployee) intent.getSerializableExtra("StaffInfo");
        imgDetail = (ImageView) findViewById(R.id.imgEmpDetail);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnSendMess = (Button) findViewById(R.id.btnSendMessage);
        role = (TextView) findViewById(R.id.txtRole);
        name = (TextView) findViewById(R.id.txtNameEmpDetail);
        address = (TextView) findViewById(R.id.txtEmpDetailAddress);
        birthdate = (TextView) findViewById(R.id.txtBirthdateEmpDetail);
        email = (TextView) findViewById(R.id.txtEmpDetailEmail);
        nameStore = (TextView) findViewById(R.id.txtNameStore);

        Picasso.get().load(url + employeeDTO.getPhoto()).into(this.imgDetail);

        //Set Text
        role.setText(employeeDTO.getRole());
        name.setText(employeeDTO.getFullname());
        birthdate.setText(employeeDTO.getBirthdate());
        email.setText(employeeDTO.getEmail());
        nameStore.setText(employeeDTO.getStoreName());
        address.setText(employeeDTO.getAddress());
        phoneNumber = employeeDTO.getPhone();
    }

    public void getEmpInfor() {
        Intent intent = getIntent();

    }

    public void callFunction() {
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

    }

    public void sendMessageFunction() {
        btnSendMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentasd = new Intent();
                intentasd.setAction(Intent.ACTION_SENDTO);
                intentasd.putExtra("sms_body", "");
                intentasd.setData(Uri.parse("sms:" + phoneNumber));
                startActivity(intentasd);
            }
        });

    }
}
