package com.example.quanlysach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    private EditText edtUsername, edtPassword;
    private TextView tvError;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        tvError = findViewById(R.id.tvLoginError);
        findViewById(R.id.btnLogin).setOnClickListener(v -> login());
    }

    private void login() {
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            tvError.setText("Vui lòng nhập tên đăng nhập và mật khẩu");
            tvError.setVisibility(View.VISIBLE);
        } else if (username.equals("admin") && password.equals("123456")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            tvError.setText("Sai tên đăng nhập hoặc mật khẩu");
            tvError.setVisibility(View.VISIBLE);
        }
    }
}
