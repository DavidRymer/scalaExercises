object BasicExercises {

  def main(args: Array[String]): Unit = {
    println("Hello World!")

    val helloWorld = "Hello World!"
    println(helloWorld)

    def returnString(input: String): String = {
      input;
    }

    def typeInterface(input: Any): Any = {
      input

    }

    println(typeInterface("Hello World"))

    def lastOfString(string: String, number: Int): String = {
      string.substring(string.length - number, string.length)
    }

    println(lastOfString("Hello", 3))

    def replaceTwoStrings(string1: String, string2: String, charFind: Char, charReplace: Char): String = {
      string1.concat(string2).replace(charFind, charReplace)

    }

    println(replaceTwoStrings("Hello", "World", 'l', 'p'))

    def sum(num1: Int, num2: Int): Int = {
      num1 + num2
    }

    println(sum(1, 2))

    def conditionals(num1: Int, num2: Int, boolean: Boolean): Int = {
      if (boolean)
        num1 + num2
      else
        num1 * num2

    }

    println(conditionals(3, 3, true))
    println(conditionals(3, 3, false))

    def conditionals2(num1: Int, num2: Int, boolean: Boolean): Int = {
      var ans = 0
      if (boolean)
        ans = num1 + num2
      else
        ans = num1 * num2

      if ((num1 == 0 || num2 == 0) && boolean)
        ans = Math.max(num1, num2)
      ans
    }

    println(conditionals2(0, 3, true))
    println(conditionals2(3, 3, false))

    def iteration(string: String, numberOfPrints: Int): Unit = {
      for(i <- 1 to numberOfPrints)
        println(string)
    }

    iteration("Hello", 3)

    def iteration2(string: String, numberOfPrints: Int): Unit = {
      var word = ""
      for (i <- 1 to numberOfPrints) {
        word += string
      }

      iteration(word, numberOfPrints)


    }

    iteration2("H", 4)

    def iteration3(string1: String, string2: String, number: Int): Unit = {

      for (i<-1 to number) {

        if (i%3 == 0 && i%5 !=0)
          println(string1)
        else if (i%5 == 0 && i%3 !=0)
          println(string2)
        else if (i%3 == 0 && i%5 ==0)
          println(string1.concat(string2))
        else
          println(i)

      }
    }



    iteration3("Fizz", "Buzz", 100)

    def iteration4(string1: String, string2: String, number: Int): Unit = {
      if (number <= 1)
        println(1)

      else if (number%3 == 0 && number%5 !=0)
        println(string1)
      else if (number%5 == 0 && number%3 !=0)
        println(string2)
      else if (number%3 == 0 && number%5 ==0)
        println(string1.concat(string2))
      else
      println(number)

      if (number > 1)
      iteration4(string1, string2, number -1)
    }

    iteration4("Fizz", "Buzz", 100)

    def patternMatchingCon1(num1: Int, num2: Int, boolean: Boolean): Int = {
      boolean match {
        case true => num1 + num2
        case false => num1 * num2
      }
    }

    println(patternMatchingCon1(3,3,true))

    def patternMatchingCon2(num1: Int, num2: Int, boolean: Boolean): Int = {
      boolean match {
        case true =>
          if (num1 == 0 || num2 == 0) {
          Math.max(num1, num2)
        }
          else
          num1 + num2

        case false => num1 * num2
      }
    }

    println(patternMatchingCon2(3, 0, true))
    println(patternMatchingCon2(3, 0, false))

    def patternMatching2(numbers: Tuple2): Tuple2 = {

    }




  }






}
