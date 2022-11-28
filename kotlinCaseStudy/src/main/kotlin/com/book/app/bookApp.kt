package com.book.app

import com.book.app.exception.InvalidBookException
import com.book.model.Book
import com.book.service.BookService
import java.util.*

fun main() {
    var bookService=BookService()

    var validateDetails =ValidateDetails()
    var scanner= Scanner(System.`in`)


    println("-------------MENU-----------------------")
    println("1.Add Book \n2.Modify Book \n3.Delete Book \n4.Display All Books \n5.Display Specific Book"
                + "\n6.Search Book by Title \n7.Search Book by Author\n8.sortByPrice9.exit");

    println("Enter choice")
    var choice=scanner.nextInt()
    while(choice<10){
        when(choice){
            1-> {

                //add book
                println("Enter bookId")
                var bookId=scanner.next()
                try {

                    //validating  book id
                    validateDetails.validateBookId(bookId)
                }catch(e:InvalidBookException){
                    println(e.message)
                }

                println("Enter bookTitle")
                var bookTitle:String=scanner.next()

                println("Enter bookAuthor")
                var bookAuthor:String=scanner.next()

                println("enter bookCategory")
                var bookCategory=scanner.next()
                try {
                    //validating category
                    validateDetails.validateCategory(bookCategory)
                }catch(e:InvalidBookException){
                    println(e.message)
                }

                println("Enter bookPrice ")
                var bookPrice=scanner.nextDouble()
                try {
                    //validating price
                    validateDetails.validatePrice(bookPrice)
                }catch(e:InvalidBookException){
                    println(e.message)
                }

                var book = Book(bookId,bookTitle,bookAuthor,bookCategory,bookPrice)
                var resultRows=bookService.addBook(book)
                if (resultRows>0) println("book inserted")
                else println("book not found")

            }
            2->{

                // update/modify book id
                println("enter book id to update")
                var bookId=scanner.next()
                println("enter updated value")
                var updatedValue=scanner.next()
                var result=bookService.updateBook(bookId,updatedValue)
                if (result>0) println("updated successfully")
                else println("book not found")

            }
            3->{
                //delete a specific book
                println("Enter bookId to delete")
                var deleteBookId=scanner.next()
                var result=bookService.deleteBook(deleteBookId)
                if (result>0) println("book deleted successfully")
                else println("book not found")
            }

            4->{
                //display all books
                var books=bookService.displayAllBooks()
                for (book in books){
                    println(book)
                }

            }

            5->{
                //display specific book details
                println("enter book id to display")
                var bookId=scanner.next()
                var bookList=bookService.displayBook(bookId)
                var length=bookList.size
                if (length>0) {
                    for (book in bookList) {
                        println(book)
                    }
                }
                else{
                    println("Book not found")
                }

            }

            6-> {
                //Search Book by Title
                println("enter  book title to search")
                var bookTitle=scanner.next()
                var bookTitleBooks=bookService.searchBookByTitle(bookTitle)
                var length=bookTitleBooks.size
                if(length>0) {
                    for (book in bookTitleBooks) {
                        println(book)
                    }
                }
                else{
                    println("book not found")
                }
            }

            7->{
                //search book by author
                println("enter  book Author to search")
                var bookAuthor=scanner.next()
                var bookAuthorBooks=bookService.searchBookByAuthor(bookAuthor)
                var length=bookAuthorBooks.size
                if (length>0) {
                    for (book in bookAuthorBooks) {
                        println(book)
                    }
                }
                else{
                    println("book not found")
                }
            }
            8->{//additional feature
                //sort by price
                var sortedBooksbyPrice=bookService.sortByPrice()
                for(book in sortedBooksbyPrice){
                    println(book)
                }
            }
            9-> {
                //exit
                System.exit(0)
            }



        }

        println("process completed, enter choice to continue")
        println("1.Add Book \n2.Modify Book \n3.Delete Book \n4.Display All Books \n5.Display Specific Book"
                + "\n6.Search Book by Title \n7.Search Book by Author\n8.sort by price\n9.Exit");

        var ch=scanner.nextInt()
        choice=ch
    }



    /*
    //---add book-----
    println("Enter bookId")
    var bookId:Int=scanner.nextInt()
    println("Enter bookTitle")
    var bookTitle:String=scanner.next()
    println("Enter bookAuthor")
    var bookAuthor:String=scanner.next()
    println("enter bookCategory")
    var bookCategory:String=scanner.next()
    println("Enter bookPrice ")
    var bookPrice:Double=scanner.nextDouble()
    var book = Book(bookId,bookTitle,bookAuthor,bookCategory,bookPrice)
    var resultRows=bookService.addBook(book)
    if (resultRows>0) println("book inserted")
    else println("book not found")
    //----add book----
*/

    //modify book details
    /*println("Enter book Id to update")
    var bookIdUpdate=scanner.nextInt()


    println("1.bookId\n2.bookTitle\n3.bookAuthor\n.4.bookCategory\n5.bookPrice")
    println("enter choice to update")
    var choice=scanner.nextInt()

    when(choice){
        1-> bookService.updateBook(bookIdUpdate,"bookId")
        2->bookService.updateBook(bookIdUpdate,"bookTitle")
        3->bookService.updateBook(bookIdUpdate,"bookAuthor")
        4->bookService.updateBook(bookIdUpdate,"bookCategory")
        5->bookService.updateBook(bookIdUpdate,"bookPrice")
    }*/

    /*
    //-----delete book-------
    var deleteBookId=scanner.nextInt()
    var result=bookService.deleteBook(deleteBookId)
    if (result>0) println("book deleted successfully")
    else println("book not found")

    //-----delete book------------*/


    /*
    //---display all----
    var books=bookService.displayAllBooks()
    for (book in books){
        println(book)
    }

    //---dispaly single book

    println("enter book id to display")
    var bookId=scanner.nextInt()
    var bookList=bookService.displayBook(bookId)
    for (book in bookList){
        println(book)
    }


    //--search by title
    println("enter  book title to search")
    var bookTitle=scanner.next()
    var bookTitleBooks=bookService.searchBookByTitle(bookTitle)
    for(book in bookTitleBooks){
        println(book)
    }


    //search by author
    println("enter  book Author to search")
    var bookAuthor=scanner.next()
    var bookAuthorBooks=bookService.searchBookByAuthor(bookAuthor)
    for(book in bookAuthorBooks){
        println(book)
    }


    */

}