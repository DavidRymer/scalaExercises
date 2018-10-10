object IntermediateExercises {

  def main(args: Array[String]): Unit = {
    def blackjack(a: Int, b: Int): Int =  {
      if (a <= 21 && b <= 21)
        Math.max(a,b)
      else if (a <= 21 && b > 21)
        a
      else if (a>21 && b<=21)
        b
      else
        0
    }

    println(blackjack(13,22))

    def uniqueSum(a: Int, b: Int, c: Int): Int = {
      if (a == b && a != c)
        c
      else if (a == c && b != a)
        b
      else if (b == c && a != b)
        a
      else if (a == b && b== c)
        0
      else
        a + b + c
    }

    println(uniqueSum(1,1,1))

    def tooHot(temperature: Int, isSummer: Boolean): Boolean = {
      if (isSummer && temperature <= 100 & temperature >= 60)
        true
      else if (!isSummer && temperature <= 90 & temperature >= 60)
        true
      else
        false
    }

    println(tooHot(80, false))
    println(tooHot(100, false))
    println(tooHot(100, true))


  }



}
