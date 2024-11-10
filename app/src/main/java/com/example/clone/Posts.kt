package com.example.clone

data class PostsApiResponse (
    var List<String> Posts
)

data class Posts(
    val author,
    val media,
    val status,
    val profile_picture
)