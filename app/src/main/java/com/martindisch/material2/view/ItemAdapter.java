package com.martindisch.material2.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.martindisch.material2.databinding.ListItemBinding;
import com.martindisch.material2.model.Item;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> mItems;
    private ItemCallback mCallback;

    public ItemAdapter(ItemCallback callback) {
        mCallback = callback;
    }

    public void setItems(List<Item> items) {
        if (mItems == null) {
            mItems = items;
            notifyItemRangeInserted(0, items.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mItems.size();
                }

                @Override
                public int getNewListSize() {
                    return items.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mItems.get(oldItemPosition).getId() ==
                            items.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Item newItem = items.get(newItemPosition);
                    Item oldItem = mItems.get(oldItemPosition);
                    return newItem.getId() == oldItem.getId()
                            && newItem.getText().contentEquals(oldItem.getText())
                            && newItem.getImage() == oldItem.getImage();
                }
            });
            mItems = items;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        holder.binding.setItem(mItems.get(position));
        holder.binding.setOnClickListener(mCallback);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding binding;

        public ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface ItemCallback {
        void onClick(Item item);
    }
}
