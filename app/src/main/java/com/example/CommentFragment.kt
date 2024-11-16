package com.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clone.R

class CommentFragment : Fragment(){
    private lateinit var rv_comments : RecyclerView
    private lateinit var commentAdapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.comment, container, false)
        setupUI(view)
        return view
    }

    private fun setupUI(view : View){
        rv_comments = view.findViewById(R.id.rv_comments)
        rv_comments.layoutManager = LinearLayoutManager(requireContext())

        fetchComments()
    }

    private fun fetchComments(){

    }
}