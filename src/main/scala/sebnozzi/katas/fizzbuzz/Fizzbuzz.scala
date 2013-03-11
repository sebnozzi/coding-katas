package sebnozzi.katas.fizzbuzz

import sebnozzi.extensions.Extensions._

object FizzBuzz {

  def fizzBuzzUpTo(upperBound: Int) = (1 to upperBound).toList.map(fizzBuzzOf)

  def fizzBuzzOf(number: Int): String = {
    specialWordsFor(number: Int) match {
      case Seq() => number.toString
      case allWords => allWords.mkString(" ")
    }
  }

  private case class SpecialWord(word: String, when: (Int) => Boolean) {
    def correspondsTo(number: Int): Boolean = when(number)
    override def toString = word
  }

  private lazy val specialWords = Seq(
    new SpecialWord("Fizz", when = { _.isDivisibleByOrHasDigit(3) }),
    new SpecialWord("Buzz", when = { _.isDivisibleByOrHasDigit(5) }),
    new SpecialWord("Wizz", when = { _.isDivisibleByOrHasDigit(7) }))

  private def specialWordsFor(number: Int): Seq[SpecialWord] = {
    specialWords.filter { word => word.correspondsTo(number) }
  }

}
