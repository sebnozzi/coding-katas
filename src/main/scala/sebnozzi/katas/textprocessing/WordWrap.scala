package sebnozzi.katas.textprocessing

import scala.collection.mutable.ListBuffer

object WordWrap {

  def wrap(text: String, max: Int = 80) = {
    val result = new StringBuffer
    var lineLength = 0
    for (c <- text) {
      if (lineLength >= max) {
        result.append("\n")
        lineLength = 0
      }
      result.append(c)
      lineLength = lineLength + 1
    }
    result.toString()
  }

}

class WordWrap {

}