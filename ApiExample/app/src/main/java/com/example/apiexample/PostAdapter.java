package com.example.apiexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter{

    private List<Post> listPost;

    private Context context;

    public PostAdapter(List<Post> listPost, Context context) {
        this.listPost = listPost;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);

        View postView = inflater.inflate(R.layout.item_post,parent,false);

        ViewHolder viewHolder = new ViewHolder(postView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = listPost.get(position);

        ((ViewHolder) holder).txtId.setText(String.valueOf(post.getId()));
        ((ViewHolder) holder).txtUserId.setText(String.valueOf(post.getUserId()));
        ((ViewHolder) holder).txtTitle.setText(post.getTitle());
        ((ViewHolder) holder).txtBody.setText(post.getBody());

    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View itemView;
        public TextView txtUserId;
        public TextView txtId;
        public TextView txtTitle;
        public TextView txtBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;

            txtUserId = itemView.findViewById(R.id.textUserId);
            txtId = itemView.findViewById(R.id.textId);
            txtTitle = itemView.findViewById(R.id.textTitle);
            txtBody = itemView.findViewById(R.id.textBody);

        }
    }
}
