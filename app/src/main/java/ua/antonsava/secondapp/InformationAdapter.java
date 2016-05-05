package ua.antonsava.secondapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Apple on 22.04.2016.
 */
public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {
    private List<Integer> mPictureList;
    private Context mContext;

    public InformationAdapter(Context context, List<Integer> imageList) {
        mPictureList = imageList;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mImageView = (ImageView) itemView.findViewById(R.id.picture);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.information_recycler_picture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageView pictureList = holder.mImageView;
        int src = mPictureList.get(position);
        Picasso.with(mContext).load(src).into(pictureList);
    }

    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
}
