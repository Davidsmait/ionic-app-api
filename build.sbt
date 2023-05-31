ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

Compile / mainClass := Some("com.domain.timelapse.MainApp")


lazy val api = (project in file("api"))
  .settings(
    name:= "timelapse-api",

  )

lazy val business = (project.in(file("business")))
  .settings(
    name := "timelapse-business"
  )

lazy val data = (project in file("data"))
  .settings(
    name := "timelapse-data"
  )

lazy val root = (project in file("."))
  .settings(
    name := "timelapse-app"
  )
  .dependsOn(api, business, data)
  .aggregate(api, business, data)
