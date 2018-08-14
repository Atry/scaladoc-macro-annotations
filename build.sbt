scalacOptions ++= {
  import Ordering.Implicits._
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    Seq("-Ymacro-annotations")
  } else {
    Nil
  }
}


libraryDependencies ++= {
  import Ordering.Implicits._
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    Nil
  } else {
    Seq(compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full))
  }
}

crossScalaVersions in ThisBuild := Seq("2.12.6", "2.13.0-M4")

val macros = project.settings(
  scalacOptions ++= {
    import Ordering.Implicits._
    if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
      Seq("-Ymacro-annotations")
    } else {
      Nil
    }
  },
  libraryDependencies ++= {
    import Ordering.Implicits._
    if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
      Nil
    } else {
      Seq(compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full))
    }
  },
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % Provided
)

dependsOn(macros)
