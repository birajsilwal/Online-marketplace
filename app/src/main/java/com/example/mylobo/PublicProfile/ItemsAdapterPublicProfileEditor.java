package com.example.mylobo.PublicProfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylobo.R;

import java.util.List;

public class ItemsAdapterPublicProfileEditor extends RecyclerView.Adapter<ItemsAdapterPublicProfileEditor.ViewHolder> {

    private Context contextPublicProfile;
    private List<ItemPublicProfileEditor> itemPublicProfileEditors;

    public ItemsAdapterPublicProfileEditor(Context contextPublicProfile, List<ItemPublicProfileEditor> itemsPublicProfile) {
        this.contextPublicProfile = contextPublicProfile;
        this.itemPublicProfileEditors = itemsPublicProfile;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextPublicProfile).inflate(R.layout.item_item_public_profile_editor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapterPublicProfileEditor.ViewHolder holder, int position) {
        ItemPublicProfileEditor itemPublicProfileEditor = itemPublicProfileEditors.get(position);
        holder.bind(itemPublicProfileEditor);
    }

    @Override
    public int getItemCount() {
        return itemPublicProfileEditors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        EditText etNameEditor;
        EditText etUsernameEditor;
        EditText etEmailEditor;
        EditText etMajorEditor;
        EditText etBioEditor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etNameEditor = itemView.findViewById(R.id.etNameEditor);
            etUsernameEditor = itemView.findViewById(R.id.etUsernameEditor);
            etEmailEditor = itemView.findViewById(R.id.etEmailEditor);
            etMajorEditor = itemView.findViewById(R.id.etMajorEditor);
            etBioEditor = itemView.findViewById(R.id.etBioEditor);
        }

        public void bind(ItemPublicProfileEditor itemPublicProfileEditor) {
            etNameEditor.setText(itemPublicProfileEditor.getNameEditor());
            etUsernameEditor.setText(itemPublicProfileEditor.getUsernameEditor());
            etEmailEditor.setText(itemPublicProfileEditor.getEmailEditor());
            etMajorEditor.setText(itemPublicProfileEditor.getMajorEditor());
            etBioEditor.setText(itemPublicProfileEditor.getBioEditor());
        }
    }
}
