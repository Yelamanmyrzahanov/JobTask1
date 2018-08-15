package kz.djunglestones.jobtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class LegalSettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_settings);

        toolbar = findViewById(R.id.legal_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Push-уведомления");
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
