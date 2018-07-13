package kz.djunglestones.jobtask;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.androidpagecontrol.PageControl;

import java.util.ArrayList;
import java.util.List;

public class SplashScreenActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private ImageButton goForward;
    private WelcomePageAdapter welcomePageAdapter;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mSlideViewPager = findViewById(R.id.slideViewPager);

        welcomePageAdapter = new WelcomePageAdapter(getSupportFragmentManager());
        mSlideViewPager.setAdapter(welcomePageAdapter);

        final PageControl pageControl = (PageControl) findViewById(R.id.page_control);
        pageControl.setViewPager(mSlideViewPager);
        pageControl.setPosition(pos);
        goForward = findViewById(R.id.btn_forward);
        goForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos<=3){
                    pos+=1;
                    pageControl.setPosition(pos);
                    if (pos==3){
                        pos+=1;
                    }
                }
                else if (pos==4){
                    Intent mainIntent = new Intent(SplashScreenActivity.this,MainActivity.class);
                    pos=0;
                    startActivity(mainIntent);
                    finish();

                }
                Log.i("COUNTER", "onClick: "+pos);
            }
        });
        mSlideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            boolean lastPageChange = false;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int lastIndex = welcomePageAdapter.getCount()-1;

                Log.d("POS", "onPageScrolled: "+position);
                if (lastPageChange && position == lastIndex){
                    Intent mainIntent = new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int lastIdx = welcomePageAdapter.getCount()-1;

                int currentItem = mSlideViewPager.getCurrentItem();
                if(currentItem == lastIdx && state ==1){

                    lastPageChange = true;


                }
                else {
                    lastPageChange = false;
                }

            }
        });
    }
}
