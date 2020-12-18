package com.android.android_one;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText age;
    EditText weight;
    EditText height;
    Button backBtn;
    Button calcBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        backBtn = findViewById(R.id.genderBtn);
        calcBtn = findViewById(R.id.calcBtn);


        String gender = "men"; // +++++++++++++++++++++++++++++++++++
        switch (gender){
            case "women":
                weight.setText("53");
                height.setText("161");
                break;
            case "men":
                weight.setText("68");
                height.setText("173");
                break;
        }


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity);
//                startActivity(intent);
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.android.bmi2_calculate.MainActivity.this, ResultActivity.class);
                intent.putExtra("height", Integer.parseInt(height.getText().toString()));
                intent.putExtra("weight", Integer.parseInt(weight.getText().toString()));
                startActivity(intent);
            }
        });





        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.BMIformula:
                final LinearLayout linear = (LinearLayout) View.inflate(com.android.bmi2_calculate.MainActivity.this, R.layout.bmi_formula, null);
                new AlertDialog.Builder(com.android.bmi2_calculate.MainActivity.this)
                        .setTitle("BMI 공식")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setView(linear)
                        .show();
                break;
            case R.id.BMIinfo:
                final LinearLayout linear1 = (LinearLayout) View.inflate(com.android.bmi2_calculate.MainActivity.this, R.layout.bmi_info, null);
                new AlertDialog.Builder(com.android.bmi2_calculate.MainActivity.this)
                        .setTitle("BMI 정보")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setView(linear1)
                        .show();
                break;

        }


        return true;
    }
}