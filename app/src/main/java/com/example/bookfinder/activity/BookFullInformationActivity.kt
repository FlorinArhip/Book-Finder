package com.example.bookfinder.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import coil.load
import com.example.bookfinder.databinding.ActivityBookFullInformationBinding
import com.example.bookfinder.model.Book

class BookFullInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookFullInformationBinding

    private var book: Book? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookFullInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bookDescription.movementMethod = ScrollingMovementMethod()

        if (intent.extras != null) {
            book = intent.getSerializableExtra("book") as Book?
        }

        binding.bookTitle.text = book?.title ?: ""
        binding.bookDescription.text = book?.description ?: ""
        binding.bookGenre.text = book?.genre ?: ""
        binding.bookYear.text = "Year " + book?.year.toString()
        binding.bookPages.text = book?.pages.toString() + " pages"
        binding.bookImage.load(book?.image)

    }
}