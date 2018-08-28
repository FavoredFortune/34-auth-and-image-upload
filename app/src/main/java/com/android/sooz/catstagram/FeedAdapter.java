package com.android.sooz.catstagram;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.PostViewHolder>{
    private List<Post> mPosts;

    public FeedAdapter(List<Post> allPostitems){
        mPosts = allPostitems;

    }

    @Override
    public int getItemCount(){
        return mPosts.size();
    }

    //see monday lecture 3:14
    public void setPosts(List<Post> posts){
        mPosts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.post_item, viewGroup, false);

        PostViewHolder viewHolder = new PostViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i){
        Post post = mPosts.get(i);
        postViewHolder.bind(post);
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        public View mView;

        public ImageView mImage;
        public TextView mUsername;
        public TextView mDescription;

        private Post mPost;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            mImage = mView.findViewById(R.id.photo);
            mUsername = mView.findViewById(R.id.username);
            mDescription = mView.findViewById(R.id.description);
        }

        public void bind(Post post){
            mPost = post;

            this.mUsername.setText(post.username);
            this.mDescription.setText(post.description);

            Picasso.get()
                    .load(post.imageUrl)
//                    .placeholder(R.drawable.loading)
                    .into(mImage);
        }
    }
}
