import sbt._
import sbt.Keys._

object CodingkatasBuild extends Build {

  val scalaTest = "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test"

  lazy val codingkatas = Project(
    id = "codingkatas",
    base = file("."),
    settings = Project.defaultSettings ++ 
    seq(ScctPlugin.instrumentSettings : _*) ++
    Seq(
      name := "CodingKatas",
      organization := "sebnozzi",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.0",
      libraryDependencies ++= Seq(
      	scalaTest
      )
      // add other settings here
    )
  )
}
