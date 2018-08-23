package kz.djunglestones.jobtask;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderBreakDownActivity extends AppCompatActivity implements View.OnClickListener{
    private android.support.v7.widget.Toolbar toolbar;
    private ConstraintLayout first_constraint_card,second_constraint_layout_card;
    private Dialog dialog;
    private TextView pop_up_ticket_buy_ticket_btn,pop_up_ticket_price,pop_up_amount_ticket,pop_up_ticket_name;
    private ImageButton pop_up_minus_ticket,pop_up_add_ticket;
    private Button pop_up_buy_ticket;
    private int pop_up_ticket_amount_counter=0;
    private int clicked_index = 0;
    private String pop_up_ticket_price_constant="",ticket_type="",ticket_name="";
    private TextView order_break_down_ticket_price,order_break_down_total_price,order_break_down_quantity_and_total,order_break_tickets_amount_tv,order_break_down_event_name,order_break_down_event_date;
    private Button order_break_down_complete_order_btn;

    private static final int[] constraint_IDS = {
            R.id.first_constraint_card,
            R.id.general_cardview_constraint,
//            R.id.limited_cardview_constraint
    };

    private static final int[] event_name_textview_ids = {
            R.id.order_break_down_ticket_name,
            R.id.order_break_down_general_ticket_name,
//            R.id.order_break_down_limited_ticket_name
    };

    private static final int[] ticket_price = {
            R.id.order_break_down_ticket_price,
            R.id.order_break_down_general_ticket_price,
//            R.id.order_break_down_limited_ticket_price
    };

    private static final int[] ticketCounters={
            R.id.order_break_tickets_amount_tv,
            R.id.order_break_limited_tickets_amount_tv,
//            R.id.order_break_limited_tickets_amount_tv
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_break_down);
        toolbar = findViewById(R.id.order_break_down_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Оформить заказ");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();

        for (int i:constraint_IDS){
            ConstraintLayout constraintLayout = findViewById(i);
            constraintLayout.setOnClickListener(this);
        }



        order_break_down_complete_order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderCompleteIntent = new Intent(OrderBreakDownActivity.this,OrderCompleteActivity.class);
                orderCompleteIntent.putExtra("ticket_amount",String.valueOf(pop_up_ticket_amount_counter));
                orderCompleteIntent.putExtra("ticket_date",order_break_down_event_date.getText().toString());
                if (ticket_type != ""){
                    orderCompleteIntent.putExtra("ticket_type",ticket_type);
                    orderCompleteIntent.putExtra("ticket_name",ticket_name);
                }else{
                    orderCompleteIntent.putExtra("ticket_name",order_break_down_event_name.getText().toString());
                }
                startActivity(orderCompleteIntent);
            }
        });

        order_break_down_complete_order_btn.setBackground(ContextCompat.getDrawable(OrderBreakDownActivity.this, R.drawable.buy_ticket_radius_btn_grey));
        order_break_down_complete_order_btn.setClickable(false);


        pop_up_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_index == 1){
                    ticket_type = "general";
                    TextView textViewEventName = findViewById(event_name_textview_ids[1]);
                    ticket_name = textViewEventName.getText().toString();
                }else if(clicked_index == 0){
                    ticket_type = "base";
                    TextView textView1 = findViewById(event_name_textview_ids[0]);
                    ticket_name = textView1.getText().toString();
                }
                TextView ticketCountersTextView = findViewById(ticketCounters[clicked_index]);
                ticketCountersTextView.setText(String.valueOf(pop_up_ticket_amount_counter));
