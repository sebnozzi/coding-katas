package sebnozzi.katas.numberguess

import scala.collection.Iterator

trait InteractiveGameController {

  def askGuess(): Option[Int]
  def showAnswer(answer: Answer, iteration: GameIteration)

  def playGame(game: Game) {
    val guesses = Iterator.continually(askGuess()).takeWhile(guess => guess.isDefined && game.isOpen)
    for (Some(guess) <- guesses) {
      val (answer, resultingIteration) = game.iterateWithGuess(guess)
      showAnswer(answer, resultingIteration)
    }
  }

}