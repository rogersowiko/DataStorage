package com.example.lab6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private EditText editTextUsername, editTextUserEmail;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "user_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextUserEmail = findViewById(R.id.editTextUserEmail);
        Button buttonSave = findViewById(R.id.buttonSaveSettings);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Load previously saved settings
        editTextUsername.setText(sharedPreferences.getString("username_key", ""));
        editTextUserEmail.setText(sharedPreferences.getString("email_key", ""));

        buttonSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username_key", editTextUsername.getText().toString());
            editor.putString("email_key", editTextUserEmail.getText().toString());
            editor.apply();
            Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show();
        });
    }
}
