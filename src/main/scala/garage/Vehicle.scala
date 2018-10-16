package garage

abstract class Vehicle {
  val make: String
  val model: String
  val numberOfWheels: Int
  val ownerId: Int
  var costOfRepair: Int
  var timeToRepair: Int
  def toString: String
  def fixVehicle(hoursLeftOfDay: Int): Unit


}
