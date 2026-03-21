package com.sbs;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.SharedPreferences;
import android.content.Intent;
import com.sbs.ui.WelcomeActivity;
import com.sbs.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "silverback_prefs";
    private static final String KEY_HAS_OPENED_BEFORE = "has_opened_before";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean hasOpenedBefore = prefs.getBoolean(KEY_HAS_OPENED_BEFORE, false);

        Intent intent;
        if (!hasOpenedBefore) {
            prefs.edit().putBoolean(KEY_HAS_OPENED_BEFORE, true).apply();
            intent = new Intent(this, WelcomeActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }

        startActivity(intent);
        finish();
    }
}