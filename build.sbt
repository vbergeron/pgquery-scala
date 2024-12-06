ThisBuild / scalaVersion := "3.5.2"
ThisBuild / version := "0.2.0"
ThisBuild / organization := "com.exemple"
ThisBuild / Compile / run / fork := true

lazy val `pgquery-bindings` = (project in file("modules/pgquery-bindings"))

lazy val pgquery = (project in file("modules/pgquery"))
  .dependsOn(`pgquery-bindings`)

lazy val `pgquery-doobie` = (project in file("modules/pgquery-doobie"))
  .dependsOn(pgquery)
  .settings(
    libraryDependencies += "org.tpolecat" %% "doobie-postgres" % "1.0.0-RC5"
  )

lazy val `pgquery-skunk` = (project in file("modules/pgquery-skunk"))
  .dependsOn(pgquery)
  .settings(
    libraryDependencies += "org.tpolecat" %% "skunk-core" % "0.6.4"
  )

lazy val root = (project in file("."))
