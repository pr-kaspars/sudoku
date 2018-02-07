name := "Sudoku"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.scala-js" %% "scalajs-test-interface" % "0.6.14",
  "org.scalatest" %% "scalatest" % "3.0.1",
  "com.novocode" % "junit-interface" % "0.11",
  "org.scala-lang" % "scala-library" % scalaVersion.value
)
