package com.mockup.allexamples.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mockup.allexamples.models.retrofitR.PostsData;
import com.mockup.allexamples.R;

import java.util.ArrayList;

public class MyAdapterPosts extends RecyclerView.Adapter<MyAdapterPosts.MyViewHolder> {

    private ArrayList<PostsData> myPostsList;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView txtId;
        public TextView txtTitle;
        public TextView txtBody;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageViewR);
            txtId = itemView.findViewById(R.id.txt_idR);
            txtTitle = itemView.findViewById(R.id.txt_titleR);
            txtBody = itemView.findViewById(R.id.txt_bodyR);
        }
    }

    public MyAdapterPosts(ArrayList<PostsData> postsList){
        myPostsList = postsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.posts_view, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        PostsData posts = myPostsList.get(i);

        myViewHolder.mImageView.setImageResource(posts.getmImageResourse());
        myViewHolder.txtId.setText(posts.getmText1());
        myViewHolder.txtTitle.setText(posts.getmText2());
        myViewHolder.txtBody.setText(posts.getmText3());
    }

    @Override
    public int getItemCount() {
        return myPostsList.size();
    }
}
