package kz.djunglestones.jobtask;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FourthFragment extends Fragment {

    public FourthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

//    public static FourthFragment newInstance(String text){
//        FourthFragment fragment= new FourthFragment();
//        Bundle b = new Bundle();
//        b.putString("msg",text);
//
//        fragment.setArguments(b);
//
//        return fragment;
//    }

}
