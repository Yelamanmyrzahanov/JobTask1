package kz.djunglestones.jobtask;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

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
    private Uri mainImageUri;
    private TextView profile_username;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileToolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(profileToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        profile_username = findViewById(R.id.profile_username);


        avatarView5 = findViewById(R.id.profile_avatar);
        avatarView5.bind(profile_username.getText().toString(), "https://avatars2.githubusercontent.com");

        avatarView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
                    if (ContextCompat.checkSelfPermission(ProfileActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

                        Toast.makeText(ProfileActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(ProfileActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                    }
                    else{
                        CropImage.activity()
                                .setGuidelines(CropImageView.Guidelines.ON)
                                .setAspectRatio(1,1)
                                .start(ProfileActivity.this);

                    }
                }
            }
        });

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
        setCustomTabFont();
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

    private void setCustomTabFont() {
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
                    ((TextView) tabViewChild).setTypeface(mediumFont, Typeface.BOLD);
                    ((TextView) tabViewChild).setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
                }
            }
        }
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

        MenuItem settingsMenu = menu.findItem(R.id.settingsSubMenu);
        settingsMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent settingsIntent = new Intent(ProfileActivity.this,SettingsMainActivity.class);
                startActivity(settingsIntent);
                return true;
            }
        });

        MenuItem editProfileMenu = menu.findItem(R.id.editSubMenu);
        editProfileMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent editProfileIntent = new Intent(ProfileActivity.this,ProfileEditActivity.class);
                editProfileIntent.putExtra("first_name",profile_username.getText().toString());
                startActivity(editProfileIntent);
                return true;
            }
        });

        MenuItem logOutProfileMenu = menu.findItem(R.id.logOutSubMenu);
        logOutProfileMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setMessage("Вы действительно хотите выйти?").setCancelable(true).setPositiveButton("ДА", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProfileActivity.this,"Exit btn clicked",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("ОТМЕНА", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(ProfileActivity.this,"Cancel btn clicked",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                mainImageUri = result.getUri();
                avatarView5.bind("Yelaman Myrzakhanov", String.valueOf(mainImageUri));
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
