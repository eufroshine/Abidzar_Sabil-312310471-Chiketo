package com.example.chiketo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout trainCard = findViewById(R.id.train_card);
        RelativeLayout busCard = findViewById(R.id.bus_card);
        RelativeLayout planeCard = findViewById(R.id.plane_card);

        setupTransportCardListener(trainCard, "TRAIN");
        setupTransportCardListener(busCard, "BUS");
        setupTransportCardListener(planeCard, "PLANE");
    }

    private void setupTransportCardListener(RelativeLayout card, String transportType) {
        card.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityPemesanan.class);
            intent.putExtra("transport_type", transportType);
            startActivity(intent);
        });
    }
}