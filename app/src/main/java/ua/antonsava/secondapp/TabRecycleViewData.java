package ua.antonsava.secondapp;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Apple on 20.04.2016.
 */
public class TabRecycleViewData {

    public static String mId;
    public int mMark;
    public int mLike;
    public String mTitle;
    public String mAdress;
    public String mData;
    public String mDays;

    public TabRecycleViewData(int mMark, int mLike, String mTitle,
                              String mAdress, String mData, String mDays) {

        this.mMark = mMark;
        this.mLike = mLike;
        this.mTitle = mTitle;
        this.mAdress = mAdress;
        this.mData = mData;
        this.mDays = mDays;

    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {

        this.mTitle = mTitle;
    }

    public int getmLike() {
        return mLike;
    }

    public void setmLike(int mLike) {

        this.mLike = mLike;
    }

    public int getmMark() {
        return mMark;
    }

    public void setmMark(int mMark) {

        this.mMark = mMark;
    }

    public String getmAdress() {
        return mAdress;
    }

    public void setmAdress(String mAdress) {

        this.mAdress = mAdress;
    }

    public String getmData() {
        return mData;
    }

    public void setmData(String mData) {

        this.mData = mData;
    }

    public String getmDays() {
        return mDays;
    }

    public void setmDays(String mDays) {
        this.mDays = mDays;
    }

    public static String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}
