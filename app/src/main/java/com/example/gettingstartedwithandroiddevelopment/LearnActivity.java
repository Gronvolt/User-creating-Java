package com.example.gettingstartedwithandroiddevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        List<Integer> buttons = Arrays.asList(R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9, R.id.button0);

        for (Integer i: buttons) {
            View b = findViewById(i);
            b.setOnClickListener(this::onClick);
        }
    }

    public void onClick(View view) {
        Integer buttonId = view.getId();
        Button button = findViewById(buttonId);

        String buttonText = button.getText().toString();

        Intent data = new Intent();
        data.putExtra(UserOverviewActivity.USER_NUMBER, buttonText);

        Toast.makeText(this, "This is" + buttonText, Toast.LENGTH_LONG).show();

        setResult(RESULT_OK, data);
        finish();
        }

}