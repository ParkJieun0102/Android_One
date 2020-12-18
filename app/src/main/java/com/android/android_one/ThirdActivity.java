package com.android.android_one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    TextView genderR_third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        genderR_third = findViewById(R.id.genderR_third);

        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        genderR_third.setText("GENDER :" + gender );
    }
}