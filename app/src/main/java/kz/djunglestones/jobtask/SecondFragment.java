package kz.djunglestones.jobtask;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private TextView skipBtn;
    View v;
    private EditText phone_main_editText;
    private EditText username;
    private EditText phone_code_edittext;
    private EditText email;


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

        phone_main_editText = v.findViewById(R.id.phone_main_editText);
        phone_main_editText.setTextColor(Color.BLACK);
        phone_code_edittext = v.findViewById(R.id.phone_code_edittext);
        phone_code_edittext.setTextColor(Color.BLACK);
        username = v.findViewById(R.id.name_editText);
        username.setHintTextColor(getResources().getColor(R.color.sec_frag_main_num_col));
        username.setTextColor(Color.BLACK);
//        username.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        email = v.findViewById(R.id.email_editText);
        email.setHintTextColor(getResources().getColor(R.color.sec_frag_main_num_col));
        email.setTextColor(Color.BLACK);
//        email.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        requestHint();

        return v;
    }

    private void requestHint() {
        
    }

    public static SecondFragment newInstance(String text){
        SecondFragment secondFragment= new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg",text);

        secondFragment.setArguments(b);

        return secondFragment;
    }

}
