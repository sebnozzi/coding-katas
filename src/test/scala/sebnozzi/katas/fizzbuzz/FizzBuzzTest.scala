package sebnozzi.katas.fizzbuzz

import org.scalatest.FunSuite
import FizzBuzz._

class FizzBuzzSuite extends FunSuite {

  test("1 translates to 1") {
    assert(fizzBuzzOf(1) === "1")
  }

  test("3 translates to Fizz") {
    assert(fizzBuzzOf(3) === "Fizz")
  }

  test("5 translates to Buzz") {
    assert(fizzBuzzOf(5) === "Buzz")
  }

  test("15 translates too Fizz-Buzz") {
    assert(fizzBuzzOf(15) === "Fizz-Buzz")
  }

  test("6 translates to Fizz") {
    assert(fizzBuzzOf(6) === "Fizz")
  }

  test("10 translates to Buzz") {
    assert(fizzBuzzOf(10) === "Buzz")
  }

  test("30 translates to Fizz-Buzz") {
    assert(fizzBuzzOf(30) === "Fizz-Buzz")
  }

  test("2 translates to 2") {
    assert(fizzBuzzOf(2) === "2")
  }

  test("game to upper bound 1") {
    assert(fizzBuzzUpTo(1) === List("1"))
  }

  test("game to upper bound 2") {
    assert(fizzBuzzUpTo(2) === List("1", "2"))
  }

  test("game to upper bound 3") {
    assert(fizzBuzzUpTo(3) === List("1", "2", "Fizz"))
  }

  test("game to upper bound 5") {
    assert(fizzBuzzUpTo(5) === List("1", "2", "Fizz", "4", "Buzz"))
  }

  test("game to upper bound 15") {
    assert(fizzBuzzUpTo(15).last === "Fizz-Buzz")
    assert(fizzBuzzUpTo(15)(14) === "Fizz-Buzz")
  }

  test("7 translates to Wizz") {
    assert(fizzBuzzOf(7) === "Wizz")
  }

  test("21 translates to Fizz Wizz") {
    assert(fizzBuzzOf(21) === "Fizz-Wizz")
  }

  test("105 translates to Fizz-Buzz-Wizz") {
    assert(fizzBuzzOf(105) === "Fizz-Buzz-Wizz")
  }

  test("35 translates to Fizz-Buzz-Wizz") {
    assert(fizzBuzzOf(35) === "Fizz-Buzz-Wizz")
  }

  test("13 translates to Fizz") {
    assert(fizzBuzzOf(13) === "Fizz")
  }

  test("53 translates to Fizz-Buzz") {
    assert(fizzBuzzOf(53) === "Fizz-Buzz")
  }

  test("17 translates to Wizz") {
    assert(fizzBuzzOf(17) === "Wizz")
  }

}