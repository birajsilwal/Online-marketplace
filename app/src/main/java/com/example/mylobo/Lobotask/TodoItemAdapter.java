package com.example.mylobo.Lobotask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.ViewHolder> {

    public interface OnLongClickListner {
        void onItemLongClicked (int position);
    }

    List<String> items;
    OnLongClickListner longClickListner;

    public TodoItemAdapter(List<String> items, OnLongClickListner longClickListener) {

        this.items = items;
        this.longClickListner = longClickListener;
    }

    @NonNull
    @Override
    // review this function later !!!
    //responsible for creating each view
    //create a new view and wrap it inside a new view holder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // use layout inflater to inflate a view
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

        // wrap it inside a View Holder and return it
        return new ViewHolder(todoView);
    }

    @Override
    //responsible for taking data out of particular position and putting in a viewHolder
    // or binding data to a particular view holder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Grab the item at the position
        String item = items.get(position);

        // Bind the item into the specified view holder
        holder.bind(item);
    }

    @Override
    //tells the Recycler view how many items are in the list
    //number of items available in the data
    public int getItemCount() {
        return items.size();
    }

    //container to provide easy access to views that represent each row of the list
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);

        }

        // Update the view inside of the view holder with the data
        public void bind(String item) {

            tvItem.setText(item);
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    // Notify the listener which position was long pressed.
                    longClickListner.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
