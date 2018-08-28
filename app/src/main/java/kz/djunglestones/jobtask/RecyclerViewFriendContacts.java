package kz.djunglestones.jobtask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewFriendContacts extends RecyclerView.Adapter<RecyclerViewFriendContacts.MyViewHolder>{

    Context mContext;
    List<UserContacts> userContactsList;

    public RecyclerViewFriendContacts(Context context, List<UserContacts> userContactsList) {
        this.mContext = context;
        this.userContactsList = userContactsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_view_contacts,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.contact_event.setText(userContactsList.get(position).getEventName());
        holder.contact_username.setText(userContactsList.get(position).getUserName());
        holder.contactCircleImageView.setImageResource(userContactsList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return userContactsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView contact_username,contact_event;
        private CircleImageView contactCircleImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            contact_event = itemView.findViewById(R.id.contact_event);
            contact_username = itemView.findViewById(R.id.contact_username);

            contactCircleImageView = itemView.findViewById(R.id.contact_image);
        }
    }
}
