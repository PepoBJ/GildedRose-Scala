name := "GildedRose"

version := "1.0"

scalaVersion := "2.13.1"

resolvers += DefaultMavenRepository
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"

/** ********* COMMANDS ALIASES ******************/
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

// All the needed tasks before pushing to the repository (compile, compile test, format check in prod and test)
addCommandAlias("prep", ";c;tc")