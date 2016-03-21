package com.pjw.tugas.nusantara;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.PersonViewHolder>{
    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        ImageView user;
        ImageView foto;
        TextView nama;
        TextView lokasi;
        TextView rating;
        TextView komentar;
        TextView share;

        PersonViewHolder(View itemView) {
            super(itemView);
            user=(ImageView) itemView.findViewById(R.id.user);
            foto=(ImageView) itemView.findViewById(R.id.image_budaya);
            nama=(TextView) itemView.findViewById(R.id.name_budaya);
            lokasi=(TextView) itemView.findViewById(R.id.lokasi_budaya);
            rating=(TextView) itemView.findViewById(R.id.rating_budaya);
            komentar=(TextView) itemView.findViewById(R.id.komentar_budaya);
            share=(TextView) itemView.findViewById(R.id.share_budaya);
        }
    }
    List<Budaya> budayaList;

    HomeAdapter(List<Budaya> komentars){
        this.budayaList = komentars;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_budaya, viewGroup, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.user.setImageBitmap(budayaList.get(i).getUser());
        personViewHolder.foto.setImageBitmap(budayaList.get(i).getImage());
        personViewHolder.nama.setText(budayaList.get(i).getNama());
        personViewHolder.lokasi.setText(budayaList.get(i).getLokasi());
        personViewHolder.rating.setText(String.valueOf(budayaList.get(i).getRating()));
        personViewHolder.komentar.setText(String.valueOf(budayaList.get(i).getKomentar()));
        personViewHolder.share.setText(String.valueOf(budayaList.get(i).getShare()));
    }

    @Override
    public int getItemCount() {
        return budayaList.size();
    }
}
