package sebnozzi.katas.numberguess

trait GameDelegate {

  def nextGuess: Option[Int]

  def onAnswer(answer: Answer)

}