import java.util


import scala.collection.mutable
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

    def generateWords(words: String*):mutable.HashMap[String, ArrayBuffer[String]] = {
      var anagrams = ArrayBuffer[String]()
      val hashMap = new mutable.HashMap[String, ArrayBuffer[String]]

      words.foreach{word =>
        accumulateWords().foreach{ element =>
          if (element.toCharArray.sorted.sameElements(word.toLowerCase.toCharArray.sorted))
            anagrams += element
        }

        anagrams.nonEmpty match {
          case true => hashMap += (word -> anagrams)

            anagrams.foreach(println)
           println()

          case _ => println(s"No word found for \'$word\'")
        }

        anagrams.clear()
      }

      hashMap
    }
    generateWords("ppa", "cats")

    def mostAnagrams(anagrams: mutable.HashMap[String, ArrayBuffer[String]]): String = {
      anagrams.maxBy(_._2.length)._1
    }

    println("\n" + mostAnagrams(generateWords("cats", "ppa")))
  }

}
