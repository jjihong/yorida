package com.example.yorida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.yorida.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 커스텀 레이아웃을 툴바에 설정합니다.
        LayoutInflater inflater = LayoutInflater.from(this);
        View customView = inflater.inflate(R.layout.toolbar_layout, toolbar, false);
        toolbar.addView(customView);

        replaceFragment(new MainFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.mainfragment) {
                replaceFragment(new MainFragment());
            } else if (item.getItemId() == R.id.recomendfragment) {
                replaceFragment(new RecomendFragment());
            } else if (item.getItemId() == R.id.mypagefragment) {
                replaceFragment(new MypageFragment());
            }

            return true;
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }

}