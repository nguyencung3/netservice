package project.cuongpg.finalproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.activity.ComputerActivity2;
import project.cuongpg.finalproject.activity.StockActivity;
import project.cuongpg.finalproject.model.ModelNotification;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    public Context mContext;
    public ArrayList<ModelNotification> mList;

    public NotificationAdapter(Context context, ArrayList<ModelNotification> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.rv_notification_item, parent, false);
        NotificationAdapter.ViewHolder viewHolder = new NotificationAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final NotificationAdapter.ViewHolder holder, int position) {
        ModelNotification notificationList = mList.get(position);

        ImageButton detail = holder.btnDetail;
        TextView content;
        content = holder.tvContent;


        content.setText(notificationList.getContent());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (holder.getAdapterPosition() == 0) {
                    Intent intent = new Intent(mContext, StockActivity.class);
                    mContext.startActivity(intent);
                } else if (holder.getAdapterPosition() == 1) {
                    Intent intent = new Intent(mContext, StockActivity.class);
                    mContext.startActivity(intent);
                } else if (holder.getAdapterPosition() == 2) {
                    Intent intent = new Intent(mContext, ComputerActivity2.class);
                    mContext.startActivity(intent);
                } else {
                    Intent intent = new Intent(mContext, StockActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private ItemClickListener itemClickListener;
        private TextView tvContent;
        private ImageButton btnDetail;

        public ViewHolder(View itemView) {
            super(itemView);

            tvContent = itemView.findViewById(R.id.item_content);
            btnDetail = itemView.findViewById(R.id.item_detail);


            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}
