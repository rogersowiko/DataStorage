package com.example.lab6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserRegistrationActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreate(R.layout.activity_user_registration);

        editTextName = editTextName.findViewById(R.id.editTextName);
        editTextEmail = editTextName.findViewById(R.id.editTextEmail);
        Button buttonRegister = null;
        buttonRegister = buttonRegister.findViewById(R.id.buttonRegister);
        Button buttonViewUsers = null;
        buttonViewUsers = buttonViewUsers.findViewById(R.id.buttonViewUsers);

        buttonRegister.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Both fields are required", Toast.LENGTH_SHORT).show();
                return;
            }

            SQLiteDatabase db = new DBHelper(this).getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("email", email);
            long id = db.insert("users", null, values);
            db.close();

            Toast.makeText(this, id != -1 ? "User Registered" : "Registration Failed", Toast.LENGTH_SHORT).show();
        });

        buttonViewUsers.setOnClickListener(v -> {
            SQLiteDatabase db = new DBHelper(this).getReadableDatabase();
            Cursor cursor = db.query("users", null, null, null, null, null, null);

            StringBuilder users = new StringBuilder();
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                users.append("Name: ").append(name).append(", Email: ").append(email).append("\n");
            }

            cursor.close();
            db.close();

            Log.d("UserData", users.toString()); // For testing
            Toast.makeText(this, "Check Logcat for user data", Toast.LENGTH_SHORT).show();
        });
    }

    private void onCreate(int activityUserRegistration) {

    }
}
