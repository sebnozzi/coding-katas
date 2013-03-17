package sebnozzi.katas.numberguess

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

object GameDelegateSuite {

  class PredefinedGuessDelegate(guesses: Seq[Int]) extends GameDelegate {

    val guessIterator = guesses.toIterator

    def nextGuess: Option[Int] = {
      if (guessIterator.hasNext)
        Some(guessIterator.next())
      else
        None
    }

    def onAnswer(answer: Answer) {}

  }

  def makeGame(number: Int, guesses: Int*) = {
    val delegate = new PredefinedGuessDelegate(guesses)
    new Game(number, delegate)
  }

}

class GameDelegateSuite extends FunSuite {

  import GameDelegateSuite._

  test("gettings the corresponding answers for the guesses") {
    val answerObserver = new PredefinedGuessDelegate(Seq(49, 51, 50)) {
      val answers = new ListBuffer[Answer]
      override def onAnswer(answer: Answer) {
        answers.append(answer)
      }
    }
    val game = new Game(number = 50, delegate = answerObserver)
    game.playGame
    assert(answerObserver.answers.size === 3)
  }

  test("getting the Correct answer when trying all numbers") {
    val delegate = new PredefinedGuessDelegate((1 to 100).toSeq) {
      var gotCorrectAnswer = false
      override def onAnswer(answer: Answer) {
        if (answer == Correct) {
          gotCorrectAnswer = true
        }
      }
    }
    val game = new Game(delegate = delegate)
    game.playGame
    assert(delegate.gotCorrectAnswer, "Should have gotten a correct answer")
  }

}