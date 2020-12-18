package com.android.android_one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity2 extends Activity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button start_main = findViewById(R.id.main_start);
        imageView = (ImageView)findViewById(R.id.main_gif);

        Glide.with(this).load(R.raw.b).into(imageView);

        start_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(MainActivity2.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}