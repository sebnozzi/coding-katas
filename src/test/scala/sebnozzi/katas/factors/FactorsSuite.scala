package sebnozzi.katas.factors

import org.scalatest.FunSuite
import Factors._

class FactorsSuite extends FunSuite {

  test("1 has no factors") {
    assert(factors(1).isEmpty)
  }
  
  test("2 has only itself as factor") {
    assert(factors(2) === Seq(2))
  }
  
  test("the factors of 9 are two times 3") {
    assert(factors(9) === Seq(3,3))
  }  
  
  test("the factors of 6 are 2 and 3") {
    assert(factors(6) === Seq(2,3))
  }  
  
  test("the factors of 4 are two times 2") {
    assert(factors(4) === Seq(2,2))
  }    
  
  test("the factors of 49 are two times 7") {
    assert(factors(49) === Seq(7,7))
  }   
  
  test("the factors of 3, 5, 7, etc. (prime numbers) are themselves") {
    val somePrimeNumbers = Seq(3,5,7,11,13,17)
    for(primeNumber <- somePrimeNumbers)
      assert(factors(primeNumber) === Seq(primeNumber))
  }
  
}