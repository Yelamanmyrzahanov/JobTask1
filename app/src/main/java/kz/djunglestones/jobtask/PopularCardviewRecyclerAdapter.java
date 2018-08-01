package kz.djunglestones.jobtask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PopularCardviewRecyclerAdapter extends RecyclerView.Adapter<PopularCardviewRecyclerAdapter.MyViewHolder> {
    Context context;
    List<PopularCardview> popularCardviewList;

    public PopularCardviewRecyclerAdapter(Context context, List<PopularCardview> popularCardviewList) {
        this.context = context;
        this.popularCardviewList = popularCardviewList;
    }


    @Override
    public PopularCardviewRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(context).inflate(R.layout.horizontal_cardview_item,parent,false);
        PopularCardviewRecyclerAdapter.MyViewHolder myViewHolder = new PopularCardviewRecyclerAdapter.MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularCardviewRecyclerAdapter.MyViewHolder holder, int position) {

        holder.cardImage.setImageResource(popularCardviewList.get(position).getImage());
        holder.cardEventName.setText(popularCardviewList.get(position).getCard_event_name());
        holder.cardLocation.setText(popularCardviewList.get(position).getCard_location());
        holder.cardDate.setText(popularCardviewList.get(position).getCard_date());

    }

    @Override
    public int getItemCount() {
        return popularCardviewList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView cardDate,cardLocation,cardEventName;
        private ImageView cardImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardDate = itemView.findViewById(R.id.popular_card_date_tv);
            cardLocation = itemView.findViewById(R.id.popular_card_location);
            cardEventName = itemView.findViewById(R.id.popular_card_event_name_tv);

            cardImage = itemView.findViewById(R.id.popular_card_image);

        }
    }
}
