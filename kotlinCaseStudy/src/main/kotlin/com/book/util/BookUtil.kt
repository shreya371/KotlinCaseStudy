package com.book.util

import com.book.app.DatabaseConnection
import com.book.model.Book
import java.util.*

class BookUtil {
    var databaseConnection= DatabaseConnection()
    var connection=databaseConnection.connect()

    var scanner= Scanner(System.`in`)



    fun insertBook(book :Book):Int{
        val prepareStmt=connection.prepareStatement("insert into book values(?,?,?,?,?)")
        prepareStmt.setString(1,book.bookId)
        prepareStmt.setString(2,book.bookTitle)
        prepareStmt.setString(3,book.bookAuthor)
        prepareStmt.setString(4,book.bookCategory)
        prepareStmt.setDouble(5,book.bookPrice)

        val rows = prepareStmt.executeUpdate()
        return rows

    }

    fun delete(deleteBookId:String):Int{
        val preparestmt=connection.prepareStatement("delete from book  where bookId=?")
        preparestmt.setString(1,deleteBookId)
        val rows=preparestmt.executeUpdate()
        return rows
    }


    fun dispalyAll():MutableList<Book>{
        var books= mutableListOf<Book>()
        val query = connection.prepareStatement("select * from Book")
        val result = query.executeQuery()

        while(result.next()){
            val bookId = result.getString("bookId")
            val bookTitle= result.getString("bookTitle")
            val bookAuthor= result.getString("bookAuthor")
            val bookCategory= result.getString("bookCategory")
            val bookPrice=result.getDouble("bookPrice")
            books.add(Book(bookId,bookTitle,bookAuthor,bookCategory,bookPrice))
        }
        return books

    }

    fun display(bookId:String):MutableList<Book>{
        var books= mutableListOf<Book>()
        var preparestmt=connection.prepareStatement("select * from book where bookId=?")
        preparestmt.setString(1,bookId)
        var result=preparestmt.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val bookTitle= result.getString("bookTitle")
            val bookAuthor= result.getString("bookAuthor")
            val bookCategory= result.getString("bookCategory")
            val bookPrice=result.getDouble("bookPrice")
            books.add(Book(bookId,bookTitle,bookAuthor,bookCategory,bookPrice))
        }
       return books
    }

    fun searchBookTitle(bookTitle:String):MutableList<Book>
        {
            var books= mutableListOf<Book>()
            var preparestmt=connection.prepareStatement("select * from book where bookTitle=?")
            preparestmt.setString(1,bookTitle)
            var result=preparestmt.executeQuery()
            while(result.next()){
                val bookId = result.getString("bookId")
                val bookTitle= result.getString("bookTitle")
                val bookAuthor= result.getString("bookAuthor")
                val bookCategory= result.getString("bookCategory")
                val bookPrice=result.getDouble("bookPrice")
                books.add(Book(bookId,bookTitle,bookAuthor,bookCategory,bookPrice))
            }
            return books
        }

    fun searchBookAuthor(bookAuthor:String):MutableList<Book>{
        var books= mutableListOf<Book>()
        var preparestmt=connection.prepareStatement("select * from book where bookAuthor=?")
        preparestmt.setString(1,bookAuthor)
        var result=preparestmt.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val bookTitle= result.getString("bookTitle")
            val bookAuthor= result.getString("bookAuthor")
            val bookCategory= result.getString("bookCategory")
            val bookPrice=result.getDouble("bookPrice")
            books.add(Book(bookId,bookTitle,bookAuthor,bookCategory,bookPrice))
        }
        return books

    }

    fun update(bookId:String,updatedValue:String):Int{
        val preparestmt=connection.prepareStatement("update book set bookId=? where bookId=?")
        preparestmt.setString(1,updatedValue)
        preparestmt.setString(2,bookId)

        var rows=preparestmt.executeUpdate()
        return rows

    }


/*


    fun update(bookId:Int,columnName:String):Int{

        if (columnName=="bookId"){
            val prepareStmt=connection.prepareStatement("update book  set bookId=? where bookId=?")
            println("enter updated book id")
            var updatedbookId=scanner.nextInt()
            //prepareStmt.setString(1,columnName)
            prepareStmt.setInt(1,updatedbookId)
            prepareStmt.setInt(2,bookId)
        }
        /*else if (columnName=="bookTitle"){
            println("enter updated book id")
            var updatedbookTitle=scanner.next()
            prepareStmt.setString(1,columnName)
            prepareStmt.setString(2,updatedbookTitle)
            prepareStmt.setInt(3,bookId)
            var rows=prepareStmt.executeUpdate()
            return rows
        }
        else if (columnName=="bookAuthor"){
            println("enter updated book author")
            var updatedbookAuthor=scanner.nextInt()
            prepareStmt.setString(1,columnName)
            prepareStmt.setInt(2,updatedbookAuthor)
            prepareStmt.setInt(3,bookId)
            var rows=prepareStmt.executeUpdate()
            return rows
        }
        else if (columnName=="bookCategory"){
            println("enter updated book category")
            var updatedbookCategory=scanner.nextInt()
            prepareStmt.setString(1,columnName)
            prepareStmt.setInt(2,updatedbookCategory)
            prepareStmt.setInt(3,bookId)
            var rows=prepareStmt.executeUpdate()
            return rows
        }
        else if (columnName=="bookPrice"){
            println("enter updated book price")
            var updatedbookPrice=scanner.nextInt()
            prepareStmt.setString(1,columnName)
            prepareStmt.setInt(2,updatedbookPrice)
            prepareStmt.setInt(3,bookId)

            var rows=prepareStmt.executeUpdate()
            return rows
        }*/
        return 0

    }*/


}