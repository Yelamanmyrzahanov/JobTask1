package kz.djunglestones.jobtask;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderBreakDownRecyclerViewAdapter extends RecyclerView.Adapter<OrderBreakDownRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Tickets> ticketsList;
    private Dialog dialog;
    private TextView pop_up_ticket_buy_ticket_btn,pop_up_ticket_amount_total,pop_up_amount_ticket,pop_up_ticket_name;
    private Spinner pop_up_spinner;
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
    final private int maxTickets = 10;
    private Map<String,Integer> hashMap = new HashMap();
    private HashMap hashMap1 = new HashMap(hashMap);
    private ArrayList<Integer> positions = new ArrayList<Integer>();
    private int total_ticket_bought_price=0;
    private String equalStrings;
    private List<String> selectedTicketList;
    private int ticketPrice;
    private Map<Tickets,Boolean> selected = new HashMap<>();
    private int pos;
    private Map<Map<Tickets,Integer>,Integer> ticketTotal = new HashMap<>();

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

        Tickets ticket = ticketsList.get(holder.getAdapterPosition());

        holder.order_break_down_ticket_price.setText(ticket.getTicketPrice()+" ₸");
        holder.order_break_down_ticket_name.setText(ticket.getTicketName());
        holder.order_break_tickets_amount_tv.setText(String.valueOf(ticket.getTicketCount()));


        holder.cardView_tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_ticket_amount_const = ticketsList.get(position).getAmountOfTickets();
                amountOfTickets=ticketsList.get(position).getAmountOfTickets();
                final String ticketName = ticketsList.get(position).getTicketName();
                ticketPrice = ticketsList.get(position).getTicketPrice();


                final int itemPosition = holder.getAdapterPosition();
                selected.put(ticketsList.get(position),true);
                initPopupUI();
                pop_up_ticket_name.setText(ticketName);
                pop_up_ticket_amount_total.setText("Осталось билетов: "+String.valueOf(amountOfTickets));
                List<Integer> listOfTickets = new ArrayList<>();
                if (amountOfTickets<maxTickets){
                    for (int i=0;i<=amountOfTickets;i++){
                        listOfTickets.add(i);
                    }
                }else{
                    for (int i=0;i<=maxTickets;i++){
                        listOfTickets.add(i);
                    }
                }

                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(mContext,android.R.layout.simple_spinner_item,listOfTickets);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pop_up_spinner.setAdapter(arrayAdapter);
                pop_up_spinner.setSelection(0,false);
                final boolean firstSelect = true;
                pop_up_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String item = parent.getItemAtPosition(position).toString();
                        int ticket_amount_spinner = Integer.parseInt(item);

                        Tickets ticket = ticketsList.get(itemPosition);
                        ticket.setTicketCount(ticket_amount_spinner);
                        ticketsList.set(itemPosition, ticket);

                        
                        notifyItemChanged(itemPosition);

                        int totalCount = 0;
                        int total_Price = 0;
                        for (Tickets object : ticketsList) {
                            totalCount += object.ticketCount;
                            if (object.ticketCount>=0){
                                
                            }
                        }


                        order_break_down_quantity_and_total.setText("Количество: "+String.valueOf(totalCount)+"\n"+"Итого: "+total_Price);

                        holder.order_break_tickets_amount_tv.setText(item);
//                        setTotal();
                        if (ticket_amount_spinner>0){
                            order_break_down_complete_order_btn.setClickable(true);
                            order_break_down_complete_order_btn.setBackgroundColor(Color.parseColor("#63be87"));
                        }
                        dialog.dismiss();


                    }



                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        if (hashMap1.isEmpty()){
                            order_break_down_complete_order_btn.setClickable(false);
                            order_break_down_complete_order_btn.setBackgroundColor(Color.GRAY);
                        }
                    }

                });



//                pop_up_ticket_buy_ticket_btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//

//
//
//                        Log.d("bought_tickets_counter", "onClick: "+total_bought_tickets_counter);
//                        Log.d("ticket_bought_price", "onClick: "+total_ticket_bought_price);
//                        order_break_down_quantity_and_total.setText("Количество: "+String.valueOf(total_bought_tickets_counter)+"\n"+"Итого: "+total_ticket_bought_price);
//                        dialog.dismiss();
//                        order_break_down_complete_order_btn.setClickable(true);
//                        order_break_down_complete_order_btn.setBackgroundColor(Color.parseColor("#63be87"));
//                    }
//                });












            }
        });

        if (hashMap1.isEmpty()){
            order_break_down_complete_order_btn.setClickable(false);
            order_break_down_complete_order_btn.setBackgroundColor(Color.GRAY);
        }

        order_break_down_complete_order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,String.valueOf("Количество: "+String.valueOf(total_bought_tickets_counter)+"\nИтого: "+total_bought_tickets_price_counter),Toast.LENGTH_SHORT).show();
//                for (String string:eventNameList){
//                    Log.i("Counter: ", "eventNameList: "+string);
//                }


                Intent intent = new Intent(mContext,OrderCompleteActivity.class);
//
////                intent.putStringArrayListExtra("event_ticket_types", (ArrayList<String>) eventNameList);
////                intent.putExtra("ticket_amount",String.valueOf(total_bought_tickets_counter));
                intent.putExtra("map",hashMap1);
                intent.putExtra("ticket_date","Сб, Фев 13, 18:00");
                intent.putExtra("ticket_name","Семинар: как за 2 месяца выучить английский язык");
                mContext.startActivity(intent);


            }
        });

//        private void setTotal(){
//            for (int i=0;i<ticketsList.size();i++){
//                holder.order_break_tickets_amount_tv.getText()
//            }
////                        order_break_down_quantity_and_total.setText("Количество: "+String.valueOf(total_bought_tickets_counter)+"\n"+"Итого: "+total_ticket_bought_price);
//        }



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
        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.order_break_down_pop_up);
        pop_up_ticket_name = dialog.findViewById(R.id.pop_up_ticket_name);
        pop_up_ticket_buy_ticket_btn = dialog.findViewById(R.id.pop_up_buy_ticket);
        pop_up_ticket_amount_total = dialog.findViewById(R.id.pop_up_ticket_amount_total);
        pop_up_spinner = dialog.findViewById(R.id.pop_up_spinner);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();


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
