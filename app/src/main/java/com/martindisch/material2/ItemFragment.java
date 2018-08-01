package com.martindisch.material2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemFragment extends Fragment implements ItemAdapter.ItemCallback {

    private ItemAdapter mAdapter;
    ItemListViewModel mViewModel;

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        // Prepare RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.rvItems);
        // Add separator
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        // Add swipe to delete
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START | ItemTouchHelper.END) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                // Get list of items
                LinkedList<Item> items = (LinkedList<Item>) mViewModel.getItems().getValue();
                // Clone it so we don't insert into the existing instance (DiffUtil wouldn't find difference)
                LinkedList<Item> newItems = (LinkedList<Item>) items.clone();
                // Remove item
                newItems.remove(position);
                mViewModel.getItems().setValue(newItems);
            }
        });
        touchHelper.attachToRecyclerView(recyclerView);
        // Set adapter
        mAdapter = new ItemAdapter(this);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(ItemListViewModel.class);
        subscribeUi(mViewModel);
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
