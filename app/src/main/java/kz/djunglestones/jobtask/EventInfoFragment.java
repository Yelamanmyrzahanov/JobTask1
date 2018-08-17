package kz.djunglestones.jobtask;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventInfoFragment extends Fragment {
    View v;
    private Button event_info_buy_tickets_btn,event_info_company_contact_btn;
    private Dialog dialogPopUp;

    private ConstraintLayout company_pop_up_constraint_email,company_pop_up_constraint_phone;
    private TextView company_pop_up_phone,company_pop_up_email_tv;

    public EventInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_event_info, container, false);;
//        event_info_buy_tickets_btn = v.findViewById(R.id.event_info_buy_tickets_btn);
//        event_info_buy_tickets_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(),BuyTicketsActivity.class);
////                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
//                startActivity(intent);
//            }
//        });
        dialogPopUp = new Dialog(getContext());
        dialogPopUp.setContentView(R.layout.company_contacts_pop_up);
        company_pop_up_constraint_phone = dialogPopUp.findViewById(R.id.company_pop_up_constraint_phone);
        company_pop_up_phone = dialogPopUp.findViewById(R.id.company_pop_up_phone);
        company_pop_up_constraint_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+"+company_pop_up_phone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        company_pop_up_constraint_email = dialogPopUp.findViewById(R.id.company_pop_up_constraint_email);
        company_pop_up_email_tv = dialogPopUp.findViewById(R.id.company_pop_up_email_tv);
        company_pop_up_constraint_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                String shareBody = "Body text (Testing share button)";
//                String shareSub = "Subject text (Testing share button)";
//                shareIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{company_pop_up_email_tv.getText().toString()});
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
//                shareIntent.putExtra(Intent.EXTRA_TEXT,shareSub);
//                startActivity(Intent.createChooser(shareIntent,"Связаться"));



                Intent email = new Intent(Intent.ACTION_SEND);
//                email.setData(Uri.parse("mailto: "+company_pop_up_email_tv.getText().toString()));
//                startActivity(email);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{company_pop_up_email_tv.getText().toString()});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                try {
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
//                Intent email = new Intent(Intent.ACTION_SENDTO);
//                email.setData(Uri.parse("mailto: "+company_pop_up_email_tv.getText().toString()));
//                startActivity(email);
            }
        });
        event_info_company_contact_btn = v.findViewById(R.id.event_info_company_contact_btn);
        event_info_company_contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogPopUp.getWindow().setGravity(Gravity.CENTER);
                dialogPopUp.show();
            }
        });

        return v;
    }

}
