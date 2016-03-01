package com.knoldus.service

import java.sql._
/**
  * Created by knoldus on 12/2/16.
  */
object ConnectToDatabase {



  def connect():Connection={

    val driver:String = "com.mysql.jdbc.Driver"
    val path:String = "jdbc:mysql://localhost/studentdetail"
    val username:String = "root"
    val password:String = "akash"

    try {
      Class.forName(driver)
      val connection: Connection = DriverManager.getConnection(path, username, password)
      connection
    }
    finally{
    }
  }
}
