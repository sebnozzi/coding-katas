package sebnozzi.katas.numberguess

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

class InteractiveGameControllerSuite extends FunSuite {

  class PredefinedGuessController(guesses: Int*) extends InteractiveGameController {
    val guessIterator = guesses.toIterator

    def askGuess: Option[Int] = {
      if (guessIterator.hasNext)
        Some(guessIterator.next())
      else
        None
    }

    def showAnswer(answer: Answer, iteration: GameIteration) {}
  }

  def makeController(guesses: Int*) = {
    new PredefinedGuessController(guesses: _*)
  }

  test("gettings the corresponding answers for the guesses") {
    val game = new Game(number = 50)
    val answerObserver = new PredefinedGuessController(guesses = 49, 51, 50) {
      val answers = new ListBuffer[Answer]
      override def showAnswer(answer: Answer, iteration: GameIteration) {
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
      override def showAnswer(answer: Answer, iteration: GameIteration) {
        if (answer == Correct) {
          gotCorrectAnswer = true
        }
      }
    }
    controller.playGame(game)
    assert(controller.gotCorrectAnswer, "Should have gotten a correct answer")
  }
  
  test("it should stop requesting guesses once game is won"){
    val game = new Game(number = 50)
    val controller = new PredefinedGuessController(guesses = 49, 51, 52, 50, 49, 47) 
    controller.playGame(game)
    assert(game.attempts === 4)
    assert(game.isWon)
  }

}