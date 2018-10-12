import java.util

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object BrokenKeyboard {

  def main(args: Array[String]): Unit = {

    def accumulateWords(): ArrayBuffer[String] = {
      var dictionary = ArrayBuffer[String]()
      val bufferedSource = Source.fromFile("C:\\Users\\Admin\\IdeaProjects\\Broken Keyboard\\src\\main\\scala\\enable1.txt")
      for (line <- bufferedSource.getLines) {
        dictionary += line.toString

      }
      dictionary
    }

    def generateWords(words: String*):Unit = {
      var longestWords = ArrayBuffer[String]()
      words.foreach{word =>
        accumulateWords().foreach{ element =>
            if (element.toCharArray.distinct.toSet.subsetOf(word.toCharArray.toSet))
              longestWords += element
        }
        if (longestWords.nonEmpty) {
          println(longestWords.maxBy(_.length))
        }
        else
          println(s"No word found for \'$word\'")


        longestWords.clear()
      }

    }

    generateWords("edcf", "bnik", "poil", "vybu", "hello", "f")

  }

}
