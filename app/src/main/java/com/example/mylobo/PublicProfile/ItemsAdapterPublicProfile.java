package com.example.mylobo.PublicProfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylobo.R;

import java.util.List;

public class ItemsAdapterPublicProfile extends RecyclerView.Adapter<ItemsAdapterPublicProfile.ViewHolder> {

    private Context contextPublicProfile;
    private List<ItemPublicProfileEditor> itemsPublicProfile;

    public ItemsAdapterPublicProfile(Context contextPublicProfile, List<ItemPublicProfileEditor> itemsPublicProfile) {
        this.contextPublicProfile = contextPublicProfile;
        this.itemsPublicProfile = itemsPublicProfile;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextPublicProfile).inflate(R.layout.item_item_public_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapterPublicProfile.ViewHolder holder, int position) {
        ItemPublicProfileEditor itemPublicProfileEditor = itemsPublicProfile.get(position);
        holder.bind(itemPublicProfileEditor);
    }

    @Override
    public int getItemCount() {
        return itemsPublicProfile.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameViewer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameViewer = itemView.findViewById(R.id.tvNameViewer);
        }

        public void bind(ItemPublicProfileEditor itemPublicProfileEditor) {
            tvNameViewer.setText(itemPublicProfileEditor.getNameEditor());
        }
    }
}
