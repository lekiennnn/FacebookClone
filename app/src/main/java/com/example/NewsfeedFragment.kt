package com.example

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clone.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsfeedFragment : Fragment(), OnPostInteractionListener {

    private lateinit var rv_posts : RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.newsfeed, container, false)
        setupUI(view)
        return view
    }

    private fun setupUI(view: View) {
        rv_posts = view.findViewById(R.id.rv_posts)
        rv_posts.layoutManager = LinearLayoutManager(requireContext())

        fetchPosts() // API
    }

    private fun fetchPosts() {
        // Make an API call to get posts
        RetrofitInstance.api.getPosts().enqueue(object : Callback<PostWrapper> {
            override fun onResponse(call: Call<PostWrapper>, response: Response<PostWrapper>) {
                if (response.isSuccessful) {
                    val postWrapper = response.body()
                    val posts = postWrapper?.posts
                    if (posts != null) {
                        displayPosts(posts)
                    }
                } else {
                    Log.e("NewsFeedFragment", "Failed to get posts: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<PostWrapper>, t: Throwable) {
                Log.e("NewsFeedFragment", "API call failed: ${t.message}")
            }
        })
    }

    private fun displayPosts(posts: List<Post>) {
        postAdapter = PostAdapter(posts, this)
        rv_posts.adapter = postAdapter
    }

    override fun OnLikeClicked(post: Post) {

    }

    override fun OnCommentClicked(post: Post) {

    }

    override fun OnShareClicked(post: Post) {

    }
}
