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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Link2Fragment extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Link2Data> link2DataList;
    private Button closePopUp,filterButton;
    private TextView exitPopUp;
    Dialog dialog;
    public Link2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_link2, container, false);
        filterButton = v.findViewById(R.id.filterBtn);
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_pop_up);
        exitPopUp = dialog.findViewById(R.id.pop_up_exit);
//        closePopUp = dialog.findViewById(R.id.buttonClosePopUp);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        exitPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        recyclerView  = v.findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),link2DataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        link2DataList = new ArrayList<>();
        link2DataList.add(new Link2Data("Инфо 2","Ccылка 4","Инфо 3","#tag1","#tag1",R.drawable.mount1));
        link2DataList.add(new Link2Data("Инфо 5","Ccылка 5","Инфо 6","#tag3","#tag4",R.drawable.mount2));
    }
}
