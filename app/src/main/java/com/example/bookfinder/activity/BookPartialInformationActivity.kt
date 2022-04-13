package com.example.bookfinder.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.bookfinder.databinding.ActivityBookPartialInformationBinding
import com.example.bookfinder.model.Book

class BookPartialInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookPartialInformationBinding

    private var book: Book? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookPartialInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.extras != null) {
            book = intent.getSerializableExtra("book") as Book?
        }
        binding.currentBookTitle.text = book?.title ?: ""
        binding.currentBookPages.text = book?.pages.toString() + " pages"
        binding.currentBookYear.text ="Year: " + book?.year.toString()
        binding.currentBookImage.load(book?.image)

        binding.btnBookDescription.setOnClickListener {
            val myIntent = Intent(it.context, BookFullInformationActivity::class.java)
            myIntent.putExtra("book", book)
            startActivity(myIntent)
        }

    }
}