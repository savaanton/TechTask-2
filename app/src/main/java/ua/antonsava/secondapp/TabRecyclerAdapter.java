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
        mContext = context;
        mTabRecyclerList = tabList;
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
            mImageIcon = (ImageView) itemView.findViewById(R.id.mark);
            mTextTitle = (TextView) itemView.findViewById(R.id.titles);
            mTextAdress = (TextView) itemView.findViewById(R.id.adress);
            mTextData = (TextView) itemView.findViewById(R.id.data);
            mTextDays = (TextView) itemView.findViewById(R.id.days);
            mImageLike = (ImageView) itemView.findViewById(R.id.like);
            mLinerLayout = (LinearLayout) itemView.findViewById(R.id.item_layout);
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

        holder.mImageIcon.setImageResource(mTabRecyclerList.get(position).getMark());
        holder.mTextTitle.setText(mTabRecyclerList.get(position).getTitle());
        holder.mTextAdress.setText(mTabRecyclerList.get(position).getAdress());
        holder.mTextData.setText(mTabRecyclerList.get(position).getData());
        holder.mTextDays.setText(mTabRecyclerList.get(position).getDays());
        holder.mImageLike.setImageResource(mTabRecyclerList.get(position).getLike());

        holder.mLinerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTabRecyclerList.size();
    }
}
