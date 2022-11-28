package com.book.service

import com.book.model.Book
import com.book.util.BookUtil

class BookService {
    var bookUtil=BookUtil()

    fun addBook(book : Book):Int{
        var result=bookUtil.insertBook(book)
        return result
    }

    fun updateBook(bookId:String,updatedValue: String):Int{
        var result=bookUtil.update(bookId,updatedValue)
        return result
    }

    fun deleteBook(deleteBookId:String):Int{
        var result=bookUtil.delete(deleteBookId)
        return result
    }

    fun displayAllBooks():MutableList<Book>{
        return bookUtil.dispalyAll()
    }



    fun displayBook(bookId:String):MutableList<Book>{
        return bookUtil.display(bookId)
    }


    fun searchBookByTitle(bookTitle:String):MutableList<Book>{
        return bookUtil.searchBookTitle(bookTitle)
    }


    fun searchBookByAuthor(bookAuthor:String):MutableList<Book>{
        return bookUtil.searchBookAuthor(bookAuthor)
    }

    fun sortByPrice():List<Book>{
        return bookUtil.dispalyAll().sortedBy { it.bookPrice }

    }

}