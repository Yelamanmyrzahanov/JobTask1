package kz.djunglestones.jobtask;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderBreakDownRecyclerViewAdapter extends RecyclerView.Adapter<OrderBreakDownRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Tickets> ticketsList;
    private Dialog dialog;
    private TextView pop_up_ticket_buy_ticket_btn,pop_up_ticket_amount_total,pop_up_amount_ticket,pop_up_ticket_name;
    private ImageButton pop_up_minus_ticket,pop_up_add_ticket;
    private int pop_up_ticket_amount_counter=0;
    private Button pop_up_buy_ticket;
    private  int total_ticket_amount_const;
    private int total_bought_tickets_counter = 0;
    private int total_bought_tickets_price_counter=0;
    TextView order_break_down_quantity_and_total;
    List<String> eventNameList = new ArrayList<>();
    Button order_break_down_complete_order_btn;
    private int amountOfTickets;
    private int clickedCardCouner = 0;

    public OrderBreakDownRecyclerViewAdapter(Context mContext, List<Tickets> ticketsList,TextView order_break_down_quantity_and_total,Button order_break_down_complete_order_btn) {
        this.mContext = mContext;
        this.ticketsList = ticketsList;
        this.order_break_down_quantity_and_total = order_break_down_quantity_and_total;
        this.order_break_down_complete_order_btn = order_break_down_complete_order_btn;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.tickets_item_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.order_break_down_ticket_price.setText(ticketsList.get(position).getTicketPrice()+" ₸");
        holder.order_break_down_ticket_name.setText(ticketsList.get(position).getTicketName());


        holder.cardView_tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_ticket_amount_const = ticketsList.get(position).getAmountOfTickets();
                amountOfTickets=ticketsList.get(position).getAmountOfTickets();


//                Toast.makeText(mContext,String.valueOf(ticketsList.get(position).getAmountOfTickets()),Toast.LENGTH_SHORT).show();
                pop_up_ticket_amount_counter=0;
                dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.order_break_down_pop_up);
                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                initPopupUI();

                pop_up_ticket_name.setText(ticketsList.get(position).getTicketName());
                pop_up_ticket_amount_total.setText("Осталось билетов: "+ticketsList.get(position).getAmountOfTickets());

                dialog.show();
                pop_up_add_ticket.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if (!holder.order_break_tickets_amount_tv.getText().toString().contains("+")){
////                            amountOfTickets = total_ticket_amount_const-clickedCardCouner;
//                            Toast.makeText(mContext,"HUina"+clickedCardCouner,Toast.LENGTH_SHORT).show();
//                            pop_up_ticket_amount_counter = clickedCardCouner;
//                        }
                        if (pop_up_ticket_amount_counter==total_ticket_amount_const || pop_up_ticket_amount_counter>total_ticket_amount_const){
//                            Toast.makeText(mContext,String.valueOf(pop_up_ticket_amount_counter)+ " EQual " + String.valueOf(total_ticket_amount_const),Toast.LENGTH_SHORT).show();
                            pop_up_ticket_amount_counter=total_ticket_amount_const;
                        }else{
                            pop_up_ticket_amount_counter+=1;
                            amountOfTickets-=1;
                            pop_up_amount_ticket.setText(String.valueOf(total_ticket_amount_const-amountOfTickets));
//                            ticketsList.get(position).setAmountOfTickets(ticketsList.get(position).getAmountOfTickets()-1);

                        }
//                        if (pop_up_ticket_amount_counter!=total_ticket_amount_const && pop_up_ticket_amount_counter!=0){
//                            pop_up_ticket_amount_counter = total_ticket_amount_const-pop_up_ticket_amount_counter;
//                        }else{
//                            pop_up_ticket_amount_counter=0;
//                        }


                        if (pop_up_ticket_amount_counter>=0 && amountOfTickets>=0 && pop_up_ticket_amount_counter+amountOfTickets==total_ticket_amount_const){
                            pop_up_ticket_amount_total.setText("Осталось билетов: "+amountOfTickets);
                            pop_up_amount_ticket.setText(String.valueOf(total_ticket_amount_const-amountOfTickets));
                        }

                    }
                });

                pop_up_minus_ticket.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if (!holder.order_break_tickets_amount_tv.getText().toString().contains("+")){
////                            amountOfTickets = total_ticket_amount_const-clickedCardCouner;
//                            Toast.makeText(mContext,"HUina"+clickedCardCouner,Toast.LENGTH_SHORT).show();
//                            pop_up_ticket_amount_counter = clickedCardCouner;
//                        }
                        if (pop_up_ticket_amount_counter>0){
                            pop_up_ticket_amount_counter-=1;
                            amountOfTickets+=1;
                            pop_up_amount_ticket.setText(String.valueOf(total_ticket_amount_const-amountOfTickets));
//                            ticketsList.get(position).setAmountOfTickets(ticketsList.get(position).getAmountOfTickets()+1);

                        }else if (pop_up_ticket_amount_counter==0){
                            pop_up_ticket_amount_counter=0;
                        }

                        if (pop_up_ticket_amount_counter>=0 && amountOfTickets>=0 && pop_up_ticket_amount_counter+amountOfTickets==total_ticket_amount_const){
                            pop_up_ticket_amount_total.setText("Осталось билетов: "+amountOfTickets);
                        }

                    }
                });

                pop_up_buy_ticket.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eventNameList.add(ticketsList.get(position).getTicketName());
                        ticketsList.get(position).setAmountOfTickets(total_ticket_amount_const-pop_up_ticket_amount_counter);
