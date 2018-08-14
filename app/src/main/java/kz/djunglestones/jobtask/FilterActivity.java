package kz.djunglestones.jobtask;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class FilterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
//    private ExpandableListView sort_by_expanded_menu,sort_by_date_expanded_menu;
//    private ExpandableListAdapter expandableListAdapterSortBy;
//    private ExpandableListAdapterDate expandableListAdapterDate;
//    private List<String> listDataHeaderSortBy, listDataHeaderDate;
//    private HashMap<String,List<String>> listHashSortBy,listHashDate;
    private Toolbar toolbar;
    private TextView filter_apply;
    private Button start_date_btn,end_date_btn;
    private boolean start_date_btn_clicked,end_date_btn_clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        toolbar = findViewById(R.id.filter_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        filter_apply = findViewById(R.id.apply_filter);
        filter_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        start_date_btn = findViewById(R.id.start_date);
        start_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_date_btn_clicked = true;
                android.support.v4.app.DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");


            }
        });

        end_date_btn = findViewById(R.id.end_date);
        end_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end_date_btn_clicked = true;
                android.support.v4.app.DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });


//        sort_by_expanded_menu = findViewById(R.id.sort_by_expanded_menu);
////        sort_by_expanded_menu.expandGroup(R.layout.expandablelist_group);
//        initData();
//        expandableListAdapterSortBy = new ExpandableListAdapter(this,listDataHeaderSortBy,listHashSortBy);
//        sort_by_expanded_menu.setAdapter(expandableListAdapterSortBy);
//
//        sort_by_date_expanded_menu = findViewById(R.id.sort_by_date_expanded_menu);
//        initDataDate();
//        expandableListAdapterDate = new ExpandableListAdapterDate(this,listDataHeaderDate,listHashDate);
//        sort_by_date_expanded_menu.setAdapter(expandableListAdapterDate);






    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentMonthString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        String month1 = c.getDisplayName(c.MONTH, c.LONG, Locale.getDefault());
        int day1 = c.get(c.DAY_OF_MONTH);
        String user_date = day1+" "+month1;
//        String[] choosen_date = currentMonthString.split(",");
//        String[] cur_date = choosen_date[1].split(" ");


        if (start_date_btn_clicked){
            start_date_btn.setText(user_date);
            start_date_btn_clicked =false;
        }
        if(end_date_btn_clicked){
            end_date_btn.setText(user_date);
            end_date_btn_clicked = false;
        }
    }

//    private void initDataDate() {
//
//        listDataHeaderDate = new ArrayList<>();
//        listHashDate = new HashMap<>();
//
//        listDataHeaderDate.add("Дата");
//
//        List<String> sort_byDate = new ArrayList<>();
//        sort_byDate.add("Все даты");
//        sort_byDate.add("Сегодня");
//        sort_byDate.add("Завтра");
//        sort_byDate.add("Выходные");
//        sort_byDate.add("Выберите дату");
//
//        listHashDate.put(listDataHeaderDate.get(0),sort_byDate);
//
//    }
//
//    private void initData() {
//
//        listDataHeaderSortBy = new ArrayList<>();
//        listHashSortBy = new HashMap<>();
//
//        listDataHeaderSortBy.add("Сортировать по");
//
//        List<String> sort_by = new ArrayList<>();
//        sort_by.add("Релевантности");
//        sort_by.add("Дате");
//
//        listHashSortBy.put(listDataHeaderSortBy.get(0),sort_by);
//
//
//    }
}
