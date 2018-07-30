package com.martindisch.material2;

import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acquire ViewModel
        NavigationViewModel navigationViewModel = ViewModelProviders.of(this).get(NavigationViewModel.class);
        navigationViewModel.getSelectedItem().observe(this, selectedItem -> {
            // Get the Fragment currently in the container
            FragmentManager fragmentManager = getSupportFragmentManager();
            String tag = navigationViewModel.idToTag(selectedItem);
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
            // Only replace fragment if the requested one is not already present
            if (fragment == null || !fragment.getTag().contentEquals(tag)) {
                switch (selectedItem) {
                    case R.id.action_user:
                        fragment = UserFragment.newInstance();
                        break;
                    case R.id.action_item:
                        fragment = ItemFragment.newInstance();
                        break;
                    default:
                        fragment = ItemFragment.newInstance();
                        tag = "FRAGMENT_ITEM";
                }
                // Replace the fragment
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, tag).commit();
            }
        });

        BottomAppBar bottomAppBar = findViewById(R.id.bar);
        bottomAppBar.inflateMenu(R.menu.bottom_bar_menu);
        bottomAppBar.setNavigationOnClickListener(view ->
                new BottomDrawerFragment().show(getSupportFragmentManager(), "bottom_drawer"));
    }
}
