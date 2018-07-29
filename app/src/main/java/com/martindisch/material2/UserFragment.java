package com.martindisch.material2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martindisch.material2.databinding.FragmentUserBinding;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class UserFragment extends Fragment {

    private UserViewModel viewModel;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain ViewModel
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view and obtain instance of the binding class
        FragmentUserBinding binding = FragmentUserBinding.inflate(inflater, container, false);
        // Assign the viewmodel to the binding class
        binding.setViewmodel(viewModel);
        // Set fragment as lifecycle owner to make it update
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}
