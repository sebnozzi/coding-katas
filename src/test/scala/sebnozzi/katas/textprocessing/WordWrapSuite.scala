package sebnozzi.katas.textprocessing

import org.scalatest.FunSuite

import WordWrap._

class WordWrapSuite extends FunSuite {

  test("a short line should not be wrapped") {
    assert(wrap("this is a short line") === "this is a short line")
  }

  test("a long line should be wrapped") {
    assert(wrap("this is a short line", max = 10) === "this is a \nshort line")
  }
  
  ignore("lines should be wrapped at word boundary") {
    assert(wrap("this is not short line", max = 10) === "this is \nnot short line")
  }

  ignore("a very long line should be wrapped in many lines") {
    val input = "this is not a so short line, unfortulately"
    val lines = wrap(input, max = 10).split("\n")
    val expected = Seq("this is ", "not a so ", "short ", "line, ", "unfortulately")

    assert(lines === expected)
  }

}