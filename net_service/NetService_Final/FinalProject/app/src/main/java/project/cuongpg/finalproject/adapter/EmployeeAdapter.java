package project.cuongpg.finalproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.activity.EmployeeDetailActivity;
import project.cuongpg.finalproject.model.ModelEmployee;
import project.cuongpg.finalproject.util.IpConfig;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    final String url = "http://" + IpConfig.ipConfig + "/image/staff?name=";

    private Context mContext;
    private ArrayList<ModelEmployee> mList;

    public EmployeeAdapter(Context context, ArrayList<ModelEmployee> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.rv_employee_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelEmployee employeeDTO = mList.get(position);

        holder.item_name.setText("Name :" + String.valueOf(employeeDTO.getFullname()));
        holder.item_idStaff.setText("StaffID :" + String.valueOf(employeeDTO.getId()));
        holder.item_shift.setText("Working Shift :" + String.valueOf(employeeDTO.getWorkingShift()));
        holder.item_status.setText(String.valueOf(employeeDTO.getStatus()));
        holder.item_role.setText(String.valueOf(employeeDTO.getRole()));

        // Load Image And Set Image
        Picasso.get().load(url + employeeDTO.getPhoto()).into(holder.item_image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_name, item_status, item_idStaff, item_shift, item_role;

        public ViewHolder(View itemView) {
            super(itemView);

            item_idStaff = itemView.findViewById(R.id.item_idStaff);
            item_shift = itemView.findViewById(R.id.item_shift);
            item_image = itemView.findViewById(R.id.item_imageđâsd);
            item_name = itemView.findViewById(R.id.item_name);
            item_role = itemView.findViewById(R.id.item_role);
            item_status = itemView.findViewById(R.id.item_status);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, EmployeeDetailActivity.class);
                    intent.putExtra("StaffInfo", mList.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}
