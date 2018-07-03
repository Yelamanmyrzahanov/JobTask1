package kz.djunglestones.jobtask;

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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        spinner = findViewById(R.id.spinner);

        mediumFont = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
        linkFont = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf");




        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.custom_spinner_item,
                getResources().getStringArray(R.array.links)){

            public View getView(int position, View convertView, ViewGroup parent)
            {
                View v = super.getView(position, convertView, parent);
                ((TextView) v).setTypeface(mediumFont);//Typeface for normal view

                return v;
            }
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View v = super.getDropDownView(position, convertView, parent);
                ((TextView) v).setTypeface(mediumFont);//Typeface for dropdown view
                return v;
            }

        };

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(arrayAdapter);

        tabLayout = findViewById(R.id.tab_layout);
        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();

        setCustomFont();





        link1 =findViewById(R.id.link1);
        link2 =findViewById(R.id.link2);
        link3 =findViewById(R.id.link3);

        viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        pageAdapter.setSpinnerSelected(false);
        viewPager.setAdapter(pageAdapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        changeLink1Color();

        materialSearchView = findViewById(R.id.search_view);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItem().toString().equals("Меню 1")) {
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


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0){
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
                }else if (tab.getPosition()==1){
                    tabLayout0 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(0);
                    tabTextView0 = (TextView) tabLayout0.getChildAt(1);
                    tabTextView0.setTextColor(Color.parseColor("#675f6cba"));
                    tabLayout1 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(1);
                    tabTextView = (TextView) tabLayout1.getChildAt(1);
                    tabTextView.setTextColor(Color.parseColor("#5f6cba"));
                    tabLayout2 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(2);
                    tabTextView2 = (TextView) tabLayout2.getChildAt(1);
                    tabTextView2.setTextColor(Color.parseColor("#675f6cba"));
                }else if (tab.getPosition()==2){
                    tabLayout0 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(0);
                    tabTextView0 = (TextView) tabLayout0.getChildAt(1);
                    tabTextView0.setTextColor(Color.parseColor("#675f6cba"));
                    tabLayout1 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(1);
                    tabTextView = (TextView) tabLayout1.getChildAt(1);
                    tabTextView.setTextColor(Color.parseColor("#675f6cba"));
                    tabLayout2 = (LinearLayout)((ViewGroup)
                            tabLayout.getChildAt(0)).getChildAt(2);
                    tabTextView2 = (TextView) tabLayout2.getChildAt(1);
                    tabTextView2.setTextColor(Color.parseColor("#5f6cba"));
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
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf"));
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

        MenuItem menuSearch = menu.findItem(R.id.search);
        materialSearchView.setMenuItem(menuSearch);

        return super.onCreateOptionsMenu(menu);
    }
}
