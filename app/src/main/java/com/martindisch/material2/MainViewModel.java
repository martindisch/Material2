package com.martindisch.material2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> currentFragment;

    public static final int FRAGMENT_USER = 1, FRAGMENT_LIST = 2;

    public MutableLiveData<Integer> getCurrentFragment() {
        if (currentFragment == null) {
            currentFragment = new MutableLiveData<>();
            currentFragment.setValue(FRAGMENT_USER);
        }
        return currentFragment;
    }
}
