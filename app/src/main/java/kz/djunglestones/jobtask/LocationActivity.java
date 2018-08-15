package kz.djunglestones.jobtask;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ConstraintLayout current_location_constraint;
    private RecyclerView recyclerView;
    private LocationRecyclerViewAdapter locationRecyclerViewAdapter;
    private List<City> cityList;
    private CollapsingToolbarLayout collapsing_toolbar_layout_location;

    private static final int REQUEST_CODE = 1000;
    private String latitude;
    private String longtitude;

//    FusedLocationProviderClient fusedLocationProviderClient;
//    LocationCallback locationCallback;
//    LocationRequest locationRequest;


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case REQUEST_CODE:
//                if (grantResults.length > 0) {
//                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
//
//                    }
//                }
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        toolbar = findViewById(R.id.location_toolbar);
        setSupportActionBar(toolbar);
//        collapsing_toolbar_layout_location = findViewById(R.id.collapsing_toolbar_layout_location);
//        collapsing_toolbar_layout_location.setTitle("Выберите город");
        getSupportActionBar().setTitle("Выберите город");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        current_location_constraint = findViewById(R.id.current_location_constraint);
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
//
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
//
//        } else {
////            if permission is granted
//            buildLocationRequest();
//            buildLocationCallback();
//            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(LocationActivity.this);
//            current_location_constraint.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(LocationActivity.this,"Waiting for Location",Toast.LENGTH_SHORT).show();
//                    if (ActivityCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                            && ActivityCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                        ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
//                        return;
//                    }
//                    fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());                }
//            });
//
//
//        }



        addCities();
        recyclerView = findViewById(R.id.recyclerView_location);
        locationRecyclerViewAdapter = new LocationRecyclerViewAdapter(LocationActivity.this,cityList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(locationRecyclerViewAdapter);

    }

//    private void buildLocationCallback() {
//        locationCallback = new LocationCallback(){
//
//            @Override
//            public void onLocationResult(LocationResult locationResult) {
//                for (Location location : locationResult.getLocations()){
////                    settext or get location for textview
//                    Toast.makeText(LocationActivity.this,String.valueOf(location.getLatitude())+"/"+String.valueOf(location.getLongitude()),Toast.LENGTH_SHORT).show();
//                    Double longtitude = location.getLongitude();
//                    Double latitude = location.getLatitude();
//                    try {
//                        getCityName(latitude,longtitude);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        };
//
//    }

    private void getCityName(Double latitude, Double longtitude) throws IOException {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = geocoder.getFromLocation(latitude, longtitude, 1);
        String cityName = addresses.get(0).getLocality();
        if (cityName == null){
            Toast.makeText(LocationActivity.this,"Waiting for Location",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent= new Intent();
            intent.putExtra("city_name_by_gps",cityName);
            LocationActivity.this.setResult(2,intent);
            LocationActivity.this.finish();
        }

    }

//    private void buildLocationRequest() {
//        locationRequest = new LocationRequest();
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        locationRequest.setInterval(5000);
//        locationRequest.setFastestInterval(3000);
//        locationRequest.setSmallestDisplacement(10);
//    }

    private void addCities() {
        cityList = new ArrayList<>();
        cityList.add(new City("Алматы"));
        cityList.add(new City("Астана"));
        cityList.add(new City("Актобе"));
        cityList.add(new City("Шымкент"));
        cityList.add(new City("Караганда"));
        cityList.add(new City("Усть-каменогорск"));
        cityList.add(new City("Кызылорда"));
        cityList.add(new City("Атырау"));
        cityList.add(new City("Актау"));
        cityList.add(new City("Костанай"));
        cityList.add(new City("Павлодар"));
        cityList.add(new City("Петропавловск"));
        cityList.add(new City("Семей"));
        cityList.add(new City("Талдыкорган"));
        cityList.add(new City("Тараз"));
        cityList.add(new City("Темиртау"));
        cityList.add(new City("Уральск"));
        cityList.add(new City("Рудный"));
        cityList.add(new City("Экибастуз"));
        cityList.add(new City("Туркестан"));
        cityList.add(new City("Жанаозен"));
        Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getCityName().compareTo(o2.getCityName());
            }
        });
    }
}
