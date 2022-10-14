package com.example.gettingstartedwithandroiddevelopment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity {
    boolean male = true;
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

// more code

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.gender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male) {
                    male = true;
                    gender = "мужик";
                }
                else {
                    male = false;
                    gender = "баба";
                }
            }
        });
    }
    public void onClick(View view) {
        EditText input = findViewById(R.id.username);
        String string = input.getText().toString();

        Toast.makeText(this, "User " + string + " " + gender + " created.", Toast.LENGTH_LONG).show();

    }



}

