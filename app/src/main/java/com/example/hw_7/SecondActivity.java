package com.example.hw_7;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        String sumFromMain=getIntent().getStringExtra("sum");
        TextView textView = findViewById(R.id.text_result);
        textView.setText(sumFromMain);
        Button button = findViewById(R.id.btn_next);
        button.setOnClickListener(view -> {
            finish();

        });




    }

    private void finishActivity(Button button) {
    }
}