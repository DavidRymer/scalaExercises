package garage

class Customer(var customerId: Int, var name: String, val dateOfBirth: String, var postcode: String ) extends Person {


  override def toString(): String = {
    s"This Customer name is $name they were born $dateOfBirth and live at $postcode"
  }
}








