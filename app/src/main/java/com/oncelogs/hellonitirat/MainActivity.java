package com.oncelogs.hellonitirat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.PersistableBundle;
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

        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

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

            Coordinate c1 = new Coordinate();
            c1.x = 5;
            c1.y = 5;
            c1.z = 5;
            Bundle bundle = new Bundle();
            bundle.putInt("x", c1.x);
            bundle.putInt("y", c1.y);
            bundle.putInt("z", c1.z);
            intent.putExtra("cBundle", bundle);

            CoordinateSerializable c2 = new CoordinateSerializable();
            c2.x = 5;
            c2.y = 5;
            c2.z = 5;
            intent.putExtra("cSerializable", c2);

            CoordinateParcelable c3 = new CoordinateParcelable();
            c3.x = 5;
            c3.y = 10;
            c3.z = 20;
            intent.putExtra("cParcelable", c3);

            startActivityForResult(intent, 123);

            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123){
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra("result");
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState,
                                    PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
