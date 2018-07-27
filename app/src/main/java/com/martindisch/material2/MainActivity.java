package com.martindisch.material2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomAppBar = findViewById(R.id.bar);
        mBottomAppBar.inflateMenu(R.menu.bottom_bar_menu);
        mBottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: show navigation
            }
        });
    }
}
