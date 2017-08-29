package com.oncelogs.hellonitirat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private int sum;
    public Button btnOk;
    private EditText tvInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initinstances();
    }

    private void initinstances() {
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        tvInput = (EditText) findViewById(R.id.tvInput);

        Intent intent = getIntent();
        sum = intent.getIntExtra("result", 0);
        tvResult.setText(sum + "");

        Bundle bundle = intent.getBundleExtra("cBundle");
        int x = bundle.getInt("x");
        int y = bundle.getInt("y");
        int z = bundle.getInt("z");

        CoordinateSerializable c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable");

        CoordinateParcelable c3 = intent.getParcelableExtra("cParcelable");

        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == btnOk){
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result",tvInput.getText().toString());
            setResult(RESULT_OK, returnIntent);
            finish();
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
