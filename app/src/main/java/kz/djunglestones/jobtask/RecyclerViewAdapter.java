package kz.djunglestones.jobtask;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    Context mContext;
    List<Link2Data> link2DataList;
    private Handler mHandler = new Handler();

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
//        holder.tag1.setText(link2DataList.get(position).getTag1());
//        holder.tag2.setText(link2DataList.get(position).getTag2());
        holder.mainImage.setImageResource(link2DataList.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(mContext,ViewEventActivity.class);
                        mContext.startActivity(intent);
                    }
                },200);

            }
        });
//        holder.share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext,EmptyActivity.class);
//                mContext.startActivity(intent);
//            }
//        });

//        holder.save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext,EmptyActivity.class);
//                mContext.startActivity(intent);
//            }
//        });

        holder.mainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(mContext,ViewEventActivity.class);
                        mContext.startActivity(intent);
                    }
                },200);

            }
        });

        holder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ViewEventActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.buy_tickets_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent buyTicketsIntent = new Intent(mContext,OrderBreakDownActivity.class);
                        mContext.startActivity(buyTicketsIntent);
                    }
                },200);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "Body text (Testing share button)";
                String shareSub = "Subject text (Testing share button)";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareSub);
                mContext.startActivity(Intent.createChooser(shareIntent,"Поделиться"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return link2DataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView info2, link4, info3, buy_tickets_btn;
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

            buy_tickets_btn = itemView.findViewById(R.id.buy_tickets_btn);
//            tag2 = itemView.findViewById(R.id.tag2);

            share = itemView.findViewById(R.id.share);
            save = itemView.findViewById(R.id.save);

            mainImage = itemView.findViewById(R.id.imageView);

        }
    }
}
