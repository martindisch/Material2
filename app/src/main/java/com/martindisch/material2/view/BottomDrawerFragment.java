package com.martindisch.material2.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;
import com.martindisch.material2.R;

import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class BottomDrawerFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_drawer, container, false);
        NavigationView navigationView = view.findViewById(R.id.bottom_drawer_navigation);

        // Hack to get the sheet to fully expand in landscape (peek height is only about one list item by default)
        getDialog().setOnShowListener(dialog ->
        {
            View bottomSheetInternal = getDialog().findViewById(R.id.design_bottom_sheet);
            BottomSheetBehavior.from(bottomSheetInternal).setState(BottomSheetBehavior.STATE_EXPANDED);
        });

        // Use NavController from NavigationView
        NavigationUI.setupWithNavController(navigationView, Navigation.findNavController(getActivity(), R.id.nav_host_fragment));
        // Manually handle what happens after navigation so we can dismiss the dialog
        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).addOnNavigatedListener((controller, destination) -> {
            if (getDialog() != null && getDialog().isShowing()) {
                dismiss();
            }
        });
        return view;
    }

    @Override
    public int getTheme() {
        // Method override to return the custom dialog theme
        return R.style.BottomSheetDialogTheme;
    }
}
