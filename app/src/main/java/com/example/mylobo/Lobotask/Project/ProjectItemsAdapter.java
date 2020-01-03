package com.example.mylobo.Lobotask.Project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylobo.R;

import java.util.List;

public class ProjectItemsAdapter extends RecyclerView.Adapter<ProjectItemsAdapter.ViewHolder> {

    private Context contextProjectItem;
    private List<ProjectItem> projectItems;

    public ProjectItemsAdapter(Context context, List<ProjectItem> projectItems) {
        this.contextProjectItem = context;
        this.projectItems = projectItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextProjectItem).inflate(R.layout.item_project_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProjectItem projectItem = projectItems.get(position);
        holder.bind(projectItem);
    }

    @Override
    public int getItemCount() {
        return projectItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItemProjectItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemProjectItem = itemView.findViewById(R.id.tvItemProjectItem);
        }

        public void bind(ProjectItem projectItem){
            tvItemProjectItem.setText(projectItem.getProjectTodo());
        }
    }
}
