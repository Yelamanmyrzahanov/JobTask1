package kz.djunglestones.jobtask;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.zelory.compressor.Compressor;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    Context mContext;
    List<Link2Data> link2DataList;

    public RecyclerViewAdapter(Context mContext, List<Link2Data> link2DataList) {
        this.mContext = mContext;
        this.link2DataList = link2DataList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.info2.setText(link2DataList.get(position).getInfo2());
        holder.link4.setText(link2DataList.get(position).getLink4());
        holder.info3.setText(link2DataList.get(position).getInfo3());
        holder.tag1.setText(link2DataList.get(position).getTag1());
        holder.tag2.setText(link2DataList.get(position).getTag2());
        holder.mainImage.setImageResource(link2DataList.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,EmptyActivity.class);
                mContext.startActivity(intent);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,EmptyActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,EmptyActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.mainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,EmptyActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,EmptyActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return link2DataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView info2, link4, info3, tag1,tag2;
        private ImageView mainImage;
        private Button info;
        private ImageButton share,save;
        private CardView cardView;



        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);

            info = itemView.findViewById(R.id.info_btn);
            info2 = itemView.findViewById(R.id.info2_tv);
            link4 = itemView.findViewById(R.id.link4_tv);
            info3 = itemView.findViewById(R.id.info3_tv);

            tag1 = itemView.findViewById(R.id.tag1);
            tag2 = itemView.findViewById(R.id.tag2);

            share = itemView.findViewById(R.id.share);
            save = itemView.findViewById(R.id.save);

            mainImage = itemView.findViewById(R.id.imageView);

        }
    }
}
