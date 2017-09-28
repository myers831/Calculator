package com.example.admin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    String tvHolder;
    private TextView tvResults;
    infixEval pF = new infixEval();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResults = (TextView) findViewById(R.id.tvResults);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putString("textviewvalue", tvResults.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        tvResults.setText(savedInstanceState.getString("textviewvalue"));

    }

    public void btn_seven(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "7");
    }

    public void btn_eight(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "8");
    }

    public void btn_nine(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "9");
    }

    public void btn_del(View view) {
        tvResults.setText("");
    }

    public void btn_four(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "4");
    }

    public void btn_five(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "5");
    }

    public void btn_six(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "6");
    }

    public void btn_div(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "/");
    }

    public void btn_one(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "1");
    }

    public void btn_two(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "2");
    }

    public void btn_three(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "3");
    }

    public void btn_multi(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "*");
    }

    public void btn_Deci(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + ".");
    }

    public void btn_zero(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "0");
    }

    public void btn_equal(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(Integer.toString(pF.evaluate(tvHolder)));
    }

    public void btn_sub(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "-");
    }

    public void btn_add(View view) {
        tvHolder = tvResults.getText().toString();
        tvResults.setText(tvHolder + "+");
    }
}
