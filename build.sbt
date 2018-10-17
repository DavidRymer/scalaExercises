name := "Exercises"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

libraryDependencies += "org.pegdown" % "pegdown" % "1.6.0" % Test

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")