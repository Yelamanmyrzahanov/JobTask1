package kz.djunglestones.jobtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterActivity extends AppCompatActivity {
//    private ExpandableListView sort_by_expanded_menu,sort_by_date_expanded_menu;
//    private ExpandableListAdapter expandableListAdapterSortBy;
//    private ExpandableListAdapterDate expandableListAdapterDate;
//    private List<String> listDataHeaderSortBy, listDataHeaderDate;
//    private HashMap<String,List<String>> listHashSortBy,listHashDate;
    private Toolbar toolbar;
    private TextView filter_apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        toolbar = findViewById(R.id.filter_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        filter_apply = findViewById(R.id.apply_filter);
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
