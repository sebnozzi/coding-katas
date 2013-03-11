package sebnozzi.extensions

object Extensions {

  implicit class MyInt(thisNumber: Int) {
    def isDivisibleByOrHasDigit(other: Int) = { isDivisibleBy(other) || hasDigit(other) }
    def isDivisibleBy(other: Int) = thisNumber % other == 0
    def hasDigit(c: Char): Boolean = thisNumber.toString.contains(c)
    def hasDigit(x: Int): Boolean = {
      assert(x >= 0 && x < 10, s"Number should be 1 digit long (found: $x)")
      hasDigit(x.toString.head)
    }
  }
  
}