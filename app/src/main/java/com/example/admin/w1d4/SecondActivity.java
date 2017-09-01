package com.example.admin.w1d4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvResult;
    SeekBar sbAmount;
    SeekBar sbRate;
    SeekBar sbTime;
    ImageView ivCalculatorImg;
    float amount = 0;
    float rate = 0;
    float time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = (TextView) findViewById(R.id.tvResult);
        sbAmount = (SeekBar) findViewById(R.id.sbAmount);
        sbRate = (SeekBar) findViewById(R.id.sbRate);
        sbTime = (SeekBar) findViewById(R.id.sbTime);
        ivCalculatorImg = (ImageView) findViewById(R.id.ivCalculatorImg);
        sbAmount.setMax(100000);
        sbRate.setMax(20);
        sbTime.setMax(25);

        sbAmount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                amount = (float) progress;
                tvResult.setText(Float.toString(calculateEMI(amount, rate, time)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbRate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rate = (float) progress;
                tvResult.setText(Float.toString(calculateEMI(amount, rate, time)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                time = (float) progress;
                tvResult.setText(Float.toString(calculateEMI(amount, rate, time)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    protected float calculateEMI(float a, float r, float n) {
        return ((a * r * expo((int) n, (float) (1.0 + r))) / (expo(((int) n), ((float) (1.0 + r))) - 1));
    }
    public static float expo(int i, float num) {
        float temp = 0;
        for (int exp = i; exp > 1; exp--) {
            if (exp == i) {
                temp = num * num;
            } else {
                temp = temp * num;
            }
        }
        return temp;
    }
}
