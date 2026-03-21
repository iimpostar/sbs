package com.sbs.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sbs.R;
import com.sbs.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCreateAccount.setOnClickListener(v -> {
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

            Toast.makeText(this, "Sign up UI ready", Toast.LENGTH_SHORT).show();
        });

        binding.tvBackToLogin.setOnClickListener(v -> finish());

        binding.tvNeedHelp.setOnClickListener(v ->
                Toast.makeText(this, "Help flow not implemented yet", Toast.LENGTH_SHORT).show());


//        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}