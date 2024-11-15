package com.example

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clone.R
import com.squareup.picasso.Picasso

class PostAdapter(private val posts : List<Post>, private val listener: OnPostInteractionListener) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val newsfeed_items = layoutInflater.inflate(R.layout.newsfeed_items,parent,false)
        return PostViewHolder(newsfeed_items)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = posts[position]
        Picasso.get()
            .load(currentPost.pfp)
            .into(holder.img_pfp)

        Picasso.get()
            .load(currentPost.image)
            .into(holder.img_image)

        holder.tv_author.text = currentPost.author
        holder.tv_content.text = currentPost.content
        holder.tv_likeCounts.text = "${currentPost.likes} likes"
        holder.tv_commentCounts.text = "${currentPost.commentsCount} comments"
        holder.tv_shareCounts.text = "${currentPost.shares} shares"

        holder.btn_like.setOnClickListener{
            listener.OnLikeClicked(currentPost)
        }
        holder.btn_comment.setOnClickListener{
            listener.OnCommentClicked(currentPost)
        }
        holder.btn_share.setOnClickListener{
            listener.OnShareClicked(currentPost)
        }
    }

}

class PostViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val tv_author : TextView = view.findViewById(R.id.tv_author)
    val tv_content : TextView = view.findViewById(R.id.tv_content)
    val tv_likeCounts : TextView = view.findViewById(R.id.tv_likeCounts)
    val tv_commentCounts : TextView = view.findViewById(R.id.tv_commentCounts)
    val tv_shareCounts : TextView = view.findViewById(R.id.tv_shareCounts)

    val img_pfp : ImageView = view.findViewById(R.id.img_pfp)
    val img_image : ImageView = view.findViewById(R.id.img_image)

    val btn_like : Button = view.findViewById(R.id.btn_like)
    val btn_comment : Button = view.findViewById(R.id.btn_comment)
    val btn_share : Button = view.findViewById(R.id.btn_share)
}

interface OnPostInteractionListener{
    fun OnLikeClicked (post : Post)
    fun OnCommentClicked (post : Post)
    fun OnShareClicked (post : Post)
}