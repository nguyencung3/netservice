package project.cuongpg.finalproject.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.util.IpConfig;

public class RevenueActivity extends AppCompatActivity implements View.OnClickListener {
    final String url = "http://" + IpConfig.ipConfig + "/order/get-revenue";

    private HashMap<String, String> infoAccount = (HashMap<String, String>) DashboardActivity.infoAccount;
    private CardView food, computer;
    private TextView txtTotalRevenue, txtTotalComputer, txtTotalFoodAndDrink, lastUpdated, dateRevenue;
    public static String txtDateRevenue;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        reflect();
        getDateRevenue();
        getCurrentRevenue();
        actionBar();


    }

    public static String toStringPrice(Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(price) + " VND";
    }


    private void getRevenueByDate(String date) {
        String url = this.url + "/date?dateTime=" + date;
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Return Json Object
        final Map<String, String> infoAccount = new HashMap<>();
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("REPONSE REVENUE : ", response.toString());
                if (response.toString() != null || !response.toString().equals("")) {
                    Log.e("REVENUE ", "GET REVENUE");
                    try {
                        Double totalComputerRevenue = response.getDouble("totalComputerFee");
                        Double totalFoodDrinkFeeRevenue = response.getDouble("totalFoodDrinkFee");
                        Double totalPromotionFee = response.getDouble("totalPromotionFee");
                        Double totalRevenue = totalComputerRevenue + totalFoodDrinkFeeRevenue - totalPromotionFee;
                        String currentDate = response.getString("currentDate");
                        txtTotalComputer.setText(toStringPrice(totalComputerRevenue));
                        txtTotalRevenue.setText(toStringPrice(totalRevenue));
                        txtTotalFoodAndDrink.setText(toStringPrice(totalFoodDrinkFeeRevenue));
                        lastUpdated.setText(simpleDateFormat.format(new Date()));


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
                        Toast.makeText(RevenueActivity.this, "Can't Get Revenue", Toast.LENGTH_LONG).show();
                        Log.e("Error Get Revenue ", error.toString());
                    }
                }
        );
        requestQueue.add(stringRequest);

    }

    private void getCurrentRevenue() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
                    Log.e("REVENUE ", "GET REVENUE");
                    try {
                        Double totalComputerRevenue = response.getDouble("totalComputerFee");
                        Double totalFoodDrinkFeeRevenue = response.getDouble("totalFoodDrinkFee");
                        Double totalPromotionFee = response.getDouble("totalPromotionFee");
                        Double totalRevenue = totalComputerRevenue + totalFoodDrinkFeeRevenue - totalPromotionFee;
                        String currentDate = response.getString("currentDate");
                        txtTotalComputer.setText(toStringPrice(totalComputerRevenue));
                        txtTotalRevenue.setText(toStringPrice(totalRevenue));
                        txtTotalFoodAndDrink.setText(toStringPrice(totalFoodDrinkFeeRevenue));
                        lastUpdated.setText(simpleDateFormat.format(new Date()));
                        dateRevenue.setText(currentDate);

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
                        Toast.makeText(RevenueActivity.this, "Can't Get Revenue", Toast.LENGTH_LONG).show();
                        Log.e("Error Get Revenue ", error.toString());
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
    }

    private void reflect() {
        toolbar = (Toolbar) findViewById(R.id.toolbarRevenue);
        food = (CardView) findViewById(R.id.foodAndDrinkRevenueId);
        computer = (CardView) findViewById(R.id.computerRevenueId);
        food.setOnClickListener(this);
        computer.setOnClickListener(this);
        toolbar.setTitle(infoAccount.get("fullName"));

        txtTotalRevenue = (TextView) findViewById(R.id.totalRevenue);
        txtTotalComputer = (TextView) findViewById(R.id.totalComputer);
        txtTotalFoodAndDrink = (TextView) findViewById(R.id.totalFoodAndDrink);
        dateRevenue = (TextView) findViewById(R.id.txtDateRevenue);
        lastUpdated = (TextView) findViewById(R.id.lastUpdatedRevenue);
    }

    private void getDateRevenue() {
        dateRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDate();
            }
        });
    }

    private void getDate() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(RevenueActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String date = simpleDateFormat.format(calendar.getTime());
                        dateRevenue.setText(date);
                        getRevenueByDate(date);

                    }
                }, nam, thang, ngay);
        datePickerDialog.show();

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.foodAndDrinkRevenueId:
                intent = new Intent(this, FoodAndDrinkActivity.class);
                txtDateRevenue = dateRevenue.getText().toString();
                startActivity(intent);
                break;
            case R.id.computerRevenueId:
                intent = new Intent(this, ComputerActivity.class);
                txtDateRevenue = dateRevenue.getText().toString();
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
