package com.example.bookfinder.model

data class Book(
    val title: String,
    val year: Int,
    val pages: Int,
    val genre: String,
    val description: String,
    val image: String,
    val url: String

) : java.io.Serializable
