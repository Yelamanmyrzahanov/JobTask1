package kz.djunglestones.jobtask;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class SettingsMainActivity extends AppCompatActivity{
    private android.support.v7.widget.Toolbar toolbar;
//    private ConstraintLayout first_constraint_layout_settings,second_constraint_layout_settings,third_constraint_layout_settings,fourth_constraint_layout_settings,fivth_constraint_layout_settings,sixth_constraint_layout_settings,sevent_constraint_layout_settings,eighth_constraint_layout_settings,nineth_constraint_layout_settings;

//    private static final int[] constraint_IDS = {
//            R.id.account_constraint_layout_settings,R.id.second_constraint_layout_settings,R.id.third_constraint_layout_settings,R.id.fourth_constraint_layout_settings,R.id.fivth_constraint_layout_settings,R.id.sixth_constraint_layout_settings,R.id.sevent_constraint_layout_settings,R.id.eighth_constraint_layout_settings,R.id.nineth_constraint_layout_settings
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_main);
        toolbar = findViewById(R.id.settings_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Настройки");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
