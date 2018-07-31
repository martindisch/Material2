package com.martindisch.material2;

import java.util.LinkedList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemListViewModel extends ViewModel {

    private MutableLiveData<List<Item>> items;

    private static final int COUNT = 5;

    public MutableLiveData<List<Item>> getItems() {
        if (items == null) {
            items = new MutableLiveData<>();
            // Generate random items
            LinkedList<Item> list = new LinkedList<>();
            for (int i = 0; i < COUNT; i++) {
                list.add(new Item());
            }
            items.setValue(list);
        }
        return items;
    }
}
