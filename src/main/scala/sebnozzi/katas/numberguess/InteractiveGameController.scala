package sebnozzi.katas.numberguess

trait InteractiveGameController {

  def askGuess: Option[Int]

  def showAnswer(answer: Answer, iteration: GameIteration)

  def playGame(game: Game) {

    var shouldAskForGuess = true

    while (shouldAskForGuess) {
      askGuess match {
        case Some(guess) => handleGuess(guess)
        case None => { noMoreGuesses() }
      }
    }

    def handleGuess(guess: Int) {
      val (answer, resultingIteration) = game.iterateWithGuess(guess)
      showAnswer(answer, resultingIteration)
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