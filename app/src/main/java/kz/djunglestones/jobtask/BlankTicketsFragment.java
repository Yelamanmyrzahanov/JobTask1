package kz.djunglestones.jobtask;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankTicketsFragment extends Fragment {
    View v;
    private TextView show_events_tv;
    public BlankTicketsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_blank_tickets, container, false);;
        show_events_tv = v.findViewById(R.id.show_events_tv);
        show_events_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getContext(),MainActivity.class);
                startActivity(mainIntent);
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

}
