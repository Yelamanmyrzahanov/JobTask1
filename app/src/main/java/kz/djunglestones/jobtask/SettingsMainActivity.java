package kz.djunglestones.jobtask;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsMainActivity extends AppCompatActivity implements View.OnClickListener{
    private android.support.v7.widget.Toolbar toolbar;
    private TextView push_notifications_settings,pin_code_settings,legal_settings,help_settings,ads_settings,feedback_settings,email_settings,phone_number_settings;
    private ConstraintLayout inviteFriendConstraint,legalConstraint,pushNotificationsConstraint;

    private static final int[] constraint_IDS = {
            R.id.account_constraint_layout_settings,R.id.fivth_constraint_layout_settings,R.id.sixth_constraint_layout_settings,R.id.sevent_constraint_layout_settings,R.id.eighth_constraint_layout_settings,R.id.nineth_constraint_layout_settings
    };

//    private static final int[] textview_IDS = {
//            R.id.push_notifications_settings,
//            R.id.pin_code_settings,
//            R.id.legal_settings,
//            R.id.help_settings,
//            R.id.ads_settings,
//            R.id.feedback_settings,
//            R.id.email_settings,
//            R.id.phone_number_settings
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_main);
        toolbar = findViewById(R.id.settings_main_toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout_settings_main);
        collapsingToolbarLayout.setTitleEnabled(false);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Настройки");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        for (int i:textview_IDS){
//            TextView textView = findViewById(i);
//            textView.setOnClickListener(this);
//        }

        initUI();


        inviteFriendConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
//                email.setData(Uri.parse("mailto: "+company_pop_up_email_tv.getText().toString()));
//                startActivity(email);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"nariman.duisekova@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "QEL. Все мероприятия страны - в твоём кармане!");
                email.putExtra(Intent.EXTRA_TEXT, "Привет!\n\nQEL - это крутая вещь, которая очень крутая.\n\nСкачать бесплатно\nhttps://www.qel.mobi/download");
                email.setType("text/plain");
                try {
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(SettingsMainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        legalConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent legalIntent = new Intent(SettingsMainActivity.this,LegalSettingsActivity.class);
                startActivity(legalIntent);
            }
        });

        pushNotificationsConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pushIntent = new Intent(SettingsMainActivity.this,PushNotificationsActivity.class);
                startActivity(pushIntent);
            }
        });

        for (int i:constraint_IDS){
            ConstraintLayout constraintLayout = findViewById(i);
            constraintLayout.setOnClickListener(this);
        }


    }

    private void initUI() {
        inviteFriendConstraint = findViewById(R.id.third_constraint_layout_settings);
        legalConstraint = findViewById(R.id.fourth_constraint_layout_settings);
        pushNotificationsConstraint = findViewById(R.id.second_constraint_layout_settings);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        ConstraintLayout constraintLayout = (ConstraintLayout)v;
        TextView textView = (TextView)((ViewGroup)constraintLayout).getChildAt(0);
        String activ_name = textView.getText().toString();
        Intent blankIntent = new Intent(SettingsMainActivity.this,EmptyActivity.class);
        blankIntent.putExtra("activity_name",activ_name);
        startActivity(blankIntent);

    }
}
