package com.martindisch.material2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class BottomDrawerFragment extends BottomSheetDialogFragment {

    private NavigationView navigationView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_drawer, container, false);
        navigationView = view.findViewById(R.id.bottom_drawer_navigation);

        // Hack to get the sheet to fully expand in landscape (peek height is only about one list item by default)
        getDialog().setOnShowListener(dialog ->
        {
            View bottomSheetInternal = getDialog().findViewById(R.id.design_bottom_sheet);
            BottomSheetBehavior.from(bottomSheetInternal).setState(BottomSheetBehavior.STATE_EXPANDED);
        });
        return view;
    }

    @Override
    public int getTheme() {
        // Method override to return the custom dialog theme
        return R.style.BottomSheetDialogTheme;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Acquire ViewModel
        NavigationViewModel navigationViewModel = ViewModelProviders.of(getActivity()).get(NavigationViewModel.class);
        // Since the layout has been newly inflated, we need to check the selected item
        navigationView.setCheckedItem(navigationViewModel.getSelectedItem().getValue());

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            // Update the ViewModel
            navigationViewModel.getSelectedItem().setValue(menuItem.getItemId());
            // Return true to show the selected item as checked
            return true;
        });
    }
}
