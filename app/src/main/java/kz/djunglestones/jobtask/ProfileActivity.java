package kz.djunglestones.jobtask;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.fahmisdk6.avatarview.AvatarView;

public class ProfileActivity extends AppCompatActivity {

    private Toolbar profileToolbar;
    private AvatarView avatarView5;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ProfileViewPagerAdapter profileViewPagerAdapter;
    private TextView tabTextView0,tabTextView,tabTextView2;
    private LinearLayout tabLayout0,tabLayout1,tabLayout2;
    private Typeface mediumFont,regularFont;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileToolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(profileToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        avatarView5 = (AvatarView) findViewById(R.id.profile_avatar);
        avatarView5.bind("Нариман Дуйсеков", "https://avatars2.githubusercontent.com");

        mediumFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        tabLayout = findViewById(R.id.profile_tablayout);
//        tabLayout0 = (LinearLayout)((ViewGroup)
//                tabLayout.getChildAt(0)).getChildAt(0);
//        tabTextView0 = (TextView) tabLayout0.getChildAt(1);
//        tabTextView0.setTextColor(Color.parseColor("#5f6cba"));
//        tabTextView0.setTypeface(mediumFont, Typeface.BOLD);

        viewPager = findViewById(R.id.profile_viewPager);
        profileViewPagerAdapter = new ProfileViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(profileViewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0){
                    tabLayout0 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(0);
                    tabTextView0 = (TextView) tabLayout0.getChildAt(1);
                    tabTextView0.setTextColor(Color.parseColor("#5f6cba"));
                    tabTextView0.setTypeface(mediumFont, Typeface.BOLD);
                    tabLayout1 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(1);
                    tabTextView = (TextView) tabLayout1.getChildAt(1);
                    tabTextView.setTextColor(Color.parseColor("#675f6cba"));
                    tabTextView.setTypeface(mediumFont, Typeface.BOLD);
                    tabLayout2 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(2);
                    tabTextView2 = (TextView) tabLayout2.getChildAt(1);
                    tabTextView2.setTextColor(Color.parseColor("#675f6cba"));
                    tabTextView2.setTypeface(mediumFont, Typeface.BOLD);
                }else if (tab.getPosition()==1){
                    tabLayout0 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(0);
                    tabTextView0 = (TextView) tabLayout0.getChildAt(1);
                    tabTextView0.setTextColor(Color.parseColor("#675f6cba"));
                    tabTextView0.setTypeface(mediumFont, Typeface.BOLD);
                    tabLayout1 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(1);
                    tabTextView = (TextView) tabLayout1.getChildAt(1);
                    tabTextView.setTextColor(Color.parseColor("#5f6cba"));
                    tabTextView.setTypeface(null, Typeface.BOLD);
                    tabTextView.setTypeface(mediumFont, Typeface.BOLD);
                    tabLayout2 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(2);
                    tabTextView2 = (TextView) tabLayout2.getChildAt(1);
                    tabTextView2.setTextColor(Color.parseColor("#675f6cba"));
                    tabTextView2.setTypeface(mediumFont, Typeface.BOLD);
                }else if (tab.getPosition()==2){
                    tabLayout0 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(0);
                    tabTextView0 = (TextView) tabLayout0.getChildAt(1);
                    tabTextView0.setTextColor(Color.parseColor("#675f6cba"));
                    tabTextView0.setTypeface(mediumFont, Typeface.BOLD);
                    tabLayout1 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(1);
                    tabTextView = (TextView) tabLayout1.getChildAt(1);
                    tabTextView.setTextColor(Color.parseColor("#675f6cba"));
                    tabTextView.setTypeface(null, Typeface.BOLD);
                    tabTextView.setTypeface(mediumFont, Typeface.BOLD);
                    tabLayout2 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(2);
                    tabTextView2 = (TextView) tabLayout2.getChildAt(1);
                    tabTextView2.setTextColor(Color.parseColor("#5f6cba"));
                    tabTextView2.setTypeface(mediumFont, Typeface.BOLD);
                }
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
        inflater.inflate(R.menu.profile_menu,menu);

        MenuItem  hamburger_menu= menu.findItem(R.id.hamburger_menu);
//        menuSearch.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                spinnerHide();
//                return true;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }


}
