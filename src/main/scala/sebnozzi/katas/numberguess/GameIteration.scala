package sebnozzi.katas.numberguess

case class GameIteration(number: Int,
  attempts: Int = 0,
  gameWon: Boolean = false) {

  def nextForGuess(guess: Int): (Answer, GameIteration) = {
    val answer = answerForGuess(guess)
    (answer, nextIterationForAnswer(answer))
  }

  def nextIterationForAnswer(answer: Answer) = {
    answer match {
      case Correct => GameIteration(number, attempts + 1, gameWon = true)
      case _ => GameIteration(number, attempts + 1)
    }
  }

  def answerForGuess(guess: Int): Answer = {
    if (guess == number)
      Correct
    else if (guess > number)
      TooHigh
    else
      TooLow
  }

}