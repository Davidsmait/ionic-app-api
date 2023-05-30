ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

Compile / mainClass := Some("com.domain.timelapse.MainApp")


lazy val api = (project in file("api"))
  .settings(
    name:= "timelapse-api",

  )

lazy val root = (project in file("."))
  .settings(
    name := "ionic-app-api"
  )
  .dependsOn(api)
  .aggregate(api)
