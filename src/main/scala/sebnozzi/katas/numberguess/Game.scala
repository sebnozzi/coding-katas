package sebnozzi.katas.numberguess

import scala.util.Random
import Game._

class Game(number: Int = Game.randomNumber) {

  private var state = GameState()
  private var _lastAnswer:Option[Answer] = None

  def attempts: Int = state.attempts
  def isWon = state.gameWon
  def isOpen = !isWon
  def lastAnswer = _lastAnswer match {
    case Some(answer) => answer
    case None => throw new IllegalStateException("Should make a guess first")
  }

  def makeGuess(guess: Int) {
    val answer = answerForGuess(guess)
    _lastAnswer = Some(answer)
    state = nextStateForAnswer(answer)
  }

  private def nextStateForAnswer(answer: Answer) = {
    answer match {
      case Correct => GameState(attempts + 1, gameWon = true)
      case _ => GameState(attempts + 1)
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

case class GameState(attempts: Int = 0, gameWon: Boolean = false)

sealed abstract class Answer
case object Correct extends Answer
case object TooLow extends Answer
case object TooHigh extends Answer

object Game {
  def randomNumber: Int = Random.nextInt(99) + 1

}