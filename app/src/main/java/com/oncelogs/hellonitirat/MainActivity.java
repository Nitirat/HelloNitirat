package com.oncelogs.hellonitirat;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCopy;
    TextView tvHello;
    EditText etInput;
    EditText et1;
    EditText et2;
    TextView tvResult;
    Button btnCal;
    CustomViewGroup viewGroup1;
    CustomViewGroup viewGroup2;

    RadioGroup rgOper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initinstances();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        toastLong("Width = " + width + ", Height = " + height);
    }

    private void initinstances() {
        tvHello = (TextView) findViewById(R.id.tvHello);
        etInput = (EditText) findViewById(R.id.tvInput);

        etInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    tvHello.setText(etInput.getText());
                    return true;
                }
                return false;
            }
        });

        btnCopy = (Button) findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(this);


        // ---------------------------------- Calculate

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(this);


        rgOper = (RadioGroup) findViewById(R.id.rgOper);

        viewGroup1 = (CustomViewGroup) findViewById(R.id.viewGroup1);
        viewGroup2 = (CustomViewGroup) findViewById(R.id.viewGroup2);

        viewGroup1.setBtnHello("HELLO");
        viewGroup2.setBtnHello("WORLD");

    }

    @Override
    public void onClick(View v) {
        if (v == btnCopy) {
            tvHello.setText(etInput.getText());
        }

        if (v == btnCal) {
            int num1 = 0;
            int num2 = 0;
            try {
                num1 = Integer.parseInt(et1.getText().toString());
            } catch (NumberFormatException e) {
            }
            try {
                num2 = Integer.parseInt(et2.getText().toString());
            } catch (NumberFormatException e) {
            }

            int sum = 0;
            switch (rgOper.getCheckedRadioButtonId()) {
                case R.id.rbPlus:
                    sum = num1 + num2;
                    break;
                case R.id.rbMi:
                    sum = num1 - num2;
                    break;
                case R.id.rbMu:
                    sum = num1 * num2;
                    break;
                case R.id.rbDi:
                    sum = num1 / num2;
                    break;
            }

            tvResult.setText("=" + sum);

            Log.d("Calculation", "Result = " + sum);

            Toast.makeText(MainActivity.this, "Result = " + sum, Toast.LENGTH_LONG).show();


            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("result", sum);
            startActivity(intent);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {
            Toast.makeText(MainActivity.this, "Test Setting", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toastLong(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}