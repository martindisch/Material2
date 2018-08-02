package com.martindisch.material2.view;

import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.button.MaterialButton;
import com.martindisch.material2.R;
import com.martindisch.material2.model.Item;
import com.martindisch.material2.viewmodel.ItemListViewModel;

import java.util.LinkedList;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    static {
        // Make sure that vector drawables work on pre-Lollipop devices
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomAppBar bottomAppBar = findViewById(R.id.bar);
        bottomAppBar.inflateMenu(R.menu.bottom_bar_menu);
        bottomAppBar.setNavigationOnClickListener(view -> new BottomDrawerFragment().show(getSupportFragmentManager(), "bottom_drawer"));

        ItemListViewModel listViewModel = ViewModelProviders.of(this).get(ItemListViewModel.class);
        MaterialButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            // Get list of items
            LinkedList<Item> items = (LinkedList<Item>) listViewModel.getItems().getValue();
            // Clone it so we don't insert into the existing instance (DiffUtil wouldn't find difference)
            LinkedList<Item> newItems = (LinkedList<Item>) items.clone();
            // Add item at a random position within the list
            newItems.add(new Random().nextInt(items.size() + 1), new Item());
            listViewModel.getItems().setValue(newItems);
        });
    }
}
