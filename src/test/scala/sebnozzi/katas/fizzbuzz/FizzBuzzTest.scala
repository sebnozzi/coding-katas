package sebnozzi.katas.fizzbuzz

import org.scalatest.FunSuite
import Fizzbuzz._

class FizzBuzzSuite extends FunSuite {
  
  test("1 translates to 1") {
    assert("1" === fizzBuzzOf(1))
  }
  
  test("3 translates to Fizz") {
    assert("Fizz" === fizzBuzzOf(3))
  }
  
  test("5 translates to Buzz") {
    assert("Buzz" === fizzBuzzOf(5))
  }
  
  test("15 translates too Fizz Buzz") {
    assert("Fizz Buzz" === fizzBuzzOf(15))
  }
  
  test("6 translates to Fizz") {
    assert("Fizz" === fizzBuzzOf(6))
  }
  
  test("10 translates to Buzz") {
    assert("Buzz" === fizzBuzzOf(10))
  }

  test("30 translates to Fizz Buzz") {
    assert("Fizz Buzz" === fizzBuzzOf(30))
  }

  test("2 translates to 2") {
    assert("2" === fizzBuzzOf(2))
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
    assert(fizzBuzzUpTo(15).last === "Fizz Buzz")
    assert(fizzBuzzUpTo(15)(14) === "Fizz Buzz")
  }
  
  test("7 translates to Wizz") {
    assert("Wizz" === fizzBuzzOf(7))
  }

  test("21 translates to Fizz Wizz") {
    assert(fizzBuzzOf(21) === "Fizz Wizz")
  }

  test("105 translates to Fizz Buzz Wizz") {
    assert(fizzBuzzOf(105) === "Fizz Buzz Wizz")
  }

  test("35 translates to Fizz Buzz Wizz") {
    assert(fizzBuzzOf(35) === "Fizz Buzz Wizz")
  }

  test("13 translates to Fizz") {
    assert(fizzBuzzOf(13) === "Fizz")
  }

  test("53 translates to Fizz Buzz") {
    assert(fizzBuzzOf(53) === "Fizz Buzz")
  }

  test("17 translates to Wizz") {
    assert(fizzBuzzOf(17) === "Wizz")
  }

}