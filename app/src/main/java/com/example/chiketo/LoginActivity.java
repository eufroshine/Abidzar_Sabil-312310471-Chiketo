package com.example.chiketo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.chiketo.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    // Data dummy untuk autentikasi
    private static final String DUMMY_USERNAME = "eufroshine";
    private static final String DUMMY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Menggunakan View Binding
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Menambahkan listener untuk tombol login
        binding.loginButton.setOnClickListener(v -> {
            String username = binding.usernameField.getText().toString().trim();
            String password = binding.passwordField.getText().toString().trim();

            // Validasi input
            if (username.isEmpty()) {
                showToast(getString(R.string.error_empty_username));
                return;
            }
            if (password.isEmpty()) {
                showToast(getString(R.string.error_empty_password));
                return;
            }

            // Proses login sederhana
            if (authenticate(username, password)) {
                navigateToSplash();
            } else {
                showToast(getString(R.string.error_invalid_credentials));
            }
        });
    }

    /**
     * Autentikasi sederhana menggunakan data dummy.
     *
     * @param username Input username
     * @param password Input password
     * @return True jika valid, false jika tidak
     */
    private boolean authenticate(String username, String password) {
        return DUMMY_USERNAME.equals(username) && DUMMY_PASSWORD.equals(password);
    }

    /**
     * Navigasi ke SplashActivity setelah login berhasil.
     */
    private void navigateToSplash() {
        Intent intent = new Intent(LoginActivity.this, SplashActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Menampilkan pesan toast.
     *
     * @param message Pesan yang akan ditampilkan
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
