package kz.djunglestones.jobtask;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ConstraintLayout current_location_constraint;
    private RecyclerView recyclerView;
    private LocationRecyclerViewAdapter locationRecyclerViewAdapter;
    private List<City> cityList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        toolbar = findViewById(R.id.location_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Enter your location");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        current_location_constraint = findViewById(R.id.current_location_constraint);
        addCities();
        recyclerView = findViewById(R.id.recyclerView_location);
        locationRecyclerViewAdapter = new LocationRecyclerViewAdapter(LocationActivity.this,cityList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(locationRecyclerViewAdapter);

    }

    private void addCities() {
        cityList = new ArrayList<>();
        cityList.add(new City("Алматы"));
        cityList.add(new City("Астана"));
        cityList.add(new City("Актау"));
        cityList.add(new City("Атырау"));
        cityList.add(new City("Шымкент"));
        cityList.add(new City("Тараз"));
        cityList.add(new City("Орал"));
        cityList.add(new City("Караганды"));
        cityList.add(new City("Алматы"));
        cityList.add(new City("Астана"));
        cityList.add(new City("Актау"));
        cityList.add(new City("Атырау"));
        cityList.add(new City("Шымкент"));
        cityList.add(new City("Тараз"));
        cityList.add(new City("Орал"));
        cityList.add(new City("Караганды"));
    }
}
