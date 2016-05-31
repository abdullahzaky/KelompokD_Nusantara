package com.pjw.tugas.nusantara;

/**
 * Created by Shalahudin Al Ayyub on 31/05/2016.
 */
public class User {
    public static User akunIni;

    private String id;
    private String nama;
    private String urlFoto;
    private String email;
    private String foto;

    public User(String id, String nama, String urlFoto, String email) {
        this.id = id;
        this.nama = nama;
        this.urlFoto = urlFoto;
        this.email = email;
    }

    public static User getAkunIni() {
        return akunIni;
    }

    public static void setAkunIni(User akunIni) {
        User.akunIni = akunIni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