//                order_break_down_total_price.setText(pop_up_ticket_price.getText().toString().replaceAll("[\\D]", "")+" ₸");
//                order_break_tickets_amount_tv.setText(String.valueOf(pop_up_ticket_amount_counter));
                order_break_down_quantity_and_total.setText("Количество: "+String.valueOf(pop_up_ticket_amount_counter)+"\n"+pop_up_ticket_price.getText().toString());
                if (pop_up_ticket_amount_counter!=0){

                    order_break_down_complete_order_btn.setBackground(ContextCompat.getDrawable(OrderBreakDownActivity.this, R.drawable.buy_ticket_radius_button));
                    order_break_down_complete_order_btn.setClickable(true);

                }else{

                    order_break_down_complete_order_btn.setBackgroundColor(Color.GRAY);
                    order_break_down_complete_order_btn.setBackground(ContextCompat.getDrawable(OrderBreakDownActivity.this, R.drawable.buy_ticket_radius_btn_grey));

                }
                dialog.dismiss();
            }
        });

        pop_up_add_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop_up_ticket_amount_counter += 1;
                pop_up_amount_ticket.setText(String.valueOf(pop_up_ticket_amount_counter));
                int price = Integer.parseInt(pop_up_ticket_price_constant.replaceAll("[\\D]", ""))*pop_up_ticket_amount_counter;
                pop_up_ticket_price.setText("Итого: "+String.valueOf(price)+" ₸");
            }
        });

        pop_up_minus_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pop_up_ticket_amount_counter>0){
                    pop_up_ticket_amount_counter-=1;
                }else{
                    pop_up_ticket_amount_counter=0;
                }
                pop_up_amount_ticket.setText(String.valueOf(pop_up_ticket_amount_counter));
                int price = Integer.parseInt(pop_up_ticket_price_constant.replaceAll("[\\D]", ""))*pop_up_ticket_amount_counter;
                pop_up_ticket_price.setText("Итого: "+String.valueOf(price)+" ₸");



            }
        });







    }

    private void showPopUp() {
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private void initUI() {

        order_break_down_ticket_price = findViewById(R.id.order_break_down_ticket_price);
        order_break_down_total_price = findViewById(R.id.order_break_down_total_price);
        order_break_down_quantity_and_total = findViewById(R.id.order_break_down_quantity_and_total);
        order_break_tickets_amount_tv = findViewById(R.id.order_break_tickets_amount_tv);
        order_break_down_complete_order_btn = findViewById(R.id.order_break_down_complete_order_btn);
        order_break_down_event_name = findViewById(R.id.order_break_down_event_name);
        order_break_down_event_date = findViewById(R.id.order_break_down_event_date);

        dialog = new Dialog(OrderBreakDownActivity.this);
        dialog.setContentView(R.layout.order_break_down_pop_up);
        pop_up_ticket_name = dialog.findViewById(R.id.pop_up_ticket_name);
        pop_up_ticket_buy_ticket_btn = dialog.findViewById(R.id.pop_up_buy_ticket);
        pop_up_ticket_price = dialog.findViewById(R.id.pop_up_ticket_price);
        pop_up_ticket_price_constant= order_break_down_ticket_price.getText().toString();
        pop_up_amount_ticket = dialog.findViewById(R.id.pop_up_amount_ticket);
        pop_up_amount_ticket.setText(String.valueOf(pop_up_ticket_amount_counter));
        pop_up_minus_ticket = dialog.findViewById(R.id.pop_up_minus_ticket);
        pop_up_add_ticket = dialog.findViewById(R.id.pop_up_add_ticket);
        pop_up_buy_ticket = dialog.findViewById(R.id.pop_up_buy_ticket);

//        first_constraint_card = findViewById(R.id.first_constraint_card);
//        second_constraint_layout_card = findViewById(R.id.second_constraint_layout_card);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == constraint_IDS[1]){

            clicked_index = 1;
            pop_up_ticket_amount_counter=0;
            pop_up_amount_ticket.setText("0");
            pop_up_ticket_price.setText("Итого: "+String.valueOf(0)+" ₸");
            TextView textViewPrice = findViewById(ticket_price[1]);
            pop_up_ticket_price_constant = textViewPrice.getText().toString();
            TextView textView1 = findViewById(event_name_textview_ids[1]);
            pop_up_ticket_name.setText(textView1.getText().toString());
            showPopUp();

        }else if(v.getId() == constraint_IDS[0]){

            clicked_index = 0;
            pop_up_ticket_amount_counter = 0;
            pop_up_amount_ticket.setText("0");
            pop_up_ticket_price.setText("Итого: "+String.valueOf(0)+" ₸");
            TextView textViewPrice = findViewById(ticket_price[0]);
            pop_up_ticket_price_constant = textViewPrice.getText().toString();
            TextView textView1 = findViewById(event_name_textview_ids[0]);
            pop_up_ticket_name.setText(textView1.getText().toString());
            showPopUp();

        }
//        else if (v.getId() == constraint_IDS[2]){
//            clicked_index = 2;
//            pop_up_amount_ticket.setText("0");
//            pop_up_ticket_price.setText("Итого: "+String.valueOf(0)+" ₸");
//            TextView textView = v.findViewById(ticket_price[2]);
//            pop_up_ticket_price_constant = textView.getText().toString();
//            TextView textView1 = v.findViewById(event_name_textview_ids[2]);
//            pop_up_ticket_name.setText(textView1.getText().toString());
//            showPopUp();
//        }

    }
}
