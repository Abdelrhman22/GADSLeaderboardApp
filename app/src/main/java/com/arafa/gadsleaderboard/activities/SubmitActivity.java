package com.arafa.gadsleaderboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arafa.gadsleaderboard.R;

public class SubmitActivity extends AppCompatActivity {

    private EditText firstName , lastName , emailAddress , projectLink;
    private TextView submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        initUI();

    }

    private void initUI() {
        firstName = findViewById(R.id.firstName_editText);
        lastName = findViewById(R.id.lastName_editText);
        emailAddress = findViewById(R.id.email_editText);
        projectLink = findViewById(R.id.projectUrl_editText);
        submitButton = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDataValid = true;
                // firstName
                if(TextUtils.isEmpty(firstName.getText().toString())){
                    firstName.setError(getString(R.string.STR_REQUIRED_FIELD));
                    isDataValid = false;
                }
                // lastName
                if(TextUtils.isEmpty(lastName.getText().toString())){
                    lastName.setError(getString(R.string.STR_REQUIRED_FIELD));
                    isDataValid = false;
                }
                // emailAddress
                if(TextUtils.isEmpty(emailAddress.getText().toString())){
                    emailAddress.setError(getString(R.string.STR_REQUIRED_FIELD));
                    isDataValid = false;
                }
                // projectLink
                if(TextUtils.isEmpty(projectLink.getText().toString())){
                    projectLink.setError(getString(R.string.STR_REQUIRED_FIELD));
                    isDataValid = false;
                }
                if(isDataValid){
                    // show progress dialog , start request


                }

            }
        });
    }


    public void handleBack(View view) {
        this.finish();
    }
}