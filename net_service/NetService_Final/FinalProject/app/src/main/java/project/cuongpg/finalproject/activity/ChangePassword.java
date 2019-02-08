package project.cuongpg.finalproject.activity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.util.IpConfig;

public class ChangePassword extends AppCompatActivity implements View.OnClickListener {
    final String url = "http://" + IpConfig.ipConfig + "/login/change-password?";

    Toolbar toolbar;
    EditText oldPass, newPass, confirmPass;
    Button btnChange;
    Boolean result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        reflect();
        actionToolbar();

    }

    private void showSuccess() {
        Toast.makeText(ChangePassword.this, "Update Successfully", Toast.LENGTH_SHORT).show();
    }

    private void changePassWord(String newPassword, Long id) {
        // Make Request
        String url = this.url + "id=" + id + "&password=" + newPassword;
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
                            String password = response.getString("password");
                            DashboardActivity.infoAccount.put("password", password);
                            result = true;
                            showSuccess();
                        } catch (JSONException e) {
                            Log.e("Json reponse ", "Json Return null");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(ChangePassword.this, "Change Password Fail!", Toast.LENGTH_LONG).show();
                        Log.e("Error Change Password ", error.toString());
                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);
    }

    public void reflect() {
        toolbar = (Toolbar) findViewById(R.id.toolbarChangePassword);
        oldPass = (EditText) findViewById(R.id.txtOldPassChangePass);
        newPass = (EditText) findViewById(R.id.txtNewPassChangePass);
        confirmPass = (EditText) findViewById(R.id.txtConfirmPassChangePass);
        btnChange = (Button) findViewById(R.id.btnChangePassword);

        btnChange.setOnClickListener(this);
    }

    public boolean validatePass() {
        String oldPassword = oldPass.getText().toString();
        String newPassword = newPass.getText().toString();
        String confirmPassword = confirmPass.getText().toString();
        if (!oldPassword.trim().toLowerCase().equals(DashboardActivity.infoAccount.get("password").toLowerCase().trim())) {
            Toast.makeText(ChangePassword.this, "Old Password Not Correctly", Toast.LENGTH_LONG).show();
            return false;
        }
        if (oldPassword.equals("") || newPassword.equals("") || confirmPassword.equals("")) {
            Toast.makeText(ChangePassword.this, "Please input password", Toast.LENGTH_LONG).show();
            return false;
        }
        if (oldPassword.equals(newPassword) || oldPassword.equals(confirmPassword)) {
            Toast.makeText(ChangePassword.this, "Old Pass have to be differnent New Pass or Confirm pass", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(ChangePassword.this, "New Pass and Confirm Pass have to be same", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void actionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void confrimUpdatePass() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirm Update");
//        alert.setTitle("Confirm Update");

        alert.setMessage("You want to Update your Password ?");
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changePassWord(newPass.getText().toString(), Long.parseLong(DashboardActivity.infoAccount.get("idUser")));
            }
        });

        alert.show();
    }

    @Override
    public void onClick(View v) {
        if (validatePass()) {
            confrimUpdatePass();
        }
    }
}
