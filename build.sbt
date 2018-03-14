name := "Sudoku"
version := "0.1"
scalaVersion := "2.12.4"

val circeVersion = "0.9.0"
val finchVersion = "0.17.0"
val scalatestVersion = "3.0.5"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-generic" % circeVersion,
  "com.github.finagle" %% "finch-core" % finchVersion,
  "com.github.finagle" %% "finch-circe" % finchVersion,
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "org.scalatest" %% "scalatest" % scalatestVersion % "test",
)
