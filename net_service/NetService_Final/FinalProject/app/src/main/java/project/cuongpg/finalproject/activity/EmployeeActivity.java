package project.cuongpg.finalproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.adapter.EmployeeAdapter;
import project.cuongpg.finalproject.model.ModelEmployee;
import project.cuongpg.finalproject.util.IpConfig;

public class EmployeeActivity extends AppCompatActivity {

    final String url = "http://" + IpConfig.ipConfig + "/staff/getAll";

    RecyclerView recyclerView;
    ArrayList<ModelEmployee> employeeList, listSearch;
    EmployeeAdapter employeeAdapter;
    Toolbar toolbar;
    EditText searchEmployeeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        reflect();
        actionBar();
        updateListView();
        searchEmployeeName();
    }

    private void updateListView() {
        getListEmployees();
    }

    public void searchEmployeeName() {
        searchEmployeeName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("Start + before + count ", start + " - " + before + " - " + count);
                if (s.toString().equals("")) {
                    getListEmployees();
                } else {
                    searchEmployee(s.toString().toLowerCase().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void searchEmployee(String s) {
        employeeList.clear();
        for (int i = 0; i < listSearch.size(); i++) {
            if (listSearch.get(i).getFullname().trim().toLowerCase().contains(s)) {
                employeeList.add(listSearch.get(i));
            }
        }
        employeeAdapter.notifyDataSetChanged();
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

    private void getListEmployees() {
        // Make Request
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Loop through the array elements
                            employeeList = new ArrayList<>();
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
                                JSONObject staffDTO = response.getJSONObject(i);
                                // Get the current student (json object) data
                                Long id = staffDTO.getLong("id");
                                String nameStaff = staffDTO.getString("fullName");
                                String namePhoto = staffDTO.getString("photo");
                                String workingShift = staffDTO.getString("workingShift");
                                String birthDate = staffDTO.getString("birthDate");
                                String role = staffDTO.getString("role");
                                String status = staffDTO.getString("status");
                                String nameStore = staffDTO.getString("nameStore");
                                String address = staffDTO.getString("address");
                                String phone = staffDTO.getString("phone");
                                String email = staffDTO.getString("email");

                                employeeList.add(new ModelEmployee(id, birthDate, status, nameStaff,
                                        namePhoto, workingShift, nameStore, role, address, phone, email));

                            }
                            listSearch.clear();
                            listSearch.addAll(employeeList);
                            employeeAdapter = new EmployeeAdapter(EmployeeActivity.this, employeeList);

                            recyclerView.setAdapter(employeeAdapter);
//                            stockAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            Log.e("Json reponse ", "Json Return null");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(EmployeeActivity.this, "Not Goods In Stock", Toast.LENGTH_LONG).show();
                        Log.e("Error Get Revenue ", error.toString());
                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }

    public void reflect() {
        searchEmployeeName = (EditText) findViewById(R.id.searchEmployeeName);
        toolbar = (Toolbar) findViewById(R.id.toolbarManageEmployee);
        recyclerView = (RecyclerView) findViewById(R.id.listViewEmployee);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayoutmanager = layoutManager;
        recyclerView.setLayoutManager(rvLayoutmanager);

        employeeList = new ArrayList<>();
        listSearch = new ArrayList<>();

        employeeAdapter = new EmployeeAdapter(this, employeeList);
        recyclerView.setAdapter(employeeAdapter);
    }
}
