package com.martindisch.material2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class ItemFragment extends Fragment implements ItemAdapter.ItemCallback {

    private ItemAdapter mAdapter;

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        // Set adapter
        RecyclerView recyclerView = view.findViewById(R.id.rvItems);
        mAdapter = new ItemAdapter(this);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ItemListViewModel viewModel = ViewModelProviders.of(getActivity()).get(ItemListViewModel.class);
        subscribeUi(viewModel);
    }

    private void subscribeUi(ItemListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getItems().observe(this, items -> {
            if (items != null) {
                mAdapter.setItems(items);
            }
        });
    }

    @Override
    public void onClick(Item item) {
        Log.d("ItemFragment", "Clicked item " + item.getText());
    }
}
