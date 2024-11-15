package com.example

data class PostWrapper (
    val posts : List<Post>
)

data class Post(
    val author : String,
    val image : String?,
    val content : String,
    val pfp : String,
    val likes : Int,
    val commentsCount : Int,
    val shares : Int,
    val comments : List<Comment>
)