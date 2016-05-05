package ua.antonsava.secondapp;

/**
 * Created by Apple on 05.05.2016.
 */
public enum State {
    STATUS_MAKES(R.string.makes),
    STATUS_DONE(R.string.done),
    STATUS_WAIT(R.string.wait);

    private int mStateName;

    State (int statusName){
        mStateName = statusName;
    }

    public int getStateName(){
        return mStateName;
    }
}
