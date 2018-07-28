package com.martindisch.material2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    private MutableLiveData<String> name, address;
    private MutableLiveData<Boolean> vegetarian, married;

    public UserViewModel() {
        // Initialize user with default values
        name = new MutableLiveData<>();
        name.setValue("John Doe");
        address = new MutableLiveData<>();
        address.setValue("Mulholland Dr. 7");
        vegetarian = new MutableLiveData<>();
        vegetarian.setValue(false);
        married = new MutableLiveData<>();
        married.setValue(true);
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getAddress() {
        return address;
    }

    public MutableLiveData<Boolean> getVegetarian() {
        return vegetarian;
    }

    public MutableLiveData<Boolean> getMarried() {
        return married;
    }

    public void reset() {
        name.setValue("");
        address.setValue("");
        vegetarian.setValue(false);
        married.setValue(false);
    }
}
