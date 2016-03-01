package com.knoldus.service

import akka.actor.ActorSystem
import akka.http.scaladsl.Http

import akka.stream.ActorMaterializer
import com.knoldus.repo.repo.{StudentOperation, StudentRepository, Student}

//import scala.concurrent.ExecutionContext.Implicits.global


object HttpService extends App with Routes with FakeRepo {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  Http().bindAndHandle(route, "localhost", 9000)

}

trait FakeRepo extends StudentRepository {

  val list = List(Student(1,"Akash","akash@b.com"));
  val obj = new StudentOperation();

  def create(student:Student):Student= {
    val isSave:Boolean = obj.add(student);
    if(isSave)
      student
    else
      Student(0,"","")
  }

  def getById(id:Int):Student =	obj.readbyId(id);

  def getAll():List[Student]= {
    obj.read()
  }

}
