package kz.djunglestones.jobtask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;


public class EmptyActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView empty_text_placeholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        toolbar = findViewById(R.id.empty_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Empty Activity");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        empty_text_placeholder = findViewById(R.id.empty_text_placeholder);

        Intent intent = getIntent();
        String stringText = intent.getStringExtra("activity_name");

        empty_text_placeholder.setText(stringText);






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
