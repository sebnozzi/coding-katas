package sebnozzi.katas.numberguess


sealed abstract class Answer

case object Correct extends Answer
case object TooLow extends Answer
case object TooHigh extends Answer

case class GameIteration(number: Int,
  attempts: Int = 0,
  gameWon: Boolean = false) {

  def nextForGuess(guess: Int): (Answer, GameIteration) = {
    val answer = answerForGuess(guess)
    (answer, nextIterationForAnswer(answer))
  }

  private def nextIterationForAnswer(answer: Answer) = {
    answer match {
      case Correct => GameIteration(number, attempts + 1, gameWon = true)
      case _ => GameIteration(number, attempts + 1)
    }
  }

  private def answerForGuess(guess: Int): Answer = {
    if (guess == number)
      Correct
    else if (guess > number)
      TooHigh
    else
      TooLow
  }

}