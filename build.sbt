name := "rest-api"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.38"


libraryDependencies ++=  Seq(
                      "com.typesafe.akka" %% "akka-actor"                           % "2.4.2",
                     "com.typesafe.akka" %% "akka-http-spray-json-experimental"    % "2.0.3",
                      "com.typesafe.akka" %% "akka-stream-experimental" % "2.0.3",
                      "com.typesafe.akka" %% "akka-http-core-experimental" % "2.0.3"

)