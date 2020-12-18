package com.android.android_one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SecondActivity extends Activity {
    final static int RValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageButton gender_w = findViewById(R.id.genderW_second);
        ImageButton gender_m = findViewById(R.id.genderM_second);

        gender_w.setOnClickListener(genderClick);
        gender_m.setOnClickListener(genderClick);

    }

    View.OnClickListener genderClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.genderW_second:
                    intent = new Intent(SecondActivity.this, MainActivity.class);
                    intent.putExtra("gender", "women");

                    startActivity(intent);
                    break;

                case R.id.genderM_second:
                    intent = new Intent(SecondActivity.this, MainActivity.class);
                    intent.putExtra("gender", "men");

                    startActivity(intent);
            }
        }
    };
}