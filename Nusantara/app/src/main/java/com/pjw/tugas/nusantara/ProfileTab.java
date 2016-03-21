package com.pjw.tugas.nusantara;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.content_profile, container, false);
        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rv_profile);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        //HistoryAdapter adapter = new HistoryAdapter(MainActivity.statusArrayList);
        //rv.setAdapter(adapter);
        return view;
    }
}
