package com.example.count;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.text1);
    }

    public void mCount(View view) {

        count++;
        t1.setText("" + count);
    }

    public void mDiscount(View view) {
        count--;
        t1.setText("" + count);
    }

    public void mReset(View view) {
        if (count != 0) {
            count = 0;
        }
        t1.setText("" + count);
    }
}