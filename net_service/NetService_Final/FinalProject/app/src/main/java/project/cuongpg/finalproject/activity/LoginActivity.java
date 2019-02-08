package project.cuongpg.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.util.IpConfig;

public class LoginActivity extends AppCompatActivity {
    final String url = "http://" + IpConfig.ipConfig + "/login";

    RelativeLayout rellay1, rellay2;
    EditText email, password;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        reflect();

    }

    private void login(String url) {
        url += "?username=" + email.getText().toString() + "&password=" + password.getText().toString();
        // Make Request
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Return Json Object
        final Map<String, String> infoAccount = new HashMap<>();
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("REPONSE LOGIN : ", response.toString());
                if (response.toString() != null || !response.toString().equals("")) {
                    Log.e("LOGIN ", "Login Into");
                    try {

                        Log.e("ID-USER + ", response.getString("id"));
                        infoAccount.put("idUser", response.getString("id"));
                        infoAccount.put("email", response.getString("email"));
                        infoAccount.put("password", response.getString("password"));
                        infoAccount.put("fullName", response.getString("fullName"));
                        infoAccount.put("storeId", response.getString("storeId"));
                        infoAccount.put("phone", response.getString("phone"));
                        infoAccount.put("address", response.getString("address"));
                        infoAccount.put("role", response.getString("role"));
                        infoAccount.put("birthDate", response.getString("birthDate"));


                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.putExtra("infoUser", (Serializable) infoAccount);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Json reponse ", "chuỗi json trả về login bị null");
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Invalid Email or Password", Toast.LENGTH_LONG).show();
                        Log.e("error login ", error.toString());
                    }
                }
        );
        requestQueue.add(stringRequest);
    }

    public void clickToLogin(View view) {
        login(url);
    }

    public void reflect() {
        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);
        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
        email = (EditText) findViewById(R.id.txtEmail);
        password = (EditText) findViewById(R.id.txtPassword);
    }

}
