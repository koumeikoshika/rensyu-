name := """todolist"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "bootstrap" % "3.3.2",
  "org.scalikejdbc" %% "scalikejdbc" % "2.2.2",
  "org.scalikejdbc" %% "scalikejdbc-config" % "2.2.2",
  "org.scalikejdbc" %% "scalikejdbc-play-plugin" % "2.3.4",
  "mysql" % "mysql-connector-java" % "5.1.34"
)
