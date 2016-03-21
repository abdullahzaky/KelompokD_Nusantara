package com.pjw.tugas.nusantara;

import android.graphics.Bitmap;

/**
 * Created by Shalahudin Al Ayyub on 21/03/2016.
 */
public class Budaya {
    private int id;
    private String nama;
    private String lokasi;
    private Bitmap user;
    private Bitmap image;
    private int rating;
    private int komentar;
    private int share;

    public Budaya(int id, String nama, String lokasi, Bitmap user, Bitmap image, int rating, int komentar, int share) {
        this.id = id;
        this.nama = nama;
        this.lokasi = lokasi;
        this.user = user;
        this.image = image;
        this.rating = rating;
        this.komentar = komentar;
        this.share = share;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public Bitmap getUser() {
        return user;
    }

    public void setUser(Bitmap user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getKomentar() {
        return komentar;
    }

    public void setKomentar(int komentar) {
        this.komentar = komentar;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }
}
