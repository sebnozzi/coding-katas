package sebnozzi.katas.numberguess

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

object GameControllerSuite {

  class PredefinedGuessController(guesses: Int*) extends IterativeGameController {

    val guessIterator = guesses.toIterator

    def nextGuess: Option[Int] = {
      if (guessIterator.hasNext)
        Some(guessIterator.next())
      else
        None
    }

    def onAnswer(answer: Answer) {}

  }

  def makeController(guesses: Int*) = {
    new PredefinedGuessController(guesses: _*)
  }

}

class GameControllerSuite extends FunSuite {

  import GameControllerSuite._

  test("gettings the corresponding answers for the guesses") {
    val game = new Game(number = 50)
    val answerObserver = new PredefinedGuessController(guesses = 49, 51, 50) {
      val answers = new ListBuffer[Answer]
      override def onAnswer(answer: Answer) {
        answers.append(answer)
      }
    }
    answerObserver.playGame(game)
    assert(answerObserver.answers.size === 3)
  }

  test("getting the Correct answer when trying all numbers") {
    val game = new Game()
    val controller = new PredefinedGuessController(guesses = (1 to 100): _*) {
      var gotCorrectAnswer = false
      override def onAnswer(answer: Answer) {
        if (answer == Correct) {
          gotCorrectAnswer = true
        }
      }
    }
    controller.playGame(game)
    assert(controller.gotCorrectAnswer, "Should have gotten a correct answer")
  }

}