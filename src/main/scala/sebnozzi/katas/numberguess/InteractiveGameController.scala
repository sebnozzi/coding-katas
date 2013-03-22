package sebnozzi.katas.numberguess

import scala.collection.Iterator

trait InteractiveGameController {

  def askGuess(): Option[Int]
  def showAnswer(answer: Answer, attemptNr: Int)

  def play(game: Game) {
    def shouldMakeGuess(guess: Option[Int]) = guess.isDefined && game.isOpen
    val guesses = Iterator.continually(askGuess).takeWhile(shouldMakeGuess)
    for (Some(guess) <- guesses) {
      game.makeGuess(guess)
      showAnswer(game.lastAnswer, game.attempts)
    }
  }

}