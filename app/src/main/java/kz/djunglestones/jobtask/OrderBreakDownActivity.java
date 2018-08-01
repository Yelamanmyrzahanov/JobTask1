package kz.djunglestones.jobtask;

import android.app.Dialog;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class OrderBreakDownActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;
    private ConstraintLayout first_constraint_card;
    private Dialog dialog;
    private TextView pop_up_ticket_name,pop_up_ticket_price,pop_up_amount_ticket;
    private ImageButton pop_up_minus_ticket,pop_up_add_ticket;
    private Button pop_up_buy_ticket;
    private int pop_up_ticket_amount_counter=0;
    String pop_up_ticket_price_constant="";
    private TextView order_break_down_ticket_price,order_break_down_total_price,order_break_down_quantity_and_total,order_break_tickets_amount_tv,order_break_down_event_name,order_break_down_event_date;
    private Button order_break_down_complete_order_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_break_down);
        toolbar = findViewById(R.id.order_break_down_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Order breakdown");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        order_break_down_ticket_price = findViewById(R.id.order_break_down_ticket_price);
        order_break_down_total_price = findViewById(R.id.order_break_down_total_price);
        order_break_down_quantity_and_total = findViewById(R.id.order_break_down_quantity_and_total);
        order_break_tickets_amount_tv = findViewById(R.id.order_break_tickets_amount_tv);
        order_break_down_complete_order_btn = findViewById(R.id.order_break_down_complete_order_btn);
        order_break_down_event_name = findViewById(R.id.order_break_down_event_name);
        order_break_down_event_date = findViewById(R.id.order_break_down_event_date);


        order_break_down_complete_order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderCompleteIntent = new Intent(OrderBreakDownActivity.this,OrderCompleteActivity.class);
                orderCompleteIntent.putExtra("ticket_amount",String.valueOf(pop_up_ticket_amount_counter));
                orderCompleteIntent.putExtra("ticket_date",order_break_down_event_date.getText().toString());
                orderCompleteIntent.putExtra("ticket_name",order_break_down_event_name.getText().toString());
                startActivity(orderCompleteIntent);
            }
        });


        dialog = new Dialog(OrderBreakDownActivity.this);
        dialog.setContentView(R.layout.order_break_down_pop_up);
        pop_up_ticket_name = dialog.findViewById(R.id.pop_up_buy_ticket);
        pop_up_ticket_price = dialog.findViewById(R.id.pop_up_ticket_price);
        pop_up_ticket_price.setText(order_break_down_ticket_price.getText().toString());
        pop_up_ticket_price_constant= order_break_down_ticket_price.getText().toString();
        pop_up_amount_ticket = dialog.findViewById(R.id.pop_up_amount_ticket);
        pop_up_amount_ticket.setText(String.valueOf(pop_up_ticket_amount_counter));
        pop_up_minus_ticket = dialog.findViewById(R.id.pop_up_minus_ticket);
        pop_up_add_ticket = dialog.findViewById(R.id.pop_up_add_ticket);
        pop_up_buy_ticket = dialog.findViewById(R.id.pop_up_buy_ticket);

        pop_up_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order_break_down_total_price.setText(pop_up_ticket_price.getText().toString());
                order_break_tickets_amount_tv.setText(String.valueOf(pop_up_ticket_amount_counter));
                order_break_down_quantity_and_total.setText("Количество: "+String.valueOf(pop_up_ticket_amount_counter)+"\n"+"Итого: "+pop_up_ticket_price.getText().toString());
                dialog.dismiss();
            }
        });

        pop_up_add_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop_up_ticket_amount_counter += 1;
                pop_up_amount_ticket.setText(String.valueOf(pop_up_ticket_amount_counter));
                int price = Integer.parseInt(pop_up_ticket_price_constant.replaceAll("[\\D]", ""))*pop_up_ticket_amount_counter;
                pop_up_ticket_price.setText(String.valueOf(price)+" тг");
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
                pop_up_ticket_price.setText(String.valueOf(price)+" тг");



            }
        });

        first_constraint_card = findViewById(R.id.first_constraint_card);
        first_constraint_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });



    }
}
