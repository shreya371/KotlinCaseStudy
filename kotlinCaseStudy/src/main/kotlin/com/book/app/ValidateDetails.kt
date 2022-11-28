package com.book.app

import com.book.app.exception.InvalidBookException

class ValidateDetails {

    fun validateCategory(bookCategory:String){

        if ((bookCategory!="Science") && bookCategory!="Fiction" && bookCategory!="Technology" && bookCategory!="Others"){
            throw InvalidBookException("Invalid book Exception -category ")
        }
    }
    fun validatePrice(bookPrice:Double){
        if (bookPrice<0){
            throw InvalidBookException("Invalid book exception - price")
        }
    }

    fun validateBookId(bookId:String){
        if (!(bookId.startsWith("B") && (bookId.length==4)))
            throw InvalidBookException("Invalid book exception- bookId")
    }




}