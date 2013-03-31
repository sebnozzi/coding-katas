package sebnozzi.katas.fizzbuzz

import sebnozzi.extensions.Extensions._

object FizzBuzz {

  def fizzBuzzUpTo(upperBound: Int) = (1 to upperBound).toList.map(fizzBuzzOf)

  def fizzBuzzOf(number: Int): String = {
    specialWordsFor(number: Int) match {
      case Seq() => number.toString
      case matchingWords => matchingWords.mkString("-")
    }
  }

  private case class SpecialWord(word: String, condition: (Int) => Boolean) {
    def correspondsTo(number: Int): Boolean = condition(number)
    override def toString = word
  }

  private lazy val specialWords = Seq(
    new SpecialWord("Fizz", condition = { number => number.isDivisibleByOrHasDigit(3) }),
    new SpecialWord("Buzz", condition = { number => number.isDivisibleByOrHasDigit(5) }),
    new SpecialWord("Wizz", condition = { number => number.isDivisibleByOrHasDigit(7) }))

  private def specialWordsFor(number: Int): Seq[SpecialWord] = {
    specialWords.filter { word => word.correspondsTo(number) }
  }

}
