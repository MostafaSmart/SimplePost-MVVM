package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.Models.Post;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PostAdabter extends RecyclerView.Adapter<PostAdabter.UserViewHolder> {

    private List<Post> postList;

    public PostAdabter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        Post data =postList.get(position);

        holder.user_name.setText(data.getUser().getName());
        holder.post_text.setText(data.getDescr());

        if(!data.getImg_url().isEmpty()){
            Picasso.get().load("http://192.168.43.122/back_endone/"+data.getImg_url()).placeholder(R.drawable.acount_icon)
                    .error(R.drawable.add_icon).into(holder.img_post);

        }

    }



    @Override
    public int getItemCount() {
        return postList.size();

    }


    static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView user_name;
        private TextView post_time;
        private TextView post_text;
        private TextView user_location;
        private androidx.cardview.widget.CardView user_image;
        private androidx.cardview.widget.CardView post_image;
        private ImageView img_post;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            user_name = itemView.findViewById(R.id.user_name);
		post_time =itemView.findViewById(R.id.post_time);
		post_text =itemView.findViewById(R.id.post_text);
		user_image = itemView.findViewById(R.id.user_image);
		post_image = itemView.findViewById(R.id.post_image);
		user_location = itemView.findViewById(R.id.user_location);
            img_post = itemView.findViewById(R.id.img_post);
        }
    }
}