package project.cuongpg.finalproject.activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.util.IpConfig;

public class ProfileActivity extends AppCompatActivity {
    final String url = "http://" + IpConfig.ipConfig + "/staff/update/%7Bid%7D?";

    Toolbar toolbar;
    EditText fullname, address, phone, email;
    TextView birthdate, txtViewRole;
    Button btnChange;
    private DatePickerDialog.OnDateSetListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        reflect();
        actionBar();
        getBirthdate();
    }


    private void getBirthdate() {
        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay();
            }
        });
    }

    private void chonNgay() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(ProfileActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        birthdate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, nam, thang, ngay);
        datePickerDialog.show();

    }

    private void showSuccess() {
        Toast.makeText(ProfileActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
    }

    private void updateProfile(Long id, final String key, Object value) {
        // Make Request
        String url = this.url + "id=" + id + "&key=" + key + "&value=" + value.toString();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.PUT,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Loop through the array elements
                            String value = response.getString(key);
                            DashboardActivity.infoAccount.put(key, value);
                        } catch (JSONException e) {
                            Log.e("Json reponse ", "Json Return null");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(ProfileActivity.this, "Update Fail!", Toast.LENGTH_LONG).show();
                        Log.e("Error Update Profile ", error.toString());
                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateUI() {
        fullname.setText(DashboardActivity.infoAccount.get("fullName"));
        address.setText(DashboardActivity.infoAccount.get("address"));
        email.setText(DashboardActivity.infoAccount.get("email"));
        birthdate.setText(DashboardActivity.infoAccount.get("birthDate"));
        phone.setText(DashboardActivity.infoAccount.get("phone"));
        txtViewRole.setText(DashboardActivity.infoAccount.get("role"));
    }

    private void reflect() {
        toolbar = (Toolbar) findViewById(R.id.tootbarProfile);
        fullname = (EditText) findViewById(R.id.txtFullNameProfile);
        address = (EditText) findViewById(R.id.txtAddressProfile);
        phone = (EditText) findViewById(R.id.txtPhoneProfile);
        email = (EditText) findViewById(R.id.txtEmailProfile);
        birthdate = (TextView) findViewById(R.id.txtBirthdateProfile);
        btnChange = (Button) findViewById(R.id.btnUpdateProfile);
        txtViewRole = (TextView) findViewById(R.id.txtViewRole);
        updateUI();
    }

    private void confrimUpdatePass() {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirm Update");
//        alert.setTitle("Confirm Update");

        alert.setMessage("You want to Update your Profile ?");
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Long id = Long.parseLong(DashboardActivity.infoAccount.get("idUser"));

                if (!fullname.getText().toString().trim().toLowerCase().equals(DashboardActivity.infoAccount.get("fullName").trim().toLowerCase())) {
                    updateProfile(id, "fullName", fullname.getText().toString());
                }
                if (!address.getText().toString().trim().toLowerCase().equals(DashboardActivity.infoAccount.get("address").trim().toLowerCase())) {
                    updateProfile(id, "address", address.getText().toString());
                }
                if (!email.getText().toString().trim().toLowerCase().equals(DashboardActivity.infoAccount.get("email").trim().toLowerCase())) {
                    updateProfile(id, "email", email.getText().toString());
                }
                if (!birthdate.getText().toString().trim().toLowerCase().equals(DashboardActivity.infoAccount.get("birthDate").trim().toLowerCase())) {
                    updateProfile(id, "birthDate", birthdate.getText().toString());
                }
                if (!phone.getText().toString().trim().toLowerCase().equals(DashboardActivity.infoAccount.get("phone").trim().toLowerCase())) {
                    updateProfile(id, "phone", phone.getText().toString());
                }
                showSuccess();
            }
        });

        alert.show();
    }

    public void clickToUpdate(View view) {
        confrimUpdatePass();
    }
}

