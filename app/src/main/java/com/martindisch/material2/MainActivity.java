package com.martindisch.material2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Acquire ViewModel
            MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
            // Register Observer to replace Fragment when necessary
            viewModel.getCurrentFragment().observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer fragment_id) {
                    Fragment fragment = null;
                    switch (fragment_id) {
                        case MainViewModel.FRAGMENT_USER:
                            fragment = UserFragment.newInstance();
                            break;
                        case MainViewModel.FRAGMENT_LIST:
                            // TODO
                            fragment = null;
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });
        }

        BottomAppBar bottomAppBar = findViewById(R.id.bar);
        bottomAppBar.inflateMenu(R.menu.bottom_bar_menu);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: show navigation
            }
        });
    }
}
