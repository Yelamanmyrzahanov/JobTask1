package kz.djunglestones.jobtask;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {
    private EditText request_code_editText;
    View v;
    private TextView rulesAndTerms;
    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_third, container, false);
        rulesAndTerms = v.findViewById(R.id.rules_and_terms);
        rulesAndTerms.setMovementMethod(LinkMovementMethod.getInstance());
        request_code_editText = v.findViewById(R.id.request_code_editText);
        request_code_editText.setTextColor(Color.BLACK);
        return v;
    }


}
