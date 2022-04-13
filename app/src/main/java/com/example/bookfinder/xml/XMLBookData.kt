package com.example.bookfinder.xml

import com.example.bookfinder.model.Book
import org.w3c.dom.Document
import java.io.InputStream
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

object XMLBookData {

    fun  readXMLBooks(stream: InputStream): Array<Book?> {
        var builder: DocumentBuilder? = null
        var xmlTree: Document? = null
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            xmlTree = builder.parse(stream)
        } catch (e: Exception) {
        }
        val titleList = xmlTree!!.getElementsByTagName("title")
        val yearList = xmlTree.getElementsByTagName("year")
        val pagesList = xmlTree.getElementsByTagName("pages")
        val genreList = xmlTree.getElementsByTagName("genre")
        val descriptionList = xmlTree.getElementsByTagName("description")
        val imageList = xmlTree.getElementsByTagName("image")
        val urlList = xmlTree.getElementsByTagName("url")
        val books = arrayOfNulls<Book>(titleList.length)
        for (i in books.indices) {
            val title = titleList.item(i).firstChild.nodeValue
            val year = yearList.item(i).firstChild.nodeValue
            val pages = pagesList.item(i).firstChild.nodeValue
            val genre = genreList.item(i).firstChild.nodeValue
            val description = descriptionList.item(i).firstChild.nodeValue
            val image = imageList.item(i).firstChild.nodeValue
            val url = urlList.item(i).firstChild.nodeValue
            books[i] = Book(
                title = title,
                year = year.toInt(),
                pages = pages.toInt(),
                genre = genre,
                description = description,
                image = image,
                url = url
            )
        }
        return books
    }

}