package sebnozzi.katas.textprocessing

import scala.collection.mutable.ListBuffer

object WordWrap {

  def wrap(text: String, max: Int = 80):String = {
    var position = 0
    val result = new StringBuffer()

    for (word <- splitInWords(text)) {
      if (position + word.size > max) {
        result.append('\n')
        position = 0
      }
      result.append(word)
      position = position + word.size
    }

    result.toString
  }

  def splitInWords(text: String) = {
    val words = new ListBuffer[String]
    val word = new ListBuffer[Char]
    for (c <- text) {
      word += c
      if (c == ' ') {
        words += word.mkString
        word.clear
      }
    }
    words += word.mkString
    words.toSeq
  }

}
