package com.example.gettingstartedwithandroiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class CreateUserActivity extends AppCompatActivity {

    private EditText userName;
    boolean male = true;
    String gender = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        Button createUserButton = (Button) findViewById(R.id.createUserButton);
        EditText input = findViewById(R.id.username);


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.gender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male) {
                    male = true;
                    gender = "Men";
                } else {
                    male = false;
                    gender = "Women";
                }
            }
        });

        createUserButton.setOnClickListener(v -> {
            Context context = getApplicationContext();

            String string = input.getText().toString();

            Toast.makeText(context, "User " + string + " " + gender + " created.", Toast.LENGTH_LONG).show();

            Intent data = new Intent();
            data.putExtra(UserOverviewActivity.USER_NAME, string);
            data.putExtra(UserOverviewActivity.USER_LABEL, gender);

            setResult(RESULT_OK, data);
            finish();
        });
    }


}

