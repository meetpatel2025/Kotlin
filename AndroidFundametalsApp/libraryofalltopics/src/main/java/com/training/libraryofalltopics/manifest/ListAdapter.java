package com.training.libraryofalltopics.manifest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.training.libraryofalltopics.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.PostViewHolder> {
    private final List<UserData> dataList;

    public ListAdapter(List<UserData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.manifest_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        // Bind data to each row
        UserData post = dataList.get(position);
        holder.titleText.setText(post.getTitles());
        holder.bodyText.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // This class holds the references to the UI elements for each row
    static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, bodyText;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.textTitle);
            bodyText = itemView.findViewById(R.id.textBody);
        }
    }
}
