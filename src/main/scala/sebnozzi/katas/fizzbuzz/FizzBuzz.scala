package sebnozzi.katas.fizzbuzz

import sebnozzi.extensions.Extensions._

object FizzBuzz {

  def fizzBuzzOf(range: Range): List[String] = range.toList.map { num => fizzBuzzOf(num) }

  def fizzBuzzOf(number: Int): String = {
    wordsFor(number: Int) match {
      case Seq() => number.toString
      case wordsFound => wordsFound.mkString("-")
    }
  }

  private def wordsFor(number: Int): Seq[Word] = words.filter { word => word.correspondsTo(number) }

  private lazy val words = Seq(
    new Word("Fizz", condition = { number => number.isDivisibleByOrHasDigit(3) }),
    new Word("Buzz", condition = { number => number.isDivisibleByOrHasDigit(5) }),
    new Word("Wizz", condition = { number => number.isDivisibleByOrHasDigit(7) }))

  private class Word(word: String, condition: (Int) => Boolean) {
    def correspondsTo(number: Int): Boolean = condition(number)
    override def toString = word
  }

}

