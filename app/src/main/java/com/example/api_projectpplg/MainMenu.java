package com.example.api_projectpplg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenu extends AppCompatActivity {

    Button btnepl, btnlaliga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        btnepl = findViewById(R.id.btnepl);
        btnlaliga = findViewById(R.id.btnlaliga);

        btnepl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent toEpl = new Intent(MainMenu.this, MainActivity.class);
            startActivity(toEpl);
            }
        });

        btnlaliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLaliga = new Intent(MainMenu.this, laliga.class);
                startActivity(toLaliga);
            }
        });
    }
}