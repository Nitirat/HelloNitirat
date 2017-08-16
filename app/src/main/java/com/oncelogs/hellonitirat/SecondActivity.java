package com.oncelogs.hellonitirat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initinstances();
    }

    private void initinstances() {
        Intent intent = getIntent();
        sum = intent.getIntExtra("result", 0);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText(sum + "");

        Bundle bundle = intent.getBundleExtra("cBundle");
        int x = bundle.getInt("x");
        int y = bundle.getInt("y");
        int z = bundle.getInt("z");

        CoordinateSerializable c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable");


        CoordinateParcelable c3 = intent.getParcelableExtra("cParcelable");


    }
}
