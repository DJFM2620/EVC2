package com.example.evaluacioncontinua2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacioncontinua2.network.PersonEntry;

public class CardGridFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.person_card_grid_fragment, container,false);

        //setUpToolbar(view); ------------- ERROR -------------

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false));

        PersonCardRecyclerViewAdapter adapter = new PersonCardRecyclerViewAdapter(PersonEntry.initPersonEntryList(getResources()));

        recyclerView.setAdapter(adapter);

        return view;
    }

    /*private void setUpToolbar(View view) {

        Toolbar toolbar = view.findViewById(R.id.app_bar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();

        if(activity != null){

            activity.setSupportActionBar(toolbar);
        }
    } ------------- ERROR ------------- */

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){

        menuInflater.inflate(R.menu.toolbar_menu, menu);

        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
