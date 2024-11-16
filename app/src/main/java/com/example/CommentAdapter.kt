package com.example

import android.media.tv.TvView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.clone.R

class CommentAdapter(private val comments : List<Comment>) : RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val comment_items = layoutInflater.inflate(R.layout.comment_items,parent,false)
        return CommentViewHolder(comment_items)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val currentComments = comments[position]
        holder.tv_commenter.text = currentComments.commenter
        holder.tv_commentText.text = currentComments.commentText
    }
}

class CommentViewHolder (view : View) : RecyclerView.ViewHolder(view) {
    val tv_commenter = view.findViewById<TextView>(R.id.tv_commenter)
    val tv_commentText = view.findViewById<TextView>(R.id.tv_commentText)

}
