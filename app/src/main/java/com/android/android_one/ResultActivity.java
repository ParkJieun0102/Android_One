package com.android.android_one;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    String TAG = "Main";

    String status;
    int calory;
    Button backspaceBtn;
    Button tipBtn;

    Intent intent;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent intent = getIntent();
        double height = intent.getIntExtra("height", 0);
        double weight = intent.getIntExtra("weight", 0);
        gender = intent.getStringExtra("gender");

        double result1 = (weight * 10000) / (height * height);
        Log.v(TAG, Double.toString(height));

        TextView text = findViewById(R.id.text);
        TextView text2 = findViewById(R.id.text2);

        ImageView img1 = findViewById(R.id.normal);
        ImageView img2 = findViewById(R.id.light);
        ImageView img3 = findViewById(R.id.heavy);
        ImageView img4 = findViewById(R.id.veryHeavy);

        String result = Double.toString(result1).substring(0, 4);
        int normalWeight = (int) weight * 35;

        if (result1 < 18.5) {
            text.setText("당신의 BMI 지수는 " + result + " 입니다.");
            text2.setText("저체중");
            status = "low";
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
        } else if (18.5 <= result1 && result1 < 23) {
            text.setText("당신의 BMI 지수는 " + result + " 입니다.");
            text2.setText("정상");
            status = "normal";
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);

        } else if (23 <= result1 && result1 < 25) {
            text.setText("당신의 BMI 지수는 " + result + " 입니다.");
            text2.setText("과체중");

            status = "heavy";
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.INVISIBLE);

        } else if (25 < result1) {

            status = "veryheavy";
            text.setText("당신의 BMI 지수는 " + result + " 입니다.");
            text2.setText("비만");
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.VISIBLE);

        }

        backspaceBtn = findViewById(R.id.backspaceBtn);
        tipBtn = findViewById(R.id.tipBtn);

        backspaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.android.android_one.ResultActivity.this, MainActivity.class); // from ~ to
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });

        tipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(com.android.android_one.ResultActivity.this, MainActivity3.class); // from ~ to
                intent.putExtra("status", status);
                intent.putExtra("calory", normalWeight);

                startActivity(intent);
            }
        });


    }



}