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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.adapter.FoodAndDrinkAdapter;
import project.cuongpg.finalproject.adapter.StockAdapter;
import project.cuongpg.finalproject.model.ModelFoodDrink;
import project.cuongpg.finalproject.model.ModelProduct;
import project.cuongpg.finalproject.util.IpConfig;

public class StockActivity extends AppCompatActivity {

    final String url = "http://" + IpConfig.ipConfig + "/inventory/findAllGoods";
//    final String url = "http://pastebin.com/raw/Em972E5s";

    RecyclerView recyclerView;
    ArrayList<ModelProduct> productList, listSearch;
    StockAdapter stockAdapter;
    Toolbar toolbar;
    EditText searchGoodsName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        reflect();
        updateListView();
        actionBar();
        searchProductName();
    }

    private void updateListView() {
        getAllGoods();
    }

    public void searchProductName() {
        searchGoodsName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("Start + before + count ", start + " - " + before + " - " + count);
                if (s.toString().equals("")) {
                    getAllGoods();
                } else {
                    searchItemsProductName(s.toString().toLowerCase().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void getAllGoods() {
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
                            productList = new ArrayList<>();
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
                                JSONObject billDTO = response.getJSONObject(i);
                                // Get the current student (json object) data
                                Long id = billDTO.getLong("id");
                                String goodsName = billDTO.getString("goodName");
                                String unit = billDTO.getString("nameUnit");
                                Double quantity = billDTO.getDouble("quantityInStock");
//                                 billDTO.getDouble("costPrice");
                                Double costPrice = 0D;
                                String status = billDTO.getString("status");
                                productList.add(new ModelProduct(id, quantity, goodsName, status, unit, costPrice));

                            }
                            listSearch.clear();
                            listSearch.addAll(productList);
                            stockAdapter = new StockAdapter(StockActivity.this, productList);
                            recyclerView.setAdapter(stockAdapter);
                            stockAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            Log.e("Json reponse ", "Json Return null");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        Toast.makeText(StockActivity.this, "Not Goods In Stock", Toast.LENGTH_LONG).show();
                        Log.e("Error Get Revenue ", error.toString());
                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }

    public void searchItemsProductName(String s) {
        productList.clear();
        for (int i = 0; i < listSearch.size(); i++) {
            if (listSearch.get(i).getName().trim().toLowerCase().contains(s)) {
                productList.add(listSearch.get(i));
            }
        }
        stockAdapter.notifyDataSetChanged();
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
        toolbar = (Toolbar) findViewById(R.id.toolbarStock);
        recyclerView = (RecyclerView) findViewById(R.id.listViewProductInStock);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayoutmanager = layoutManager;
        recyclerView.setLayoutManager(rvLayoutmanager);

        productList = new ArrayList<>();
        listSearch = new ArrayList<>();
        searchGoodsName = (EditText) findViewById(R.id.searchGoodsName);


    }
}
