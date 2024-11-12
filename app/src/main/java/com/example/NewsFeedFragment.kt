package com.example

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.facebookclone.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFeedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.newsfeed, container, false)
        setupUI(view)
        return view
        //
    }

    private fun setupUI(view: View) {
        fetchPosts() // Make the API call to fetch posts
    }

    private fun fetchPosts() {
        // Make an API call to get posts
        RetrofitInstance.api.getPosts().enqueue(object : Callback<PostWrapper> {
            override fun onResponse(call: Call<PostWrapper>, response: Response<PostWrapper>) {
                if (response.isSuccessful) {
                    val postWrapper = response.body()
                    val posts = postWrapper?.posts
                    if (posts != null) {
                        displayPosts(posts) // Pass the posts to a method to display them in UI
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
        // Implement code here to display posts, e.g., setting them in a RecyclerView adapter
    }
}
