ThisBuild / scalaVersion := "3.5.2"

ThisBuild / Compile / run / fork := true

lazy val `pgquery-bindings` = (project in file("modules/pgquery-bindings"))
  .settings(
    organization := "com.exemple",
    version := "0.2.0"
  )

lazy val pgquery = (project in file("modules/pgquery"))
  .dependsOn(`pgquery-bindings`)
  .settings(
    organization := "com.exemple",
    version := "0.2.0"
  )

lazy val root = (project in file("."))
