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
    private LayoutInflater mLayoutInflater;
    private List<TabRecycleViewData> mTabListView;

    public TabListAdapter(Context context, List<TabRecycleViewData> tabListView) {

        mContext = context;
        mTabListView = tabListView;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //[Comment] LayoutInflater.from(context)
    }

    @Override
    public Object getItem(int position) {
        return mTabListView.get(position);
    } //[Comment] Here you can return your model object

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

        View view = convertView; //[Comment] What this row actually do? Use convertview
        if(view == null) {
        view = mLayoutInflater.inflate(R.layout.recycler_item, parent, false); //[Comment] FORMATTING
        }
        //[Comment] VERY BAD. Use viewholder pattern for this adapter
        final TabRecycleViewData data = getTabRecyclerViewData(position);

        ((ImageView) view.findViewById(R.id.mark)).setImageResource(data.mMark);
        ((ImageView) view.findViewById(R.id.like)).setImageResource(data.mLike);
        ((TextView) view.findViewById(R.id.titles)).setText(data.mTitle);
        ((TextView) view.findViewById(R.id.adress)).setText(data.mAdress);
        ((TextView) view.findViewById(R.id.data)).setText(data.mData);
        ((TextView) view.findViewById(R.id.days)).setText(data.mDays);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.item_layout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InformationActivity.class);
                i.putExtra("viewData", data.getId());
                mContext.startActivity(i);
            }
        });

        return view;
    }

    private TabRecycleViewData getTabRecyclerViewData(int position) {
        return ((TabRecycleViewData) getItem(position));
    }
}
