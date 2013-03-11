package sebnozzi.katas.bowling

import org.scalatest.FunSuite
import BowlingScoreCalculator._

class ScoreCalculatorSuite extends FunSuite {

  test("gutter game should give 0") {
    assert(scoreOf("--") === 0)
  }

  test("only one roll of 2 should give 2") {
    assert(scoreOf("2") === 2)
  }

  test("one miss and 5 should give 5") {
    assert(scoreOf("-5") === 5)
  }

  test("strike should give ten, plus the next two balls (twice, one for the strike, one on their own)") {
    assert(scoreOf("X24-") === 10 + (2 + 4) * 2)
  }

  test("a spare should give ten, plus the next ball (twice, one for the spare, one on its own)") {
    assert(scoreOf("2/4-") === 10 + 4 * 2)
  }

  test("a game of 3 strikes should score 30 (the last 2 are bonus rolls)") {
    assert(scoreOf("XXX") === 10 + 10 + 10)
  }

  test("a game of one spare should score the 10 plus the value of the last roll") {
    assert(scoreOf("2/7") === 17)
  }

  test("a simple, non-final spare, should give 10") {
    assert(scoreOf("2/--") === 10)
  }

  test("strike plus spare should give 30 (strike+spare)+spare") {
    assert(scoreOf("X2/--") === 30)
  }

  test("final strike plus spare should give 20") {
    assert(scoreOf("--X2/") === 20)
  }

  // Examples taken from: http://codingdojo.org/cgi-bin/wiki.pl?KataBowling

  test("20 rolls: 10 pairs of 9 and miss") {
    assert(scoreOf("9-9-9-9-9-9-9-9-9-9-") === 90)
  }

  test("21 rolls: 10 pairs of 5 and spare, with a final 5") {
    assert(scoreOf("5/5/5/5/5/5/5/5/5/5/5") === 150)
  }

  test("12 rolls: 12 strikes") {
    assert(scoreOf("XXXXXXXXXXXX") === 300)
  }

}