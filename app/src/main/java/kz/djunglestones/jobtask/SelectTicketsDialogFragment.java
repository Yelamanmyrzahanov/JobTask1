package kz.djunglestones.jobtask;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class SelectTicketsDialogFragment extends DialogFragment {

    private ImageButton plus;
    private ImageButton minus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            int total = args.getInt("total", 0);
            int current = args.getInt("current", 0);
        }


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_break_down_pop_up, container, false);
        plus = v.findViewById(R.id.pop_up_add_ticket);
        minus = v.findViewById(R.id.pop_up_minus_ticket);

        return v;
    }

    public static SelectTicketsDialogFragment newInstance(int total, int current, String title) {

        Bundle args = new Bundle();

        SelectTicketsDialogFragment fragment = new SelectTicketsDialogFragment();
        args.putInt("total", total);
        args.putInt("current", current);
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
