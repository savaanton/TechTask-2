package ua.antonsava.secondapp;



/**
 * Created by Apple on 20.04.2016.
 */
public class TabRecycleViewData {

    public int mMark;
    public int mLike;
    public String mTitle;
    public String mAdress;
    public String mData;
    public String mDays;

    public TabRecycleViewData(int mark, int like, String title,
                              String adress, String data, String days) {

        this.mMark = mark;
        this.mLike = like;
        this.mTitle = title;
        this.mAdress = adress;
        this.mData = data;
        this.mDays = days;

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {

        this.mTitle = title;
    }

    public int getLike() {
        return mLike;
    }

    public void setLike(int like) {

        this.mLike = like;
    }

    public int getMark() {
        return mMark;
    }

    public void setMark(int mark) {

        this.mMark = mark;
    }

    public String getAdress() {
        return mAdress;
    }

    public void setAdress(String adress) {

        this.mAdress = adress;
    }

    public String getData() {
        return mData;
    }

    public void setData(String data) {

        this.mData = data;
    }

    public String getDays() {
        return mDays;
    }

    public void setDays(String days) {

        this.mDays = days;
    }
}
