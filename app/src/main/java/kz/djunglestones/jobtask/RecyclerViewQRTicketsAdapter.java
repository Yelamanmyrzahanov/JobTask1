package kz.djunglestones.jobtask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewQRTicketsAdapter extends RecyclerView.Adapter<RecyclerViewQRTicketsAdapter.MyViewHolder> {
    Context context;
    List<QRTickets> qrTicketsList;

    public RecyclerViewQRTicketsAdapter(Context context, List<QRTickets> qrTicketsList) {
        this.context = context;
        this.qrTicketsList = qrTicketsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_view_qr_tickets,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.qr_code_ticket_type.setText(qrTicketsList.get(position).getTicketName());
        holder.qr_code_username.setText(qrTicketsList.get(position).getUsername());
        holder.qr_code_image.setImageResource(qrTicketsList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return qrTicketsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView qr_code_username,qr_code_ticket_type;
        private ImageView qr_code_image;
        public MyViewHolder(View itemView) {
            super(itemView);

            qr_code_username = itemView.findViewById(R.id.qr_code_username);
            qr_code_ticket_type = itemView.findViewById(R.id.qr_code_ticket_type);
            qr_code_image = itemView.findViewById(R.id.qr_code_image);

        }
    }
}
