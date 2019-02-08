package project.cuongpg.finalproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import project.cuongpg.finalproject.R;

import project.cuongpg.finalproject.model.ModelProduct;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ModelProduct> mList;

    public StockAdapter(Context context, ArrayList<ModelProduct> list){
        mContext = context;
        mList = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.stock_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelProduct productDTO = mList.get(position);
        holder.id.setText(String.valueOf(productDTO.getId()));
        holder.name.setText(productDTO.getName());
        DecimalFormat format = new DecimalFormat("###,###,###");
        holder.price.setText(format.format(productDTO.getCostPrice())+" VND ");
        holder.quantity.setText(String.valueOf(productDTO.getQuantity()));
        holder.unit.setText(productDTO.getUnit());
        String staus = productDTO.getStatus();
        Log.e("Status = ",staus);
        if(staus.equals("Almost over")){
            holder.status.setTextColor(Color.RED);
        }else{
            holder.status.setTextColor(Color.GREEN);
        }
        holder.status.setText(productDTO.getStatus());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView name,status,unit,price,quantity,id;
        public ViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txtProductIdInStock);
            name = itemView.findViewById(R.id.txtNameInStock);
            price = itemView.findViewById(R.id.txtPriceInStock);
            status = itemView.findViewById(R.id.txtStatusInStock);
            unit = itemView.findViewById(R.id.txtUnitInStock);
            quantity = itemView.findViewById(R.id.txtQuantityInStock);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(mContext, EmployeeDetailActivity.class);
//                    intent.putExtra("ProductInfo",mList.get(getPosition()));
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    mContext.startActivity(intent);
//                }
//            });

        }
    }
}

