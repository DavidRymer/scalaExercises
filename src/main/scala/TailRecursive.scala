object TailRecursive extends App{
  def fibonacci(nthTerm: Int): Int = {

    nthTerm match {
      case 1 => 0
      case 2 => 1
      case _ => fibonacci(nthTerm -2) + fibonacci(nthTerm -1)
    }
  }

//  for (i<- 1 to 14) println(fibonacci(i))

  def fibonacciTail(nthTerm: Int): Unit = {

    nthTerm match {

      case 1 => println(0)
      case 2 => println(1)
      case _ => term(nthTerm)

        fibonacciTail(nthTerm - 1)

    }
  }

  def term(nthTerm: Int): Unit = {

    var a = 0
    var b = 1
    var c = 0


    for (i<- 0 to nthTerm) {
      c = a + b
      a = b
      b = c
    }
    println(c)

  }

  println(fibonacciTail(6))


}
