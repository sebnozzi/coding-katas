package sebnozzi.katas.numberguess

import org.scalatest.FunSuite

class GameIterationSuite extends FunSuite {

  test("Initial iteration") {
    val iteration = GameIteration(number = 50)
    assert(iteration.attempts === 0)
    assert(iteration.gameWon === false)
  }

  test("Getting too low") {
    val initial = GameIteration(number = 50)
    val (answer, first) = initial.nextForGuess(49)
    assert(answer === TooLow)
  }

  test("Getting too high") {
    val initial = GameIteration(number = 50)
    val (answer, first) = initial.nextForGuess(51)
    assert(answer === TooHigh)
  }
  
  test("A first iteration with an incorrect answer") {
    val initial = GameIteration(number = 50)
    val (answer, first) = initial.nextForGuess(49)
    assert(first.attempts === 1)
    assert(first.gameWon === false)
    assert(answer === TooLow)
  }  
  
  test("A second iteration with the CORRECT answer") {
    val initial = GameIteration(number = 50)
    val (_, first) = initial.nextForGuess(49)
    val (answer, second) = first.nextForGuess(50)
    assert(second.attempts === 2)
    assert(second.gameWon === true)
    assert(answer === Correct)
  }
  
  
}