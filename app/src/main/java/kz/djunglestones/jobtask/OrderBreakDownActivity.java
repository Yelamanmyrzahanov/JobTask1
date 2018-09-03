package kz.djunglestones.jobtask;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderBreakDownActivity extends AppCompatActivity{
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

    private RecyclerView recyclerViewTickets;
    private List<Tickets> ticketsList;



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

        addTickets();
        OrderBreakDownRecyclerViewAdapter orderBreakDownRecyclerViewAdapter = new OrderBreakDownRecyclerViewAdapter(OrderBreakDownActivity.this,ticketsList,order_break_down_quantity_and_total,order_break_down_complete_order_btn);
        recyclerViewTickets.setLayoutManager(new LinearLayoutManager(OrderBreakDownActivity.this));
        recyclerViewTickets.setAdapter(orderBreakDownRecyclerViewAdapter);









    }

    private void addTickets() {
        ticketsList = new ArrayList<>();
        ticketsList.add(new Tickets("Cтандарт",5000,10));
        ticketsList.add(new Tickets("Limited",3000,0));
        ticketsList.add(new Tickets("Golden",2000,2));
        ticketsList.add(new Tickets("Silver",4000,11));
        ticketsList.add(new Tickets("Platinum",6000,10));
        ticketsList.add(new Tickets("Meduim",25000,50));
    }



    private void initUI() {

        order_break_down_complete_order_btn = findViewById(R.id.order_break_down_complete_order_btn);
        recyclerViewTickets = findViewById(R.id.order_break_down_tickets_recyclerview);
        order_break_down_quantity_and_total = findViewById(R.id.order_break_down_quantity_and_total);

    }

}
