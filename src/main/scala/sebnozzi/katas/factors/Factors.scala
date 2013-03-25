package sebnozzi.katas.factors

import scala.collection.mutable.ListBuffer
import sebnozzi.extensions.Extensions._

object Factors {

  def factors(number: Int) = {
    val factors = new ListBuffer[Int]()

    var n = number
    for (factor <- (2 to n)) {
      while (n isDivisibleBy(factor)) {
        factors.append(factor)
        n = n / factor
      }
    }

    factors.toSeq
  }

}