package sebnozzi.katas.numberguess

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

import sebnozzi.katas.numberguess._

class GameSuite extends FunSuite {

  def makeGame(number: Int, guesses: Int*) = {
    val game = new Game(number)
    guesses.foreach(guess => game.makeGuess(guess))
    game
  }

  test("Initial iteration") {
    val game = new Game(50)
    assert(game.attempts === 0)
    assert(game.isWon === false)
  }

  test("Asking for lastAnswer before making guess results in error") {
    val game = new Game(50)
    intercept[IllegalStateException] {
      game.lastAnswer
    }
  }

  test("Getting too low") {
    val game = makeGame(50, guesses = 49)
    assert(game.lastAnswer === TooLow)
  }

  test("Getting too high") {
    val game = makeGame(50, guesses = 51)
    assert(game.lastAnswer === TooHigh)
  }

  test("A first iteration with an incorrect answer") {
    val game = makeGame(50, guesses = 49)
    assert(game.attempts === 1)
    assert(game.isWon === false)
    assert(game.lastAnswer != Correct)
  }

  test("A second iteration with the CORRECT answer") {
    val game = makeGame(50, guesses = 49, 50)
    assert(game.attempts === 2)
    assert(game.isWon === true)
    assert(game.lastAnswer === Correct)
  }

  test("counting the number of attempts") {
    val game = makeGame(50, guesses = 49, 51, 50)
    assert(game.attempts === 3)
  }

  test("winning a game in the first try") {
    val game = makeGame(number = 50, guesses = 50)
    assert(game.attempts === 1)
    assert(game.isWon)
  }

  test("the game loop should leave the game won, if there is a correct answer") {
    val game = makeGame(number = 50, guesses = 49, 51, 50)
    assert(game.isWon, "game should be won")
  }

  test("the game loop should NOT leave the game won, if there was NOT a correct answer") {
    val game = makeGame(50, guesses = 49, 51, 76)
    assert(game.isOpen, "game should be NOT be won")
  }

}