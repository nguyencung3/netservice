package project.cuongpg.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.util.IpConfig;

public class SettingActivity extends AppCompatActivity {
    final String url = "http://" + IpConfig.ipConfig + "/store/get-info?";
    public static Map<String, String> infoStore = new HashMap<>();

    TextView account, contact, chanagepass, logout, addressStore, nameStore;
    Button btnEdit;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        reflect();
        actionBar();
        getActionOnMenu();
    }

    private void updateView(String storeName, String address) {
        addressStore.setText("Address: " + address);
        nameStore.setText("Name Store " + storeName);
    }

    private void getStoreInfo(final Long idStore) {
        String url = this.url + "id=" + idStore;
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Return Json Object
        final Map<String, String> infoAccount = new HashMap<>();
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("REPONSE STORE : ", response.toString());
                if (response.toString() != null || !response.toString().equals("")) {
                    Log.e("STORE ", "GET STORE");
                    try {
                        String nameStore = response.getString("nameStore");
                        String address = response.getString("address");
                        String phone = response.getString("phone");
                        infoStore.put("id", idStore.toString());
                        infoStore.put("nameStore", nameStore);
                        infoStore.put("address", address);
                        infoStore.put("phone", phone);
                        updateView(nameStore, address);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Json reponse ", "Json Return null");
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SettingActivity.this, "Can't Get Store", Toast.LENGTH_LONG).show();
                        Log.e("Error Get Store Info ", error.toString());
                    }
                }
        );
        requestQueue.add(stringRequest);

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
        getStoreInfo(Long.parseLong(DashboardActivity.infoAccount.get("storeId")));
    }

    private void reflect() {
        toolbar = (Toolbar) findViewById(R.id.toolbarSetting);
        nameStore = (TextView) findViewById(R.id.txtNameStore);
        addressStore = (TextView) findViewById(R.id.txtAddressStoreSetting);
        account = (TextView) findViewById(R.id.accountSetting);
        contact = (TextView) findViewById(R.id.contactSetting);
        chanagepass = (TextView) findViewById(R.id.changePasswordSetting);
        logout = (TextView) findViewById(R.id.logoutSetting);
//        btnEdit = (Button) findViewById(R.id.btnEditSetting);
    }

    private void getActionOnMenu() {
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentAccount = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intentAccount);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContact = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(intentContact);
            }
        });
        chanagepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentChangePass = new Intent(getApplicationContext(), ChangePassword.class);
                startActivity(intentChangePass);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentLogout);
                DashboardActivity.infoAccount = null;
            }
        });
    }


}
