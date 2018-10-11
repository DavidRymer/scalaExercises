package garage



class Employee(var employeeId: Int, var name: String, val dateOfBirth: String, var title: String, var salary: Int) extends Person {

  override def toString(): String = {
    s"This Employees name is $name they were born $dateOfBirth and they are a $title earning £$salary"
  }
}


