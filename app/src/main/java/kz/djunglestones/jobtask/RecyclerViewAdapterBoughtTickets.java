package kz.djunglestones.jobtask;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapterBoughtTickets extends RecyclerView.Adapter<RecyclerViewAdapterBoughtTickets.MyViewHolder>{
    Context mContext;
    List<BoughtTickets> boughtTicketsList;

    public RecyclerViewAdapterBoughtTickets(Context mContext, List<BoughtTickets> boughtTicketsList) {
        this.mContext = mContext;
        this.boughtTicketsList = boughtTicketsList;
    }


    @Override
    public RecyclerViewAdapterBoughtTickets.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.bought_tickets_item_view,parent,false);
        RecyclerViewAdapterBoughtTickets.MyViewHolder myViewHolder = new RecyclerViewAdapterBoughtTickets.MyViewHolder(v);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.ticketDate.setText(boughtTicketsList.get(position).getDate());
        holder.ticketLocation.setText(boughtTicketsList.get(position).getLocation());
        holder.ticket_event_name.setText(boughtTicketsList.get(position).getEventName());
        holder.ticket_amount.setText(boughtTicketsList.get(position).getNumOfTickets()+" билет");
        holder.eventImageView.setImageResource(boughtTicketsList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return boughtTicketsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView ticketDate, ticketLocation, ticket_event_name, ticket_amount;
        private ImageView eventImageView;
        private CardView cardView;



        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.tickets_bought_cardview);
            ticketDate = itemView.findViewById(R.id.ticket_date);
            ticketLocation = itemView.findViewById(R.id.ticket_location);
            ticket_event_name = itemView.findViewById(R.id.ticket_event_name);
            ticket_amount = itemView.findViewById(R.id.ticket_amount);


            eventImageView = itemView.findViewById(R.id.ticket_image);

        }
    }
}
