package kz.djunglestones.jobtask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class LocationRecyclerViewAdapter extends RecyclerView.Adapter<LocationRecyclerViewAdapter.MyViewHolder>{
    private List<City> cityList;
    private Context context;

    public LocationRecyclerViewAdapter(Context context,List<City> cityList) {
        this.cityList = cityList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.location_item_view,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.cityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent mainIntent = new Intent(context,MainActivity.class);
//                mainIntent.putExtra("city_name",viewHolder.cityName.getText().toString());
//                ((Activity) context).setResult(RESULT_OK,mainIntent);
//                ((Activity) context).startActivityForResult(mainIntent,1);
//                ((Activity) context).finish();
                Intent intent= new Intent();
                intent.putExtra("city_name",viewHolder.cityName.getText().toString());
                ((Activity) context).setResult(RESULT_OK,intent);
                ((Activity) context).finish();
            }
        });
        viewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.putExtra("city_name",viewHolder.cityName.getText().toString());
                ((Activity) context).setResult(RESULT_OK,intent);
                ((Activity) context).finish();
//                Intent mainIntent = new Intent(context,MainActivity.class);
//                mainIntent.putExtra("city_name",viewHolder.cityName.getText().toString());
//                ((Activity) context).setResult(RESULT_OK,mainIntent);
//                ((Activity) context).startActivityForResult(mainIntent,1);
//                ((Activity) context).finish();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.cityName.setText(cityList.get(position).getCityName());

    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;
        ConstraintLayout constraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.location_card_city_name);
            constraintLayout = itemView.findViewById(R.id.location_card_item_view_constraint);
        }
    }
}
