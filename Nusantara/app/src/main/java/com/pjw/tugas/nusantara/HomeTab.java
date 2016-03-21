package com.pjw.tugas.nusantara;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeTab extends Fragment {
    ArrayList<Budaya> budayaArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_home, container, false);
        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rv_home);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        Bitmap bitmap=ImageRound.getRoundedCornerBitmap(
                BitmapFactory.decodeResource(getResources(), R.drawable.samfot));
        Bitmap bitmap1=BitmapFactory.decodeResource(getResources(), R.drawable.sample_budaya);
        budayaArrayList=new ArrayList<>();
        Budaya budaya=new Budaya(
                1,
                "Candi Prambanan",
                "Sleman, Yogyakarta",
                bitmap,
                bitmap1,
                12,
                19,
                44
        );
        Budaya budaya1=new Budaya(
                1,
                "Candi Prambanan",
                "Sleman, Yogyakarta",
                bitmap,
                bitmap1,
                12,
                19,
                44
        );
        Budaya budaya2=new Budaya(
                1,
                "Candi Prambanan",
                "Sleman, Yogyakarta",
                bitmap,
                bitmap1,
                12,
                19,
                44
        );
        budayaArrayList.add(budaya);
        budayaArrayList.add(budaya1);
        budayaArrayList.add(budaya2);
        HomeAdapter adapter = new HomeAdapter(budayaArrayList);
        rv.setAdapter(adapter);
        return view;
    }
}
