package sebnozzi.katas.numberguess

import scala.collection.Iterator

trait InteractiveGameController {

  def askGuess(): Option[Int]
  def showAnswer(answer: Answer, attemptNr: Int)

  def play(game: Game) {
    val guesses = Iterator.continually(askGuess()).takeWhile(guess => guess.isDefined && game.isOpen)
    for (Some(guess) <- guesses) {
      game.makeGuess(guess)
      showAnswer(game.lastAnswer, game.attempts)
    }
  }

}