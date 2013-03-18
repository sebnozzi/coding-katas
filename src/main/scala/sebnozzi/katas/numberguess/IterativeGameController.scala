package sebnozzi.katas.numberguess

abstract class IterativeGameController() {

  def nextGuess: Option[Int]

  def onAnswer(answer: Answer)

  def playGame(game: Game) {

    var shouldAskForGuess = true

    while (shouldAskForGuess) {
      nextGuess match {
        case Some(guess) => handleGuess(guess)
        case None => { noMoreGuesses() }
      }
    }

    def handleGuess(guess: Int) {
      val (answer, nextIteration) = game.iterateWithGuess(guess)
      onAnswer(answer)
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