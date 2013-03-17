package sebnozzi.katas.numberguess

import scala.util.Random

object Game {
  def randomNumber: Int = Random.nextInt(99) + 1
}

class Game(number: Int = Game.randomNumber, delegate:GameDelegate) {

  private var iteration = GameIteration(number)

  def attempts: Int = iteration.attempts
  def isWon = iteration.gameWon

  def playGame {

    var shouldAskForGuess = true

    while (shouldAskForGuess) {
      delegate.nextGuess match {
        case Some(guess) => handleGuess(guess)
        case None => { noMoreGuesses() }
      }
    }

    def handleGuess(guess: Int) {
      val (answer, nextIteration) = iteration.nextForGuess(guess)
      iteration = nextIteration
      delegate.onAnswer(answer)
      answer match {
        case Correct => gameWasWon()
        case _ => answerWasIncorrect()
      }
    }

    def noMoreGuesses() {
      shouldAskForGuess = false
    }

    def gameWasWon() {
      shouldAskForGuess = false
    }

    def answerWasIncorrect() {
      shouldAskForGuess = true
    }

  }

}