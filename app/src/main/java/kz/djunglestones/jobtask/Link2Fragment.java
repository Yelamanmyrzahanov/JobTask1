package kz.djunglestones.jobtask;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import id.zelory.compressor.Compressor;


/**
 * A simple {@link Fragment} subclass.
 */
public class Link2Fragment extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Link2Data> link2DataList;
//    private Button closePopUp,filterButton;
//    private TextView exitPopUp;
//    Dialog dialog;
    public Link2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_link2, container, false);
//        filterButton = v.findViewById(R.id.filterBtn);
//        dialog = new Dialog(getContext());
//        dialog.setContentView(R.layout.custom_pop_up);
//        exitPopUp = dialog.findViewById(R.id.pop_up_exit);
//        closePopUp = dialog.findViewById(R.id.buttonClosePopUp);
//        filterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.show();
//            }
//        });
//        exitPopUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
        recyclerView  = v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),link2DataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                ((MainActivity) getActivity()).onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                ((MainActivity) getActivity()).onScrolled(recyclerView, dx,dy);
//            }
//        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        File compressToFile = new Compressor(getContext()).compressToFile(R.drawable.);
        link2DataList = new ArrayList<>();
        link2DataList.add(new Link2Data("Сб, Фев 13, 18:00","Семинар: Как за 2 месяца выучить английский язык","Инфо 3",R.drawable.poster));
        link2DataList.add(new Link2Data("Инфо 5","Ccылка 5","Инфо 6",R.drawable.concert));
        link2DataList.add(new Link2Data("Инфо 5","Ccылка 5","Инфо 6",R.drawable.mount2));
        link2DataList.add(new Link2Data("Инфо 2","Ccылка 4","Инфо 3",R.drawable.mount7));
    }
}
