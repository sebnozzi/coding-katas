package sebnozzi.extensions

object Extensions {

  implicit class MyInt(wrappedInt: Int) {
    
    def isDivisibleByOrHasDigit(number: Int) = isDivisibleBy(number) || hasDigit(number)
    
    def isDivisibleBy(divisor: Int) = wrappedInt % divisor == 0
    
    def hasDigit(digit: Char): Boolean = wrappedInt.toString.contains(digit)
    
    def hasDigit(singleDigitNr: Int): Boolean = {
      assert(singleDigitNr >= 0 && singleDigitNr < 10, 
          s"Number should be 1 digit long (found: $singleDigitNr)")
      hasDigit(singleDigitNr.toString.head)
    }
  }
  
}