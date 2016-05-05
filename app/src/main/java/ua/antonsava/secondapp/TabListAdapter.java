package ua.antonsava.secondapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.OnClick;

/**
 * Created by Apple on 22.04.2016.
 */
public class TabListAdapter extends BaseAdapter {

    private Context mContext;
    private List<TabRecycleViewData> mTabListView;

    public TabListAdapter(Context context, List<TabRecycleViewData> tabListView) {

        mContext = context;
        mTabListView = tabListView;
    }

    @Override
    public Object getItem(int position) {
        return mTabListView.get(position);
    }

    @Override
    public int getCount() {
        return mTabListView.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.recycler_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mImageIcon.setImageResource(mTabListView.get(position).getMark());
        holder.mTextTitle.setText(mTabListView.get(position).getTitle());
        holder.mTextAdress.setText(mTabListView.get(position).getAdress());
        holder.mTextData.setText(mTabListView.get(position).getData());
        holder.mTextDays.setText(mTabListView.get(position).getDays());
        holder.mImageLike.setImageResource(mTabListView.get(position).getLike());

        holder.mLinerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                mContext.startActivity(i);
            }
        });
        return convertView;
    }

    public class ViewHolder {
        ImageView mImageIcon;
        TextView mTextTitle;
        TextView mTextAdress;
        TextView mTextData;
        TextView mTextDays;
        ImageView mImageLike;
        LinearLayout mLinerLayout;

        public ViewHolder(View view) {
            mImageIcon = (ImageView) view.findViewById(R.id.mark);
            mTextTitle = (TextView) view.findViewById(R.id.titles);
            mTextAdress = (TextView) view.findViewById(R.id.adress);
            mTextData = (TextView) view.findViewById(R.id.data);
            mTextDays = (TextView) view.findViewById(R.id.days);
            mImageLike = (ImageView) view.findViewById(R.id.like);
            mLinerLayout = (LinearLayout) view.findViewById(R.id.item_layout);
        }
    }
}
