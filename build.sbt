ThisBuild / scalaVersion := "2.13.10"

Compile / mainClass := Some("com.domain.timelapse.MainApp")


lazy val commonSettings = Seq(

  semanticdbEnabled := true,
  semanticdbVersion := scalafixSemanticdb.revision,
  scalacOptions ++= Seq(
    "-Wunused",
    "-Wdead-code",
    "-Xlint"
  ),

)

//lazy val commonDependencies = Seq(
//  "com.qrsof.authentiline" %% "authentiline-client" % "1.0.0-SNAPSHOT",
//)

lazy val api = (project in file("api"))
  .settings(
    name:= "timelapse-api",
    commonSettings
  )

lazy val business = (project in file("business"))
  .settings(
    name := "timelapse-business",
    commonSettings
  )

lazy val data = (project in file("data"))
  .settings(
    name := "timelapse-data",
    commonSettings
  )

lazy val root = (project in file("."))
  .settings(
    name := "timelapse-app",
    commonSettings
  )
  .dependsOn(api, business, data)
  .aggregate(api, business, data)

