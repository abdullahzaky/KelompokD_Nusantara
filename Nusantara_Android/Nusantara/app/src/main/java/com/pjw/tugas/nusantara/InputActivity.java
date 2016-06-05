package com.pjw.tugas.nusantara;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class InputActivity extends AppCompatActivity {

    EditText inputJudul;
    EditText inputDeskripsi;
    ImageView previewImage;
    Button ambilFoto;

    String judul;
    String deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputJudul = (EditText) findViewById(R.id.input_judul);
        inputDeskripsi = (EditText) findViewById(R.id.input_deskripsi);
        ambilFoto = (Button) findViewById(R.id.input_unggah_button);
        previewImage = (ImageView) findViewById(R.id.input_preview_image);

        ambilFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buka kamera dan ambil foto lalu simpan lalu tampilkan di preview

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                judul = inputJudul.getText().toString();
                if (judul.isEmpty()) {
                    inputJudul.setError("Judul harus diisi");
                }
                deskripsi = inputDeskripsi.getText().toString();
                if (deskripsi.isEmpty()) {
                    inputDeskripsi.setError("Deskripsi harus diisi");
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
