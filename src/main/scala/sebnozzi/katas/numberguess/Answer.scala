package sebnozzi.katas.numberguess

sealed abstract class Answer

case object Correct extends Answer
case object TooLow extends Answer
case object TooHigh extends Answer
