package garage

abstract class Vehicle {
  def make: String
  def model: String
  def numberOfWheels: Int
  def ownerId: Int
  def costOfRepair: Int
  def timeToRepair: Int
  def toString(): String


}
