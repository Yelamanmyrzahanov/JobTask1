package kz.djunglestones.jobtask;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventInfoTicketFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<QRTickets> qrTicketsList;

    public EventInfoTicketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_event_info_ticket, container, false);

        recyclerView = v.findViewById(R.id.recyclerViewTicketsWithQR);

        RecyclerViewQRTicketsAdapter recyclerViewQRTicketsAdapter = new RecyclerViewQRTicketsAdapter(getContext(),qrTicketsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewQRTicketsAdapter);



        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventInfoActivity eventInfoActivity =(EventInfoActivity)getActivity();
        HashMap<String,Integer> hashMap = eventInfoActivity.getHashMapGlobal();
        int tickets_amount = eventInfoActivity.getTickets_amount_global();
        qrTicketsList = new ArrayList<>();
        Set set = hashMap.entrySet();
        Log.d("HASHMAP", "onCreate: "+hashMap);
        // Get an iterator
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            Log.i("KEY", "key : "+me.getKey());
            Log.i("Value", "value : "+me.getValue());
            //boolean isFirstTimeClicked = true;
            for (int k=0;k<(Integer)me.getValue();k++){
                qrTicketsList.add(new QRTickets("Nariman_duisekov", (String) me.getKey(),R.drawable.qrcode));
            }

            //boolean isFirstTimeClicked = true;



        }





    }
}
