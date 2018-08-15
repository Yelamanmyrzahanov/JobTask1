package kz.djunglestones.jobtask;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class EventInfoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView title_event_info;
    private ViewPager viewPager;
    private PageAdapterEventInfo pageAdapterEventInfo;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        toolbar = findViewById(R.id.event_info_toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout_event_info);
        collapsingToolbarLayout.setTitleEnabled(false);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String title = intent.getStringExtra("event_name");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager_event_info);
        tabLayout = findViewById(R.id.event_info_tab_layout);

        pageAdapterEventInfo = new PageAdapterEventInfo(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapterEventInfo);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.event_info_menu,menu);

        MenuItem shareMenuItem = menu.findItem(R.id.event_share_menu_item);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
