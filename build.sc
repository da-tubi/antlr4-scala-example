import mill._
import mill.define._
import scalalib._
import scalafmt._
import $file.antlr

import scala.collection.mutable

object example extends ScalaModule with ScalafmtModule with antlr.AntlrModule {
  override def scalaVersion = "3.0.0"

  override def ivyDeps = Agg(ivy"org.antlr:antlr4-runtime:4.8")

  override def antlrGenerateVisitor: Boolean = true

  override def antlrPackage: Option[String] = Some("arithmetic.antlr")

  override def antlrGrammarSources = T.sources {
    Seq(millSourcePath / "resources" / "antlr4").map(PathRef(_))
  }
}
