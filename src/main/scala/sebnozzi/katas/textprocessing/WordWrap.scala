package sebnozzi.katas.textprocessing

import scala.collection.mutable.ListBuffer

object WordWrap {

  def wrap(text: String, limit: Int = 80): String = {
    val result = new StringBuffer()
    var position = 0

    for (word <- wordsWithTrailingSpace(text)) {
      if (position + word.size > limit) {
        result.append('\n')
        position = 0
      }
      result.append(word)
      position += word.size
    }

    result.toString
  }

  private def wordsWithTrailingSpace(text: String): Seq[String] = {
    val words = new ListBuffer[String]()
    val word = new ListBuffer[Char]()
    def pushWord() = { words += word.mkString; word.clear }
    for (ch <- text) {
      word += ch
      if (ch == ' ') pushWord()
    }
    pushWord()
    words
  }

}
