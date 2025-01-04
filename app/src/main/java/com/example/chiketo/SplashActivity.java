package com.example.chiketo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Menunggu 3 detik dan kemudian menuju ke MainActivity
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Pindah ke LoginActivity setelah splash selesai
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Menghentikan SplashActivity agar tidak bisa kembali dengan tombol back
        }, 3000); // Waktu delay 3 detik
    }
}
