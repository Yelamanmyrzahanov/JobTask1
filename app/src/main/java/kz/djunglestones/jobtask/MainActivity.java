package kz.djunglestones.jobtask;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TabItem link1,link2,link3;
    private ViewPager viewPager;
    private Spinner spinner;
    private BlankFragment blankFragment;
    private Link1Fragment link1Fragment;
    private SearchView searchView;
    private PageAdapter pageAdapter;
    MaterialSearchView materialSearchView;
    private boolean spinnerSelected;
    private PageBlankAdapter pageAdapter1;
    private LinearLayout tabLayout0,tabLayout1,tabLayout2;
    private TextView tabTextView0,tabTextView,tabTextView2;
    private ArrayAdapter<String> arrayAdapter;
    private Typeface mediumFont,linkFont;
    private ImageView profileImageMainActivity;
    private Dialog dialog;
    private Button closePopUp,filterButton;
    private TextView exitPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabLayout = findViewById(R.id.tab_layout);
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_pop_up);
        exitPopUp = dialog.findViewById(R.id.pop_up_exit);

        exitPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


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
                    tabTextView2.setTypeface(null, Typeface.BOLD);
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
//        TabLayout.Tab tab = tabLayout.getTabAt(2);
//        tab.select();
//        profileImageMainActivity = findViewById(R.id.profileImageMainActivity);
        spinner = findViewById(R.id.spinner);

        mediumFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        linkFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");

        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.custom_spinner_item,
                getResources().getStringArray(R.array.links)){

            public View getView(int position, View convertView, ViewGroup parent)
            {
                View v = super.getView(position, convertView, parent);
                ((TextView) v).setTypeface(mediumFont);//Typeface for normal view
                ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_SP,20);

                return v;
            }
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View v = super.getDropDownView(position, convertView, parent);
                ((TextView) v).setTypeface(mediumFont);//Typeface for dropdown view
                ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                return v;
            }

        };

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(arrayAdapter);



        setCustomFont();





        link1 =findViewById(R.id.link1);
        link2 =findViewById(R.id.link2);
        link3 =findViewById(R.id.link3);

        viewPager = findViewById(R.id.viewPager);
//        viewPager.setCurrentItem(2);



        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        pageAdapter.setSpinnerSelected(false);
        viewPager.setAdapter(pageAdapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        selectTab(2);
        changeLink1Color();

        materialSearchView = findViewById(R.id.search_view);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItem().toString().equals("")) {
                    changeLink1Color();
                    pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                    pageAdapter.setSpinnerSelected(true);
                    pageAdapter.notifyChangeInPosition(1);
                    pageAdapter.notifyDataSetChanged();
                    viewPager.setAdapter(pageAdapter);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//                    Log.i("MENU 1", "onItemSelected: MENU 1");
//                    Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//                    pageAdapter1 = new PageBlankAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
//                    viewPager.setAdapter(pageAdapter1);
//                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                } else if (spinner.getSelectedItem().toString().equals("Меню 2")) {
                    changeLink1Color();
                    pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                    pageAdapter.setSpinnerSelected(true);
                    pageAdapter.notifyChangeInPosition(1);
                    pageAdapter.notifyDataSetChanged();
                    viewPager.setAdapter(pageAdapter);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//                    Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//                    pageAdapter1 = new PageBlankAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
//                    viewPager.setCurrentItem(0);
//                    viewPager.setAdapter(pageAdapter1);
//                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                } else if (spinner.getSelectedItem().toString().equals("Меню 3")) {
                    changeLink1Color();
                    pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                    pageAdapter.setSpinnerSelected(true);
                    pageAdapter.notifyChangeInPosition(1);
                    pageAdapter.notifyDataSetChanged();
                    viewPager.setAdapter(pageAdapter);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//                    Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//                    pageAdapter1 = new PageBlankAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
//                    viewPager.setCurrentItem(0);
//                    viewPager.setAdapter(pageAdapter1);
//                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//                    spinnerSelected = true;
                }else {
                    changeLink1Color();
                    pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                    pageAdapter.setSpinnerSelected(false);
                    pageAdapter.notifyChangeInPosition(1);
                    pageAdapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(0);
                    viewPager.setAdapter(pageAdapter);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                    Log.i("MENU ", "onItemSelected: MENU ");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                replaceFragmentBlank(link1Fragment);
//                spinnerSelected = false;
            }
        });




//        profileImageMainActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent profileIntent = new Intent(MainActivity.this,ProfileActivity.class);
//                startActivity(profileIntent);
//            }
//        });





    }

    private void selectTab(int pageIndex) {
        tabLayout.setScrollPosition(pageIndex,0f,true);
        viewPager.setCurrentItem(pageIndex);
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    public void setCustomFont() {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();

        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);

            int tabChildsCount = vgTab.getChildCount();

            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    //Put your font in assests folder
                    //assign name of the font here (Must be case sensitive)
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf"));
                }
            }
        }
    }

    private void changeLink1Color() {
        tabLayout0 = (LinearLayout)((ViewGroup)
                tabLayout.getChildAt(0)).getChildAt(0);
        tabTextView0 = (TextView) tabLayout0.getChildAt(1);
        tabTextView0.setTextColor(Color.parseColor("#5f6cba"));
        tabLayout1 = (LinearLayout)((ViewGroup)
                tabLayout.getChildAt(0)).getChildAt(1);
        tabTextView = (TextView) tabLayout1.getChildAt(1);
        tabTextView.setTextColor(Color.parseColor("#675f6cba"));
        tabLayout2 = (LinearLayout)((ViewGroup)
                tabLayout.getChildAt(0)).getChildAt(2);
        tabTextView2 = (TextView) tabLayout2.getChildAt(1);
        tabTextView2.setTextColor(Color.parseColor("#675f6cba"));
    }

    private void replaceFragmentBlank(Fragment fragment) {
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewPager,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem menuSearch = menu.findItem(R.id.search_menu);
        materialSearchView.setMenuItem(menuSearch);
        MenuItem menuFilter = menu.findItem(R.id.filter_menu);
        menuFilter.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                dialog.show();
                return true;
            }
        });

        MenuItem menuHamburger = menu.findItem(R.id.hamburger_menu_main);
        MenuItem profileMenu = menu.findItem(R.id.profile_sub_menu);
        profileMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent profileIntent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(profileIntent);
                return true;
            }
        });

//        menuSearch.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                spinnerHide();
//                return true;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search_menu:
//                spinnerHide();
                Log.i("onOptionsItemSelected: ", "onOptionsItemSelected: SEARCH");
        }
        return super.onOptionsItemSelected(item);
    }
//
    @Override
    public void onBackPressed() {
        if (materialSearchView.isSearchOpen()) {
            spinner.setVisibility(View.VISIBLE);
            materialSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
//
    public void spinnerHide(){

//        spinner.setVisibility(View.GONE);
        materialSearchView.setVisibility(View.VISIBLE);

    }

}
