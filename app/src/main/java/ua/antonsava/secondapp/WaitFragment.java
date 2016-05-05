package ua.antonsava.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 20.04.2016.
 */
public class WaitFragment extends Fragment {

    private TabListAdapter mTabListAdapter;
    private static final String STATE_KEY = "ua.antonsava.secondapp.WaitFragment";


    public WaitFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater
            , ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.wait_layout, container, false);
        ListView mListView = (ListView) view.findViewById(R.id.list_view_tab);

        ArrayList data = receiveDataImage();
        mTabListAdapter = new TabListAdapter(getActivity(), data);
        mListView.setAdapter(mTabListAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), InformationActivity.class);
                startActivity(i);
            }
        });

        return view;
    }

    private ArrayList receiveDataImage() {

        ArrayList list = new ArrayList();
        list.add(new TabRecycleViewData(R.drawable.ic_sport, R.drawable.ic_like, "Спортивна подія"
                , "вул.Савченко 22, м.Дніпропетровськ", "22 квітня 2016", "7 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_sport, R.drawable.ic_like, "Спортивна подія"
                , "вул.Кедріна 47, м.Дніпропетровськ", "18 квітня 2016", "5 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_social, R.drawable.ic_like, "Соціальна подія"
                , "вул.Карла Маркса 60, м.Дніпропетровськ", "15 квітня 2016", "3 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_sport, R.drawable.ic_like, "Спортивна подія"
                , "вул.Глінкі 17, м.Дніпропетровськ", "17 квітня 2016", "12 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_sport, R.drawable.ic_like, "Спортивна подія"
                , "вул.Кедріна 47, м.Дніпропетровськ", "18 квітня 2016", "5 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_sport, R.drawable.ic_like, "Спортивна подія"
                , "вул.Шевченка 94, м.Дніпропетровськ ", "13 квітня 2016", "7 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_party, R.drawable.ic_like, "Розважальна подія"
                , "вул.Кірова 5, м.Дніпропетровськ ", "3 квітня 2016", "5 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_social, R.drawable.ic_like, "Соціальна подія"
                , "вул.Гагаріна 175, м.Дніпропетровськ ", "9 квітня 2016", "9 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_sport, R.drawable.ic_like, "Спортивна подія"
                , "вул.Тітова 1, м.Дніпропетровськ ", "9 квітня 2016", "5 днів"));
        list.add(new TabRecycleViewData(R.drawable.ic_party, R.drawable.ic_like, "Розважальна подія"
                , "вул.Робоча 122, м.Дніпропетровськ ", "3 квітня 2016", "7 днів"));

        return list;
    }

    public static Fragment getInstance(State statusWait) {

        Fragment fragment = new MakesFragment();

        Bundle param = new Bundle();
        param.putInt(STATE_KEY, statusWait.getStateName());

        fragment.setArguments(param);

        return fragment;
    }
}
