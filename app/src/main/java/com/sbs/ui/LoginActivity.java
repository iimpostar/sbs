package com.sbs.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sbs.R;
import android.widget.Toast;
import com.sbs.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGetStarted.setOnClickListener(v -> {
            String username = binding.etUsername.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            if (username.isEmpty()) {
                binding.etUsername.setError("Enter username");
                binding.etUsername.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                binding.etPassword.setError("Enter password");
                binding.etPassword.requestFocus();
                return;
            }

            Toast.makeText(this, "Login UI ready", Toast.LENGTH_SHORT).show();
        });

        binding.tvCreateAccount.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class)));

        binding.tvNeedHelp.setOnClickListener(v ->
                Toast.makeText(this, "Help flow not implemented yet", Toast.LENGTH_SHORT).show());

//        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}