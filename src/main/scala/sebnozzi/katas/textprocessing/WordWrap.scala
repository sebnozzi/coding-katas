package sebnozzi.katas.textprocessing

import scala.collection.mutable.ListBuffer

object WordWrap {

  def wrap(text: String, max: Int = 80) = {
    val words = splitBySpace(text)
    wrapWords(words, max)
  }

  def wrapWords(words: Seq[String], max: Int = 80) = {
    val result = new StringBuffer
    var position = 0

    for ((word, nextWord) <- pairsOfWordAndItsNext(words)) {
      result.append(word)
      position = position + word.length()
      if (position + nextWord.length() > max) {
        result.append("\n")
        position = 0
      }
    }
    result.toString()
  }

  def pairsOfWordAndItsNext(words: Seq[String]) = {
    val atLeastTwoWordsLastOneEmpty = ((words :+ "").padTo(2, ""))
    atLeastTwoWordsLastOneEmpty.sliding(2).map { x => Pair(x(0), x(1)) }.toSeq
  }

  def splitBySpace(text: String) = {
    val words = new ListBuffer[String]
    val word = new ListBuffer[Char]
    for (c <- text) {
      word.append(c)
      if (c == ' ') {
        words.append(word.mkString)
        word.clear
      }
    }
    words.append(word.mkString)
    words.toSeq
  }

}

class WordWrap {

}