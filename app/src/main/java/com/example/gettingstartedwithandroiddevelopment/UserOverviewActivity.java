package com.example.gettingstartedwithandroiddevelopment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

public class UserOverviewActivity extends AppCompatActivity {


    User user;
    static final String USER_LABEL = "User name";
    static final String USER_NAME = "The name";
    static  final String USER_NUMBER = "Your number";
//    static final String ACCESS_MESSAGE = "ACCESS_MESSAGE";

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    TextView userNameTextView = findViewById(R.id.username);
                    TextView userLabelTextView = findViewById(R.id.userlabel);
                    TextView userNumberTextView = findViewById(R.id.userNumber);
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        String userName = intent.getStringExtra(USER_NAME);
                        String userLabel = intent.getStringExtra(USER_LABEL);
                        String userNumber = intent.getStringExtra(USER_NUMBER);
                        userNameTextView.setText(userName);
                        userLabelTextView.setText(userLabel);
                        userNumberTextView.setText(userNumber);
                    } else {
                        userNameTextView.setText("Access denied!");
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_overview);
        TextView practiceTextViewButton = (TextView) findViewById(R.id.button_learn);
        Button createUserButton = findViewById(R.id.createUserButton);

        boolean userExists = true;

        if (!userExists) {
            Intent intent = new Intent(this, CreateUserActivity.class);
            startActivity(intent);
        }

        createUserButton.setOnClickListener(v -> {
            Context context = getApplicationContext();

            TextView userLabel = findViewById(R.id.userlabel);
            String label = userLabel.getText().toString();

            TextView userName = findViewById(R.id.username);
            String name = userName.getText().toString();

            Intent intent = new Intent(context, CreateUserActivity.class);
            intent.putExtra(USER_NAME, label);
            intent.putExtra(USER_LABEL,name);

            mStartForResult.launch(intent);

        });

        practiceTextViewButton.setOnClickListener(v -> {
            Context context = getApplicationContext();

            TextView userLabel = findViewById(R.id.userlabel);
            String label = userLabel.getText().toString();

            TextView userName = findViewById(R.id.username);
            String name = userName.getText().toString();

            TextView userNumber = findViewById(R.id.userNumber);
            String number = userNumber.getText().toString();

            Intent intent = new Intent(context, LearnActivity.class);
            intent.putExtra(USER_NUMBER, number);


            mStartForResult.launch(intent);

        });

    }

}