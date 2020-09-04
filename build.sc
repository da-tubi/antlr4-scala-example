import mill._
import mill.define.{Sources, Target}
import scalalib._
import scalafmt._
import $ivy.`org.antlr:antlr4:4.8`
import org.antlr.v4.Tool

object example extends ScalaModule with ScalafmtModule {
  override def scalaVersion = "2.12.12"

  override def moduleDeps = Seq(antlr4)

  object test extends Tests {
    override def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.1.1")
    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }
}

object antlr4 extends JavaModule {

  override def ivyDeps = Agg(ivy"org.antlr:antlr4-runtime:4.8")

  def genAntlr = T {

    if (os.exists(millSourcePath / "src")) {
      os.remove.all(millSourcePath / "src")
    }

    Tool.main(Array(
      s"${millSourcePath.toString}/ArithmeticParser.g4",
      s"${millSourcePath.toString}/ArithmeticLexer.g4",
      "-o", s"${millSourcePath.toString}/src/arithmetic/antlr",
      "-package", "arithmetic.antlr",
      "-visitor"
    ))
  }
}