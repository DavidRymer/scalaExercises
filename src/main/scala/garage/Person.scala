package garage

import java.util.Calendar

abstract class Person(var name: String, val dateOfBirth: Calendar, var title: String) {

  def toString: Unit


}
