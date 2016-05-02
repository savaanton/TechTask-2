package ua.antonsava.secondapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 22.04.2016.
 */
public class InformationActivity extends AppCompatActivity {

    private TextView mTextSport;
    private TextView mTextStatus;
    private TextView mTextGroup;
    private TextView mTextSemiFinal;
    private TextView mTextChamp;
    private TextView mTextWinner;
    private TextView mTextGroupDay;
    private TextView mTextSemiFinalDay;
    private TextView mTextChampDay;
    private TextView mTextWinnerName;
    private TextView mTextDescription;
    private Toolbar mToolbar;
    private List<Integer> mImageList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private InformationAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_main);

        mToolbar = (Toolbar) findViewById(R.id.information_toolbar);
        setSupportActionBar(mToolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);


        reciveDataImage();
        mAdapter = new InformationAdapter(InformationActivity.this, mImageList);
        mRecyclerView.setAdapter(mAdapter);

        mTextSport = (TextView) findViewById(R.id.sport);
        mTextStatus = (TextView) findViewById(R.id.status);
        mTextGroup = (TextView) findViewById(R.id.group);
        mTextSemiFinal = (TextView) findViewById(R.id.semiFinal);
        mTextChamp = (TextView) findViewById(R.id.champ);
        mTextWinner = (TextView) findViewById(R.id.winner);
        mTextGroupDay = (TextView) findViewById(R.id.groupDay);
        mTextSemiFinalDay = (TextView) findViewById(R.id.semiFinalDay);
        mTextChampDay = (TextView) findViewById(R.id.champDay);
        mTextWinnerName = (TextView) findViewById(R.id.winnerName);
        mTextDescription = (TextView) findViewById(R.id.description);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InformationActivity.this, v.getClass().getSimpleName(), Toast.LENGTH_SHORT)
                        .show();
                }
        };

        mTextSport.setOnClickListener(onClickListener);
        mTextStatus.setOnClickListener(onClickListener);
        mTextGroup.setOnClickListener(onClickListener);
        mTextSemiFinal.setOnClickListener(onClickListener);
        mTextChamp.setOnClickListener(onClickListener);
        mTextWinner.setOnClickListener(onClickListener);
        mTextGroupDay.setOnClickListener(onClickListener);
        mTextSemiFinalDay.setOnClickListener(onClickListener);
        mTextChampDay.setOnClickListener(onClickListener);
        mTextWinnerName.setOnClickListener(onClickListener);
        mTextDescription.setOnClickListener(onClickListener);
    }

    private void reciveDataImage() {
        mImageList.add(R.drawable.ball);
        mImageList.add(R.drawable.champ);
    }
}
