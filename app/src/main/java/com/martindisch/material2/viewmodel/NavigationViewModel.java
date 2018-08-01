package com.martindisch.material2.viewmodel;

import com.martindisch.material2.R;

import java.util.Arrays;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavigationViewModel extends ViewModel {

    private MutableLiveData<Integer> selectedItem;
    private static final Integer[] IDS = {
            R.id.action_user,
            R.id.action_item,
            R.id.action_dummy1,
            R.id.action_dummy2,
            R.id.action_dummy3
    };
    private static final String[] TAGS = {
            "FRAGMENT_USER",
            "FRAGMENT_ITEM",
            "FRAGMENT_DUMMY1",
            "FRAGMENT_DUMMY2",
            "FRAGMENT_DUMMY3"
    };

    public MutableLiveData<Integer> getSelectedItem() {
        if (selectedItem == null) {
            selectedItem = new MutableLiveData<>();
            selectedItem.setValue(R.id.action_user);
        }
        return selectedItem;
    }

    public String idToTag(int id) {
        int index = Arrays.asList(IDS).indexOf(id);
        return TAGS[index];
    }
}
