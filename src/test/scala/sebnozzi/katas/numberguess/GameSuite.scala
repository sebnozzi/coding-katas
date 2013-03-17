package sebnozzi.katas.numberguess

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

import sebnozzi.katas.numberguess._

class GameSuite extends FunSuite {

  import GameDelegateSuite._

  test("counting the number of attempts") {
    val game = makeGame(50, guesses = 49, 51, 50)
    game.playGame
    assert(game.attempts === 3)
  }

  test("winning a game in the first try") {
    val game = makeGame(number = 50, guesses = 50)
    game.playGame
    assert(game.attempts === 1)
    assert(game.isWon)
  }

  test("the guesses provided should drive the game") {
    val game = makeGame(number = 50, guesses = 49, 51, 50)
    game.playGame
  }

  test("the game loop should leave the game won, if there is a correct answer") {
    val game = makeGame(number = 50, guesses = 49, 51, 50)
    game.playGame
    assert(game.isWon, "game should be won")
  }

  test("the game loop should NOT leave the game won, if there was NOT a correct answer") {
    val game = makeGame(50, guesses = 49, 51, 76)
    game.playGame
    assert(!game.isWon, "game should be NOT be won")
  }

}