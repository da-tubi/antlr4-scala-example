organization := "just.for.fun"

name := "arithmetic"

version := "0.1"

scalaVersion := "2.12.6"

// ANTLRv4

enablePlugins(Antlr4Plugin)

antlr4GenVisitor in Antlr4 := true // default = false

antlr4GenListener in Antlr4 := false // default = true

antlr4PackageName in Antlr4 := Option("arithmetic.antlr")

antlr4Version in Antlr4 := "4.7.1"