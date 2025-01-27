package com.example.chiketo;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityPemesanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        // Ambil data dari Intent
        String transportType = getIntent().getStringExtra("transport_type");

        // Tampilkan jenis transportasi dalam sebuah Toast
        if (transportType != null) {
            Toast.makeText(this, "Selected Transport: " + transportType, Toast.LENGTH_SHORT).show();
        }
    }
}