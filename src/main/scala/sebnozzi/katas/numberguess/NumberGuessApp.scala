package sebnozzi.katas.numberguess

object NumberGuessApp extends App with InteractiveGameController {

  def askGuess: Option[Int] = {
    println("Guess a number:")
    val input = Console.in.readLine()
    try {
      Some(Integer.parseInt(input))
    } catch {
      case e: NumberFormatException => None
    }
  }

  def showAnswer(answer: Answer, iteration: GameIteration) {
    answer match {
      case Correct => println(s"Correct! You won in ${iteration.attempts} attempts")
      case TooLow => println("Try higher")
      case TooHigh => println("Try lower")
    }
  }

  val game = new Game()

  playGame(game)

}