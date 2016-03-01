package com.knoldus.repo.repo
import java.sql._

import com.knoldus.service.ConnectToDatabase

/**
  * Created by akash on 26/2/16.
  */
class StudentOperation {

  def add(student:Student): Boolean = {
    val connection: Connection = ConnectToDatabase.connect()
    val query: String = "insert into student values (?,?,?)"
    try {
      val prepareStatement: PreparedStatement = connection.prepareStatement(query)
      prepareStatement.setInt(1, student.id)
      prepareStatement.setString(2, student.name)
      prepareStatement.setString(3, student.email)

      val number: Int = prepareStatement.executeUpdate()
      number match {
        case 1 => true
        case _ => false
      }
    }
    finally {
      connection.close()
    }
  }

  def read():List[Student]={

    val connection: Connection = ConnectToDatabase.connect()
    val query: String = "select * from student"
    try {
      val prepareStatement: PreparedStatement = connection.prepareStatement(query)
      val resultSet:ResultSet = prepareStatement.executeQuery()
      def readList(resultSet: ResultSet,list: List[Student]):List[Student]={

        resultSet match {
          case rs if rs.next() => readList(rs, Student(rs.getInt("student_id"), rs.getString("student_name"),rs.getString("student_email")) :: list)
          case _ => list
        }
      }
      readList(resultSet,List())
    }
    finally {
      connection.close()
    }
  }

  def readbyId(id:Int):Student= {
    val connection: Connection = ConnectToDatabase.connect()
    val query: String = "select * from student where student_id = ?"
    try {
      val prepareStatement: PreparedStatement = connection.prepareStatement(query)
      prepareStatement.setInt(1,id)
      val resultSet: ResultSet = prepareStatement.executeQuery()
      if(resultSet.next())
        {
          Student(resultSet.getInt("student_id"), resultSet.getString("student_name"),resultSet.getString("student_email"))
        }
      else
        Student(0,"","")
    }
    finally {
      connection.close()
    }
  }

}