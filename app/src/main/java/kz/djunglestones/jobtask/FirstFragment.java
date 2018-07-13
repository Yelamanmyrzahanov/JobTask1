package kz.djunglestones.jobtask;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment{


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public static FirstFragment newInstance(String text){
        FirstFragment firstFragment = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg",text);

        firstFragment.setArguments(b);

        return firstFragment;
    }

}
