package kz.djunglestones.jobtask;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.custom_spinner_item,
                getResources().getStringArray(R.array.links));

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);;

        spinner.setAdapter(arrayAdapter);

        tabLayout = findViewById(R.id.tab_layout);

        link1 =findViewById(R.id.link1);
        link2 =findViewById(R.id.link2);
        link3 =findViewById(R.id.link3);

        viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        blankFragment = new BlankFragment();

        materialSearchView = findViewById(R.id.search_view);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItem().toString().equals("Меню 1")) {
                    Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    PageBlankAdapter pageAdapter1 = new PageBlankAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                    viewPager.setAdapter(pageAdapter1);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                } else if (spinner.getSelectedItem().toString().equals("Меню 2")) {
                    Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    PageBlankAdapter pageAdapter1 = new PageBlankAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                    viewPager.setCurrentItem(0);
                    viewPager.setAdapter(pageAdapter1);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                } else if (spinner.getSelectedItem().toString().equals("Меню 3")) {
                    Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    PageBlankAdapter pageAdapter1 = new PageBlankAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                    viewPager.setCurrentItem(0);
                    viewPager.setAdapter(pageAdapter1);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                }else {
                    pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                    viewPager.setCurrentItem(0);
                    viewPager.setAdapter(pageAdapter);
                    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                replaceFragmentBlank(link1Fragment);
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==1){
                    
                }else if (tab.getPosition()==2){

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
