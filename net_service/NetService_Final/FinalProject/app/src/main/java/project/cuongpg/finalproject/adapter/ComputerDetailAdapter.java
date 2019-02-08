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
import project.cuongpg.finalproject.model.ModelComputerFee;
import project.cuongpg.finalproject.model.ModelFoodDrink;

public class ComputerDetailAdapter extends BaseAdapter{

    Context context;
    List<ModelComputerFee> computerFeeList;

    public ComputerDetailAdapter(Context context, List<ModelComputerFee> computerFeeList) {
        this.context = context;
        this.computerFeeList = computerFeeList;
    }

    @Override
    public int getCount() {
        return computerFeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return computerFeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView name,time,price;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.computer_fee_item, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.txtNameComputerDetail);
            viewHolder.time = (TextView) convertView.findViewById(R.id.txtTimeComputerDetail);
            viewHolder.price = (TextView) convertView.findViewById(R.id.txtPriceComputerDetail);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ModelComputerFee computerFee = computerFeeList.get(position);
        viewHolder.name.setText(computerFee.getCustomerName());
        viewHolder.time.setText(computerFee.getTime());
        final DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.price.setText(decimalFormat.format(computerFee.getPrice()) + " VND ");
        return convertView;
    }
}
