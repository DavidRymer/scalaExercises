
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object BrokenKeyboard {

  def main(args: Array[String]): Unit = {

    def accumulateWords(): ArrayBuffer[String] = {
      var dictionary = ArrayBuffer[String]()
      val bufferedSource = Source.fromFile("src/enable1.txt")
      for (line <- bufferedSource.getLines) {
        dictionary += line.toString

      }
      dictionary
    }

    def generateWords(words: String*):Unit = {
      var longestWords = ArrayBuffer[String]()
      words.foreach{word =>
        accumulateWords().foreach{ element =>
            if (element.toCharArray.distinct.toSet.subsetOf(word.toLowerCase.toCharArray.toSet))
              longestWords += element
        }

        longestWords.nonEmpty match {
          case true => println(longestWords.maxBy(_.length))
          case _ => println(s"No word found for \'$word\'")
        }

        longestWords.clear()
      }
    }
    generateWords("Nicholas Milner")
  }
}
