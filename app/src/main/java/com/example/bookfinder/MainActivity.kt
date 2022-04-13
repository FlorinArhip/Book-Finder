package com.example.bookfinder


import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener

import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.ui.AppBarConfiguration
import com.example.bookfinder.adapter.BookAdapter
import com.example.bookfinder.databinding.ActivityMainBinding
import com.example.bookfinder.model.Book
import com.example.bookfinder.xml.XMLBookData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var adapter: BookAdapter? = null
    private lateinit var books: Array<Book?>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        books = XMLBookData.readXMLBooks(this.resources.openRawResource(R.raw.books))
        adapter = BookAdapter(this, books)
        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->

        })

    }

}