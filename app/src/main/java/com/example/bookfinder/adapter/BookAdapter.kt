package com.example.bookfinder.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.bookfinder.R
import com.example.bookfinder.model.Book

class BookAdapter(
    private val context: Context,
    private val books: Array<Book?>
) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    //1
    override fun getCount(): Int {
        return books.size
    }

    //2
    override fun getItem(position: Int): Book? {
        return books[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item

        val customView = inflater.inflate(R.layout.book_cell, parent, false)

        val bookImage = customView.findViewById<ImageView>(R.id.book_image)
        val bookTitle = customView.findViewById<TextView>(R.id.book_tile)
        val bookGenre = customView.findViewById<TextView>(R.id.book_genre)

        bookTitle.text = this.books[position]?.title ?: ""
        bookGenre.text = this.books[position]?.genre ?: ""
        bookImage.load(this.books[position]?.image)


        return customView
    }
}