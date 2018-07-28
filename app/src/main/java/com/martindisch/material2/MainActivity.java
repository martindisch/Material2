package com.martindisch.material2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.martindisch.material2.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain ViewModel
        UserViewModel viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        // Inflate view and obtain instance of the binding class
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Assign the viewmodel to the binding class
        binding.setViewmodel(viewModel);
        // Set activity as lifecycle owner to make it update
        binding.setLifecycleOwner(this);

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
