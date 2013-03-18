package sebnozzi.katas.numberguess

import scala.util.Random

object Game {
  def randomNumber: Int = Random.nextInt(99) + 1
}

/**
 *
 */
class Game(number: Int = Game.randomNumber) {

  private var iteration = GameIteration(number)

  def attempts: Int = iteration.attempts
  def isWon = iteration.gameWon

  def iterateWithGuess(guess: Int): (Answer, GameIteration) = {
    val (answer, nextIteration) = iteration.nextForGuess(guess)
    iteration = nextIteration
    (answer, iteration)
  }

}