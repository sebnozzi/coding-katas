package sebnozzi.katas.numberguess

import scala.util.Random

class Game(number: Int = Game.randomNumber) {

  private var currentIteration = GameIteration(number)

  def attempts: Int = currentIteration.attempts
  def isWon = currentIteration.gameWon
  def isOpen = !isWon

  def iterateWithGuess(guess: Int): (Answer, GameIteration) = {
    val (answer, nextIteration) = currentIteration.nextForGuess(guess)
    currentIteration = nextIteration
    (answer, currentIteration)
  }

}

object Game {
  def randomNumber: Int = Random.nextInt(99) + 1
}