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

  def showAnswer(answer: Answer, attemptNr: Int) {
    answer match {
      case TooLow => println("Try higher")
      case TooHigh => println("Try lower")
      case Correct => println(s"Correct! You won in ${attemptNr} attempts")
      case NoAnswer => // should not happen
    }
  }

  play(new Game)
}