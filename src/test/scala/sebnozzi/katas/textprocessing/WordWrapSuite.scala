package sebnozzi.katas.textprocessing

import org.scalatest.FunSuite
import WordWrap._
import scala.io.Source

class WordWrapSuite extends FunSuite {

  test("a short line should not be wrapped") {
    assert(wrap("1234", limit = 5) === "1234")
  }

  test("a long line should be wrapped") {
    assert(wrap("1234 5678", limit = 5) === "1234 \n5678")
  }

  test("lines should be wrapped at word boundary") {
    assert(wrap("this is not short line", limit = 10) === "this is \nnot short \nline")
  }

  test("a very long line should be wrapped in many lines") {
    val input = "this is not a so short line, unfortulately"
    val lines = wrap(input, limit = 10).split("\n").toList
    val expected = Seq("this is ", "not a so ", "short ", "line, ", "unfortulately")

    assert(lines === expected)
  }

}