//                        Toast.makeText(mContext,ticketsList.get(position).getTicketName(),Toast.LENGTH_SHORT).show();
                        holder.order_break_tickets_amount_tv.setText(String.valueOf(pop_up_ticket_amount_counter));
                        clickedCardCouner = pop_up_ticket_amount_counter;
                        total_bought_tickets_counter+=pop_up_ticket_amount_counter;
                        total_bought_tickets_price_counter+=pop_up_ticket_amount_counter*ticketsList.get(position).getTicketPrice();
                        order_break_down_quantity_and_total.setText("Количество: "+String.valueOf(total_bought_tickets_counter)+"\nИтого: "+total_bought_tickets_price_counter);
                        dialog.dismiss();
                    }
                });





            }
        });

        order_break_down_complete_order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,String.valueOf("Количество: "+String.valueOf(total_bought_tickets_counter)+"\nИтого: "+total_bought_tickets_price_counter),Toast.LENGTH_SHORT).show();
//                for (String string:eventNameList){
//                    Log.i("Counter: ", "eventNameList: "+string);
//                }
                Intent intent = new Intent(mContext,OrderCompleteActivity.class);
                intent.putStringArrayListExtra("event_ticket_types", (ArrayList<String>) eventNameList);
                intent.putExtra("ticket_amount",String.valueOf(total_bought_tickets_counter));
                intent.putExtra("ticket_date","Сб, Фев 13, 18:00");
                intent.putExtra("ticket_name","Семинар: как за 2 месяца выучить английский язык");
                mContext.startActivity(intent);


            }
        });

        if (ticketsList.get(position).getAmountOfTickets()==0){
            holder.cardView_tickets.setCardBackgroundColor(Color.parseColor("#fafafa"));
            holder.cardView_tickets.setClickable(false);
            holder.order_break_tickets_amount_tv.setText("");
            holder.relativeLayout.setBackgroundColor(Color.parseColor("#dfe2f1"));
            holder.order_break_down_ticket_price.setTextColor(Color.parseColor("#bfc4e3"));
            holder.order_break_down_ticket_name.setTextColor(Color.parseColor("#bfc4e3"));
            holder.sold_out_tickets_tv.setVisibility(View.VISIBLE);
        }
    }

    private void initPopupUI() {
        pop_up_ticket_name = dialog.findViewById(R.id.pop_up_ticket_name);
        pop_up_ticket_buy_ticket_btn = dialog.findViewById(R.id.pop_up_buy_ticket);
        pop_up_ticket_amount_total = dialog.findViewById(R.id.pop_up_ticket_amount_total);
        pop_up_amount_ticket = dialog.findViewById(R.id.pop_up_amount_ticket);
        pop_up_amount_ticket.setText(String.valueOf(pop_up_ticket_amount_counter));
        pop_up_minus_ticket = dialog.findViewById(R.id.pop_up_minus_ticket);
        pop_up_add_ticket = dialog.findViewById(R.id.pop_up_add_ticket);
        pop_up_buy_ticket = dialog.findViewById(R.id.pop_up_buy_ticket);

    }

    private void showPopUp() {

//        dialog.show();
    }

    @Override
    public int getItemCount() {
        return ticketsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView order_break_tickets_amount_tv,order_break_down_ticket_name,order_break_down_ticket_price;
        private CardView cardView_tickets;
        private TextView sold_out_tickets_tv;
        private RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.order_break_tickets_amount_relative_layout);
            cardView_tickets = itemView.findViewById(R.id.cardView_tickets);

            order_break_down_ticket_name = itemView.findViewById(R.id.order_break_down_ticket_name);
            order_break_down_ticket_price = itemView.findViewById(R.id.order_break_down_ticket_price);
            order_break_tickets_amount_tv = itemView.findViewById(R.id.order_break_tickets_amount_tv);

            sold_out_tickets_tv = itemView.findViewById(R.id.sold_out_tickets_tv);


        }
    }
}
