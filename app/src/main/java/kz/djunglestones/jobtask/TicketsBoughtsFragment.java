package kz.djunglestones.jobtask;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TicketsBoughtsFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<BoughtTickets> boughtTicketsList;


    public TicketsBoughtsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_tickets_boughts, container, false);
        // Inflate the layout for this fragment
        recyclerView = v.findViewById(R.id.ticketsBoughtRecyclerView);
        RecyclerViewAdapterBoughtTickets recyclerViewAdapterBoughtTickets = new RecyclerViewAdapterBoughtTickets(getContext(),boughtTicketsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterBoughtTickets);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boughtTicketsList = new ArrayList<>();
        boughtTicketsList.add(new BoughtTickets("Сб, Фев 13, 18:00","Семинар по анлийскому языку","Алматы",1,R.drawable.concert));
        boughtTicketsList.add(new BoughtTickets("Сб, Фев 13, 18:00","Семинар по анлийскому языку","Алматы",1,R.drawable.poster));
        boughtTicketsList.add(new BoughtTickets("Сб, Фев 13, 18:00","Семинар по анлийскому языку","Алматы",1,R.drawable.mount1));
        boughtTicketsList.add(new BoughtTickets("Сб, Фев 13, 18:00","Семинар по анлийскому языку","Алматы",1,R.drawable.concert));
        boughtTicketsList.add(new BoughtTickets("Сб, Фев 13, 18:00","Семинар по анлийскому языку","Алматы",1,R.drawable.poster));
        boughtTicketsList.add(new BoughtTickets("Сб, Фев 13, 18:00","Семинар по анлийскому языку","Алматы",1,R.drawable.mount1));

    }
}
