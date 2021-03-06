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

import java.util.HashMap;

public class EventInfoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView title_event_info;
    private ViewPager viewPager;
    private PageAdapterEventInfo pageAdapterEventInfo;
    private TabLayout tabLayout;
    private int tickets_amount_global;
    private String titleGlobal;
    private HashMap<String, Integer> hashMapGlobal = new HashMap<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        toolbar = findViewById(R.id.event_info_toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout_event_info);
        collapsingToolbarLayout.setTitleEnabled(false);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        if (intent.getExtras()!=null){
            titleGlobal = intent.getStringExtra("event_name");
            hashMapGlobal = (HashMap<String, Integer>)intent.getSerializableExtra("map");
            tickets_amount_global = intent.getIntExtra("tickets_amount",0);
        }







        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(titleGlobal);
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

    public int getTickets_amount_global() {
        return tickets_amount_global;
    }

    public void setTickets_amount_global(int tickets_amount_global) {
        this.tickets_amount_global = tickets_amount_global;
    }

    public String getTitleGlobal() {
        return titleGlobal;
    }

    public void setTitleGlobal(String titleGlobal) {
        this.titleGlobal = titleGlobal;
    }

    public HashMap<String, Integer> getHashMapGlobal() {
        return hashMapGlobal;
    }

    public void setHashMapGlobal(HashMap<String, Integer> hashMapGlobal) {
        this.hashMapGlobal = hashMapGlobal;
    }
}
