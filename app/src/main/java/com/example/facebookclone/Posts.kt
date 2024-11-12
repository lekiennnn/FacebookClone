package com.example.facebookclone

data class PostWrapper (
    val posts : List<Post>
)

data class Post(
    val author : String,
    val media : String?,
    val status : String,
    val pfp : String,
    val likes : Int,
    val commentsCount : Int,
    val comments : List<Comment>
    //
)