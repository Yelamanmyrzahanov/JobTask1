package kz.djunglestones.jobtask;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.adroitandroid.chipcloud.ChipCloud;
import com.adroitandroid.chipcloud.ChipListener;
import com.adroitandroid.chipcloud.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity{
    private Toolbar settingsToolbar;
    private Button settings_music_category_btn,settings_business_category,settings_food_category,settings_community_category,settings_art_category,settings_films_media_category;
    private ImageButton settings_goForwardBtn;
    private TextView settings_text_theme;
    private int counter = 0;
    private List<Button> buttons;
//    private static final int[] BUTTON_IDS = {
//            R.id.settings_music_category,
//            R.id.settings_business_category,
//            R.id.settings_food_category,
//            R.id.settings_community_category,
//            R.id.settings_art_category,
//            R.id.settings_films_media_category,
//            R.id.settings_sport_and_fitness_category,
//            R.id.settings_health_and_beauty_category,
//            R.id.settings_science_and_tech_category,
//            R.id.settings_travel_and_tours_category,
//            R.id.settings_family_category,
//            R.id.settings_education_category,
//            R.id.settings_government_category,
//            R.id.settings_religion_category,
//            R.id.settings_charity_category,
//            R.id.settings_entertainment_category,
//            R.id.settings_training_category,
//            R.id.settings_fashion_and_style_category,
//            R.id.settings_active_rest_category,
//            R.id.settings_humor_category
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settingsToolbar = findViewById(R.id.settings_toolbar);
        setSupportActionBar(settingsToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final String[] themesArray = getResources().getStringArray(R.array.themes);


//        buttons = new ArrayList<Button>();
//        // or slightly better
//        // buttons = new ArrayList<Button>(BUTTON_IDS.length);
//        for(int id : BUTTON_IDS) {
//            Button button = (Button)findViewById(id);
//            button.setOnClickListener(this); // maybe
//            buttons.add(button);
//        }


        settings_goForwardBtn = findViewById(R.id.settings_goForwardBtn);
        settings_goForwardBtn.setVisibility(View.INVISIBLE);
        settings_text_theme = findViewById(R.id.settings_text_theme);



        ChipCloud chipCloud = findViewById(R.id.chip_cloud);
        new ChipCloud.Configure()
                .chipCloud(chipCloud)
                .selectedColor(Color.parseColor("#5f6cba"))
                .selectedFontColor(Color.parseColor("#ffffff"))
                .deselectedColor(Color.parseColor("#f2f2f2"))
                .deselectedFontColor(Color.parseColor("#707070"))
                .labels(themesArray)
                .mode(ChipCloud.Mode.MULTI)
                .allCaps(false)
                .gravity(ChipCloud.Gravity.CENTER)
                .typeface(Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf"))
                .chipListener(new ChipListener() {
                    @Override
                    public void chipSelected(int index) {
                        counter+=1;
                        settings_text_theme.setText("Количество выбранных вами тем: "+counter);
                        checkCounter(counter);
                        Log.i("CHIPSELECTED", "chipSelected: "+index);
                        String themeName = themesArray[index];
                        Log.i("CHIPSELECTED", "chipSelected: "+themeName);
                    }
                    @Override
                    public void chipDeselected(int index) {
                        //...
                        Log.i("CHIPDESELECTED", "chipDESelected: "+index);
                        String themeName = themesArray[index];
                        Log.i("CHIPSELECTED", "chipSelected: "+themeName);
                        if (counter!=0){
                            counter-=1;
                            settings_text_theme.setText("Количество выбранных вами тем: "+counter);
                            checkCounter(counter);
                        }else{
                            counter = 0;
                            settings_text_theme.setText("Количество выбранных вами тем: "+counter);
                            checkCounter(counter);
                        }
                    }
                })
                .build();




    }

    private void checkCounter(int counter) {
        if(counter>=3){
            settings_goForwardBtn.setVisibility(View.VISIBLE);


            settings_goForwardBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mainIntent = new Intent(SettingsActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            });
        }else{
            settings_goForwardBtn.setVisibility(View.INVISIBLE);

        }
    }


//    @Override
//    public void onClick(View v) {
//        if (!v.isSelected()){
//            v.setSelected(true);
//            Button button = (Button)v;
//            button.setTextColor(Color.parseColor("#ffffff"));
//            counter+=1;
//
//        }else{
//            v.setSelected(false);
//            Button button = (Button)v;
//            button.setTextColor(Color.parseColor("#707070"));
//            if (counter!=0){
//                counter-=1;
//            }else{
//                counter = 0;
//
//            }
//        }
//        settings_text_theme.setText("Количество выбранных вами тем: "+counter);
//
//    }
}
