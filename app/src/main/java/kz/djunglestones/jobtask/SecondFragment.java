package kz.djunglestones.jobtask;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private Button skipBtn;
    View v;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_second, container, false);
        // Inflate the layout for this fragment
        skipBtn = v.findViewById(R.id.skip_button);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getContext(),MainActivity.class);
                getActivity().finish();
                startActivity(mainIntent);

            }
        });
        return v;
    }

    public static SecondFragment newInstance(String text){
        SecondFragment secondFragment= new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg",text);

        secondFragment.setArguments(b);

        return secondFragment;
    }

}
