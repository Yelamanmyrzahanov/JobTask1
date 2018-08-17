package kz.djunglestones.jobtask;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrderCompleteActivity extends AppCompatActivity {
    private Toolbar order_complete_toolbar;
    private RecyclerView recyclerView;
    private List<PopularCardview> popularCardviewList;
    View ChildView ;
    int RecyclerViewItemPosition ;
    private ConstraintLayout order_complete_cardview_ticket_constraint;
    private TextView order_complete_done;
    private TextView order_complete_card_ticket_amount,order_complete_date,order_complete_event_name;
    private CircleImageView whatsapp_circle,vkontakte_circle,email_circle;
    private ImageView more_options_circle;
    private TextView sms_circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        order_complete_toolbar = findViewById(R.id.order_complete_toolbar);
        setSupportActionBar(order_complete_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent intent = getIntent();
        String event_name = intent.getStringExtra("ticket_name");
        String event_date = intent.getStringExtra("ticket_date");
        String ticket_amount = intent.getStringExtra("ticket_amount");
        int ticket_amount_counter = Integer.parseInt(ticket_amount);

        order_complete_card_ticket_amount = findViewById(R.id.order_complete_card_ticket_amount);
        order_complete_date = findViewById(R.id.order_complete_date);
        order_complete_event_name = findViewById(R.id.order_complete_event_name);

        order_complete_event_name.setText(event_name);
        order_complete_date.setText(event_date);

        if (ticket_amount_counter>=1 && ticket_amount_counter<5){
            order_complete_card_ticket_amount.setText(ticket_amount+" билета");
        }else {
            order_complete_card_ticket_amount.setText(ticket_amount+" билетов");
        }


        order_complete_cardview_ticket_constraint = findViewById(R.id.order_complete_tickets_clickable_constraint);
        order_complete_cardview_ticket_constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompleteActivity.this,EventInfoActivity.class);
                intent.putExtra("event_name",order_complete_event_name.getText().toString());
                startActivity(intent);
            }
        });

        order_complete_done = findViewById(R.id.order_complete_done);
        order_complete_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompleteActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        whatsapp_circle = findViewById(R.id.whatsapp_circle);
//        whatsapp_circle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
//                whatsappIntent.setType("text/plain");
//                whatsappIntent.setPackage("com.whatsapp");
//                whatsappIntent.putExtra(Intent.EXTRA_TEXT,"Whatsapp Message Test");
//                try {
//                    startActivity(whatsappIntent);
//                }catch (android.content.ActivityNotFoundException ex){
//                    Toast.makeText(OrderCompleteActivity.this,"Whatsapp have not been installed.",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        vkontakte_circle = findViewById(R.id.vkontakte_circle);
//        vkontakte_circle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent vkontakteIntent = new Intent(Intent.ACTION_SEND);
//                vkontakteIntent.setType("text/plain");
//                vkontakteIntent.setPackage("com.vkontakte");
//                vkontakteIntent.putExtra(Intent.EXTRA_TEXT,"Vk Message Test");
//                try{
//                    startActivity(vkontakteIntent);
//                }catch (android.content.ActivityNotFoundException ex){
//                    Toast.makeText(OrderCompleteActivity.this,"VK have not been installed.",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        sms_circle = findViewById(R.id.sms_circle);
//        sms_circle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String smsBody="Sms Body";
//                Intent sendIntent = new Intent(Intent.ACTION_SEND);
//                sendIntent.setType("text/plain");
//                sendIntent.putExtra("sms_body", smsBody);
//                startActivity(Intent.createChooser(sendIntent,"Поделиться"));
//            }
//        });



//        email_circle = findViewById(R.id.email_circle);
//        email_circle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                String shareBody = "Body text (Testing share button)";
//                String shareSub = "Subject text (Testing share button)";
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
//                shareIntent.putExtra(Intent.EXTRA_TEXT,shareSub);
//                shareIntent.setType("message/rfc822");
//                startActivity(Intent.createChooser(shareIntent,"Поделиться"));
//            }
//        });

        more_options_circle = findViewById(R.id.more_options_circle);
        more_options_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "Body text (Testing share button)";
                String shareSub = "Subject text (Testing share button)";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareSub);
                startActivity(Intent.createChooser(shareIntent,"Поделиться"));
            }
        });


        addCard();

        recyclerView = findViewById(R.id.order_complete_recyclerview);
        PopularCardviewRecyclerAdapter popularCardviewRecyclerAdapter = new PopularCardviewRecyclerAdapter(OrderCompleteActivity.this,popularCardviewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(OrderCompleteActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(popularCardviewRecyclerAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(OrderCompleteActivity.this,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                ChildView = rv.findChildViewUnder(e.getX(),e.getY());
                if (ChildView != null && gestureDetector.onTouchEvent(e)){
                    RecyclerViewItemPosition = rv.getChildAdapterPosition(ChildView);
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });




    }

    private void addCard() {
        popularCardviewList = new ArrayList<>();
        popularCardviewList.add(new PopularCardview("Cб, 20 ФЕВ","Мастер-класс:\nКулинария","Almaty, ул.Фурманова",R.drawable.mount7));
        popularCardviewList.add(new PopularCardview("Cб, 20 ФЕВ","Мастер-класс:\nКулинария","Almaty, ул.Фурманова",R.drawable.mount7));
        popularCardviewList.add(new PopularCardview("Cб, 20 ФЕВ","Мастер-класс:\nКулинария","Almaty, ул.Фурманова",R.drawable.mount7));
    }
}
