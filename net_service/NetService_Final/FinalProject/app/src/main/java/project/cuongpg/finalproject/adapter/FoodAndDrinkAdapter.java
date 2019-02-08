package project.cuongpg.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import project.cuongpg.finalproject.R;
import project.cuongpg.finalproject.model.ModelFoodDrink;

public class FoodAndDrinkAdapter extends BaseAdapter {

    Context context;
    List<ModelFoodDrink> listCustomer;

    public FoodAndDrinkAdapter(Context context, List<ModelFoodDrink> listCustomer) {
        this.context = context;
        this.listCustomer = listCustomer;
    }

    @Override
    public int getCount() {
        return listCustomer.size();
    }

    @Override
    public Object getItem(int position) {
        return listCustomer.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView customerName, time, price, foodName, quantity;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.food_drink_item, null);
            viewHolder.customerName = (TextView) convertView.findViewById(R.id.txtCusNameFoodDetail);
            viewHolder.foodName = (TextView) convertView.findViewById(R.id.txtFoodNameFoodDetail);
            viewHolder.time = (TextView) convertView.findViewById(R.id.txtTimeFoodDetail);
            viewHolder.price = (TextView) convertView.findViewById(R.id.txtPriceFoodDetail);
            viewHolder.quantity = (TextView) convertView.findViewById(R.id.txtQuantityFoodDetail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ModelFoodDrink cus = listCustomer.get(position);
        viewHolder.customerName.setText(cus.getCustomerName());
        viewHolder.time.setText(cus.getTime());
        viewHolder.foodName.setText(cus.getFoodName());
        final DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.price.setText(decimalFormat.format(cus.getPrice()) + " VND ");
        viewHolder.quantity.setText(String.valueOf(cus.getQuantity()));
        return convertView;
    }
}

