import scala.collection.mutable.ArrayBuffer
import scala.io.Source


object AdvancedExercises {

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
      var anagrams = ArrayBuffer[String]()
      words.foreach{word =>
        accumulateWords().foreach{ element =>
          if (element.toCharArray.sorted.sameElements(word.toLowerCase.toCharArray.sorted))
            anagrams += element
        }

        anagrams.nonEmpty match {
          case true => anagrams.foreach(println)

          case _ => println(s"No word found for \'$word\'")
        }

        anagrams.clear()
      }
    }
    generateWords("pol", "hello", "lol")
  }


}
