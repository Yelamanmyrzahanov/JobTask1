package kz.djunglestones.jobtask;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class ViewEventActivity extends AppCompatActivity implements OnMapReadyCallback{
    private android.support.v7.widget.Toolbar viewEventToolbar;
    private RecyclerView recyclerView;
    private List<PopularCardview> popularCardviewList;
    LinearLayoutManager HorizontalLayout ;
    View ChildView ;
    int RecyclerViewItemPosition ;

    private Button company_contact_btn,event_buy_tickets_btn;
    private GoogleMap gmap;

    private Dialog dialogPopUp;
    private ConstraintLayout company_pop_up_constraint_email,company_pop_up_constraint_phone;
    private TextView company_pop_up_phone,company_pop_up_email_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        MapKitFactory.setApiKey("a06e97f7-dbaf-4444-a3e6-d0ff867c1edf");
//        a06e97f7-dbaf-4444-a3e6-d0ff867c1edf
//        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_view_event);

        viewEventToolbar = findViewById(R.id.viewEventToolbar);
        setSupportActionBar(viewEventToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        mapView = findViewById(R.id.event_mapView);
//        mapView.getMap().move(
//                new CameraPosition(new Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
//                new Animation(Animation.Type.SMOOTH,0),
//                null);



        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.event_mapView);
        mapFragment.getMapAsync(this);



        company_contact_btn = findViewById(R.id.company_contact_btn);
        company_contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogPopUp.getWindow().setGravity(Gravity.CENTER);
                dialogPopUp.show();
            }
        });

        dialogPopUp = new Dialog(ViewEventActivity.this);
        dialogPopUp.setContentView(R.layout.company_contacts_pop_up);
        company_pop_up_constraint_phone = dialogPopUp.findViewById(R.id.company_pop_up_constraint_phone);
        company_pop_up_phone = dialogPopUp.findViewById(R.id.company_pop_up_phone);
        company_pop_up_constraint_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+"+company_pop_up_phone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        company_pop_up_constraint_email = dialogPopUp.findViewById(R.id.company_pop_up_constraint_email);
        company_pop_up_email_tv = dialogPopUp.findViewById(R.id.company_pop_up_email_tv);
        company_pop_up_constraint_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
//                String shareBody = "Body text (Testing share button)";
//                String shareSub = "Subject text (Testing share button)";
//                shareIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{company_pop_up_email_tv.getText().toString()});
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
//                shareIntent.putExtra(Intent.EXTRA_TEXT,shareSub);
//                startActivity(Intent.createChooser(shareIntent,"Связаться"));

                Intent email = new Intent(Intent.ACTION_SEND);
//                email.setData(Uri.parse("mailto: "+company_pop_up_email_tv.getText().toString()));
//                startActivity(email);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{company_pop_up_email_tv.getText().toString()});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                try {
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(ViewEventActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        event_buy_tickets_btn = findViewById(R.id.event_buy_tickets_btn);
        event_buy_tickets_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewEventActivity.this,OrderBreakDownActivity.class);
                startActivity(intent);
            }
        });
//        exitPopUp = dialogPopUp.findViewById(R.id.pop_up_company_exit_btn);

//        exitPopUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialogPopUp.dismiss();
//            }
//        });




        addCard();

        recyclerView = findViewById(R.id.event_card_recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        PopularCardviewRecyclerAdapter popularCardviewRecyclerAdapter = new PopularCardviewRecyclerAdapter(ViewEventActivity.this,popularCardviewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewEventActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(popularCardviewRecyclerAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(ViewEventActivity.this,new GestureDetector.SimpleOnGestureListener(){
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.view_event_menu,menu);

        MenuItem shareMenuItem = menu.findItem(R.id.share_event_menu);
        MenuItem saveMenuItem = menu.findItem(R.id.save_event_menu);

        shareMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "Body text (Testing share button)";
                String shareSub = "Subject text (Testing share button)";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareSub);
                startActivity(Intent.createChooser(shareIntent,"Поделиться"));
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;

        LatLng seattle = new LatLng(43.237341,76.914951);
        gmap.addMarker(new MarkerOptions().position(seattle).title("SmartPoint"));
        gmap.moveCamera(CameraUpdateFactory.newLatLng(seattle));
        gmap.setMinZoomPreference(12);

    }


}
