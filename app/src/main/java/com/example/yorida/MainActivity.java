package com.example.yorida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 커스텀 레이아웃을 툴바에 설정합니다.
        LayoutInflater inflater = LayoutInflater.from(this);
        View customView = inflater.inflate(R.layout.toolbar_layout, toolbar, false);
        toolbar.addView(customView);

    }
}