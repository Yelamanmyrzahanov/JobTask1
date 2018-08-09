package kz.djunglestones.jobtask;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SettingsMainActivity extends AppCompatActivity implements View.OnClickListener{
    private android.support.v7.widget.Toolbar toolbar;
    private TextView push_notifications_settings,pin_code_settings,legal_settings,help_settings,ads_settings,feedback_settings,email_settings,phone_number_settings;
//    private ConstraintLayout first_constraint_layout_settings,second_constraint_layout_settings,third_constraint_layout_settings,fourth_constraint_layout_settings,fivth_constraint_layout_settings,sixth_constraint_layout_settings,sevent_constraint_layout_settings,eighth_constraint_layout_settings,nineth_constraint_layout_settings;

//    private static final int[] constraint_IDS = {
//            R.id.account_constraint_layout_settings,R.id.second_constraint_layout_settings,R.id.third_constraint_layout_settings,R.id.fourth_constraint_layout_settings,R.id.fivth_constraint_layout_settings,R.id.sixth_constraint_layout_settings,R.id.sevent_constraint_layout_settings,R.id.eighth_constraint_layout_settings,R.id.nineth_constraint_layout_settings
//    };

    private static final int[] textview_IDS = {
            R.id.push_notifications_settings,
            R.id.pin_code_settings,
            R.id.legal_settings,
            R.id.help_settings,
            R.id.ads_settings,
            R.id.feedback_settings,
            R.id.email_settings,
            R.id.phone_number_settings
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_main);
        toolbar = findViewById(R.id.settings_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Настройки");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int i:textview_IDS){
            TextView textView = findViewById(i);
            textView.setOnClickListener(this);
        }


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
        TextView textView = (TextView)v;
        String activ_name = textView.getText().toString();
        Intent blankIntent = new Intent(SettingsMainActivity.this,EmptyActivity.class);
        blankIntent.putExtra("activity_name",activ_name);
        startActivity(blankIntent);

    }
}
