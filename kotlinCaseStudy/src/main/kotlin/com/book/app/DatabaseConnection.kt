package com.book.app

import java.sql.Connection
import java.sql.DriverManager

class DatabaseConnection {

    fun connect(): Connection {
        val databaseURL ="jdbc:mysql://localhost:3306/kotlinCaseStudy"
        val connection= DriverManager.getConnection(databaseURL,"root","shreya123")
        return connection
    }
}