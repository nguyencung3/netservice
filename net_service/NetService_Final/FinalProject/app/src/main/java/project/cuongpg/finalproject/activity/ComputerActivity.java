package project.cuongpg.finalproject.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.adapter.ComputerDetailAdapter;
import project.cuongpg.finalproject.model.ModelComputerFee;
import project.cuongpg.finalproject.util.IpConfig;

public class ComputerActivity extends AppCompatActivity {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    final String url = "http://" + IpConfig.ipConfig + "/order/get-revenue/type-date?";
    private String txtDateRevenue = RevenueActivity.txtDateRevenue;

    List<ModelComputerFee> listSearch, listBill;
    ComputerDetailAdapter adapter;
    ListView listView;
    TextView fromDate, toDate, btnFilter, txtTotalRevenue;
    Toolbar toolbar;
    EditText searchCusName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computer_fee_activity);
        reflect();
        actionBar();
        getFromToDateBtnFilter();
        updateListView();
        searchCusName();
    }

    private void updateListView() {
        getListBillByDate();
    }

    public void searchCusName() {
        searchCusName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("Start + before + count ", start + " - " + before + " - " + count);
                if (s.toString().equals("")) {
                    getListBillByDate();
                } else {
                    searchItemsCusName(s.toString().toLowerCase().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void searchItemsCusName(String s) {
        listBill.clear();
        for (int i = 0; i < listSearch.size(); i++) {
            if (listSearch.get(i).getCustomerName().trim().toLowerCase().contains(s)) {
                listBill.add(listSearch.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void getListBillByDate() {
        String url = this.url + "from=" + fromDate.getText().toString() + "&to=" + toDate.getText().toString() + "&revenueType=tien";

        // Make Request
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Loop through the array elements
                            listBill = new ArrayList<>();
                            Double totalRevenue = response.getDouble("totalRevenue");
                            txtTotalRevenue.setText(RevenueActivity.toStringPrice(totalRevenue));
                            JSONArray jsonArray = response.getJSONArray("listRevenue");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                // Get current json object
                                JSONObject billDTO = jsonArray.getJSONObject(i);
                                // Get the current student (json object) data
                                String customerName = billDTO.getString("customerName");
                                if (customerName.equals("null")) customerName = "Guest";
                                String orderDate = billDTO.getString("orderDate");
                                Double price = billDTO.getDouble("unitPrice");
                                listBill.add(new ModelComputerFee(customerName, orderDate, price));

                            }
                            listSearch.clear();
                            listSearch.addAll(listBill);
                            adapter = new ComputerDetailAdapter(ComputerActivity.this, listBill);
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            Log.e("Json reponse ", "Json Return null");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(ComputerActivity.this, "Not Bill Now", Toast.LENGTH_LONG).show();
                        Log.e("Error Get Revenue ", error.toString());
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

    private void getFromToDateBtnFilter() {
        fromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDateFrom();
            }
        });
        toDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getToDate();
            }
        });
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateListView();
            }
        });
    }

    private void getDateFrom() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(ComputerActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        fromDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, nam, thang, ngay);
        datePickerDialog.show();

    }

    private void getToDate() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(ComputerActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        toDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, nam, thang, ngay);
        datePickerDialog.show();

    }

    private void reflect() {
        toolbar = (Toolbar) findViewById(R.id.toolbarComputer);
        fromDate = (TextView) findViewById(R.id.txtFromComputer);
        toDate = (TextView) findViewById(R.id.txtToComputer);
        btnFilter = (TextView) findViewById(R.id.btnFilterCombyDate);
        txtTotalRevenue = (TextView) findViewById(R.id.txtTotalRevenueComputer);
        listView = (ListView) findViewById(R.id.listViewComFeeDetail);
        searchCusName = (EditText) findViewById(R.id.searchCustomer);

        fromDate.setText(txtDateRevenue);
        toDate.setText(txtDateRevenue);

        listBill = new ArrayList<>();
        listSearch = new ArrayList<>();

//        String currentDate = simpleDateFormat.format(new Date());
//
//        fromDate.setText(currentDate);
//        toDate.setText(currentDate);

        adapter = new ComputerDetailAdapter(this, listBill);
        listView.setAdapter(adapter);
    }
}