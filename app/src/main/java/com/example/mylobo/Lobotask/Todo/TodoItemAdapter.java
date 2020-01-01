package com.example.mylobo.Lobotask.Todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylobo.R;

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
        View todoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);

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

        TextView tvItemTodo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemTodo = itemView.findViewById(R.id.tvItemTodo);

        }

        // Update the view inside of the view holder with the data
        public void bind(String item) {

            tvItemTodo.setText(item);
            tvItemTodo.setOnLongClickListener(new View.OnLongClickListener() {
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


// for now saving items into device
// below codes are for using parse
//
//package com.example.mylobo.Lobotask;
//
//        import android.content.Context;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import com.example.mylobo.R;
//
//        import java.util.List;
//
//public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.ViewHolder> {
//
//    private Context contextTodo;
//    private List<TodoItem> todoItems;
//
//
//    public TodoItemAdapter(Context context, List<TodoItem> todoItems) {
//        this.contextTodo = context;
//        this.todoItems = todoItems;
//    }
//
//    public interface OnLongClickListner {
//        void onItemLongClicked (int position);
//    }
//
//    List<String> items;
//    OnLongClickListner longClickListner;
//
//    public TodoItemAdapter(List<String> items, OnLongClickListner longClickListener) {
//
//        this.items = items;
//        this.longClickListner = longClickListener;
//    }
//
//    @NonNull
//    @Override
//    //responsible for creating each view
//    //create a new view and wrap it inside a new view holder
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // use layout inflater to inflate a view
//        View view = LayoutInflater.from(contextTodo).inflate(R.layout.item_todo, parent, false);
//        // wrap it inside a View Holder and return it
//        return new ViewHolder(view);
//    }
//
//    @Override
//    //responsible for taking data out of particular position and putting in a viewHolder
//    // or binding data to a particular view holder
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        //Grab the item at the position
//        final TodoItem todoItem = todoItems.get(position);
//        // Bind the item into the specified view holder
//        holder.bind(todoItem);
//    }
//
//    @Override
//    //tells the Recycler view how many items are in the list
//    //number of items available in the data
//    public int getItemCount() {
//        return todoItems.size();
//    }
//
//    //container to provide easy access to views that represent each row of the list
//    class ViewHolder extends RecyclerView.ViewHolder{
//        TextView tvItemTodo;
//
//        TextView tvItem;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvItem = itemView.findViewById(android.R.id.text1);
//
//        }
//
//        // Update the view inside of the view holder with the data
//        public void bind(String item) {
//
//            tvItem.setText(item);
//            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    // Notify the listener which position was long pressed.
//                    longClickListner.onItemLongClicked(getAdapterPosition());
//                    return true;
//                }
//            });
//        }
//    }
//}

