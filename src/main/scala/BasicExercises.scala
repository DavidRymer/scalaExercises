import scala.reflect.internal.util.Collections


object BasicExercises {

  def main(args: Array[String]): Unit = {
    println("Hello World!")

    val helloWorld = "Hello World!"
    println(helloWorld)

    def returnString(input: String): String = input

    println(returnString("Hello, World!"))

    def typeInterface(input: Any): Any = input

    println(typeInterface("Hello World"))

    def lastOfString(string: String, number: Int): String = string.substring(string.length - number, string.length)

    println(lastOfString("Hello", 3))

    def replaceTwoStrings(string1: String, string2: String, charFind: Char, charReplace: Char): String = {
      string1.concat(string2).replace(charFind, charReplace)

    }

    println(replaceTwoStrings("Hello", "World", 'l', 'p'))

    def sum(num1: Int, num2: Int): Int = num1 + num2

    println(sum(1, 2))

    def conditionals(num1: Int, num2: Int, modifier: Boolean): Int = {
      if (modifier)
        num1 + num2
      else
        num1 * num2

    }

    println(conditionals(3, 3, true))
    println(conditionals(3, 3, false))

    def conditionals2(num1: Int, num2: Int, modifier: Boolean): Int = {
      modifier match {
        case true => num1 + num2
        case false => num1 * num2
        case a if (num1 == 0 || num2 == 0) && a =>
          Math.max(num1, num2)
      }

    }

    println(conditionals2(0, 3, true))
    println(conditionals2(3, 3, false))

    def iteration(string: String, numberOfPrints: Int): Unit = (1 to numberOfPrints).foreach(_ => println(string))

    iteration("Hello", 3)

    def iteration2(string: String, numberOfPrints: Int): Unit = {
      val word = new StringBuilder("")

      (1 to numberOfPrints).foreach(_ => word.append(string + " "))

      iteration(word.toString(), numberOfPrints)
    }

    iteration2("H", 4)

    def iteration3(string1: String, string2: String, number: Int): Unit = {

      for (i<-1 to number) {
        val output = new StringBuilder("")

          if (i%3 == 0) output.append(string1)
          if (i%5 == 0) output.append(string2)
          if (output.toString().equals("")) output.append(i)

        println(output)
      }
    }

    iteration3("Fizz", "Buzz", 100)

    def iteration4(string1: String, string2: String, number: Int): Unit = {
      if (number <= 1) println(1)

      val output = new StringBuilder("")

      if (number%3 == 0) output.append(string1)
      if (number%5 == 0) output.append(string2)
      if (output.toString().equals("")) output.append(number)

      println(output)

      if (number > 1)
        iteration4(string1, string2, number -1)
    }

    iteration4("Fizz", "Buzz", 100)

    def patternMatchingCon1(num1: Int, num2: Int, boolean: Boolean): Int = if (boolean) {
      num1 + num2
    } else {
      num1 * num2
    }

    println(patternMatchingCon1(3,3,true))

    def patternMatchingCon2(num1: Int, num2: Int, boolean: Boolean): Int = boolean match {
      case true =>
        if (num1 == 0 || num2 == 0) {
          Math.max(num1, num2)
        }
        else
          num1 + num2

      case false => num1 * num2
    }


    println(patternMatchingCon2(3, 0, true))
    println(patternMatchingCon2(3, 0, false))

    def patternMatching2(numbers: Any): Any = numbers match {
      case numbers:(Int, Int) => numbers.swap
      case numbers:Array[Int] if numbers.length == 2 => numbers.reverse.mkString(", ")
      case numbers:List[Int] if numbers.length == 2 => numbers.reverse.mkString(", ")
      case _ => "Not a pair"
    }

    val a = List(2,3)
    println(patternMatching2(a))


    def functional1(): Any = {
      java.util.TimeZone.getAvailableIDs()
        .map(element => element.split("/"))
        .filter(element => element.length > 1)
        .flatMap(_.toList)
        .distinct
        .grouped(30)
        .toList
        .foreach(element => println(element.mkString("\n")))
    }

    iteration2("H", 4)

  }


}
