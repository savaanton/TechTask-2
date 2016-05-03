package ua.antonsava.secondapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Apple on 20.04.2016.
 */
public class TabRecyclerAdapter extends RecyclerView.Adapter<TabRecyclerAdapter.ViewHolder> {

    private List<TabRecycleViewData> mTabRecyclerList;
    private Context mContext;

    public TabRecyclerAdapter(Context context, List<TabRecycleViewData> tabList) {
        this.mContext = context; //[Comment] Unnecessary "this"
        this.mTabRecyclerList = tabList; //[Comment] Unnecessary "this"
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageIcon;
        TextView mTextTitle;
        TextView mTextAdress;
        TextView mTextData;
        TextView mTextDays;
        ImageView mImageLike;
        LinearLayout mLinerLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mImageIcon = (ImageView) itemView.findViewById(R.id.mark); //[Comment] Unnecessary "this"
            this.mTextTitle = (TextView) itemView.findViewById(R.id.titles); //[Comment] Unnecessary "this"
            this.mTextAdress = (TextView) itemView.findViewById(R.id.adress); //[Comment] Unnecessary "this"
            this.mTextData = (TextView) itemView.findViewById(R.id.data); //[Comment] Unnecessary "this"
            this.mTextDays = (TextView) itemView.findViewById(R.id.days); //[Comment] Unnecessary "this"
            this.mImageLike = (ImageView) itemView.findViewById(R.id.like); //[Comment] Unnecessary "this"
            this.mLinerLayout = (LinearLayout) itemView.findViewById(R.id.item_layout); //[Comment] Unnecessary "this"
        }
    }

    @Override
    public TabRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TabRecyclerAdapter.ViewHolder holder, int position) {
       final TabRecycleViewData viewData = mTabRecyclerList.get(position);

        holder.mImageIcon.setImageResource(mTabRecyclerList.get(position).getmMark());
        holder.mTextTitle.setText(mTabRecyclerList.get(position).getmTitle());
        holder.mTextAdress.setText(mTabRecyclerList.get(position).getmAdress());
        holder.mTextData.setText(mTabRecyclerList.get(position).getmData());
        holder.mTextDays.setText(mTabRecyclerList.get(position).getmDays());
        holder.mImageLike.setImageResource(mTabRecyclerList.get(position).getmLike());

        //[Comment] VERY BAD. Make one listener for root view. Anyway you should not start activity from adapter
        holder.mLinerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                i.putExtra("viewData", viewData.getId()); //[Comment] Copy/Paste code
                mContext.startActivity(i);
            }
        });

        holder.mImageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                i.putExtra("viewData", viewData.getId()); //[Comment] Copy/Paste code
                mContext.startActivity(i);
            }
        });

        holder.mTextTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                i.putExtra("viewData", viewData.getId()); //[Comment] Copy/Paste code
                mContext.startActivity(i);
            }
        });

        holder.mTextData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                i.putExtra("viewData", viewData.getId()); //[Comment] Copy/Paste code
                mContext.startActivity(i);
            }
        });

        holder.mTextDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                i.putExtra("viewData", viewData.getId());//[Comment] Copy/Paste code
                mContext.startActivity(i);
            }
        });

        holder.mTextAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                i.putExtra("viewData", viewData.getId()); //[Comment] Copy/Paste code
                mContext.startActivity(i);
            }
        });

        holder.mImageLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                i.putExtra("viewData", viewData.getId()); //[Comment] Copy/Paste code
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTabRecyclerList.size();
    }
}
