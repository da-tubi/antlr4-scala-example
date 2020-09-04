import mill._, scalalib._, scalafmt._

object example extends ScalaModule with ScalafmtModule {
  def scalaVersion = "2.13.3"

  object test extends Tests {
    override def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.1.1")
    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }
}