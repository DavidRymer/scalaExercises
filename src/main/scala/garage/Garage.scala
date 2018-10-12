package garage

import scala.collection.mutable
import scala.collection.mutable.HashMap

class Garage {

object Storage {
  val vehicles: mutable.HashMap[Int, Vehicle] = mutable.HashMap[Int, Vehicle]()
  val employees: mutable.HashMap[Int, Employee] = mutable.HashMap[Int, Employee]()
}

  def addCar(ownerId: Int, make: String, model: String, numberOfWheels: Int, steeringWheel: String, costOfRepair: Int, timeToRepair: Int): Boolean = {

    if (Storage.vehicles.get(ownerId).isEmpty) {
      Storage.vehicles += (ownerId -> new Car(ownerId, make, model, numberOfWheels, steeringWheel, costOfRepair, timeToRepair))
      Storage.vehicles.mkString(" ")
      true
    } else {
      false
    }
  }

  def addBike(ownerId: Int, make: String, model: String, numberOfWheels: Int, chain: String, costOfRepair: Int, timeToRepair: Int): Boolean = {

    if (Storage.vehicles.get(ownerId).isEmpty) {
      Storage.vehicles += (ownerId -> new Bike(ownerId,make,model,numberOfWheels,chain, costOfRepair, timeToRepair))
      true
    } else {
      false
    }
  }

  def addEmployee(employeeId: Int, name: String, dateOfBirth: String, title: String, salary: Int, workingHours: Int): Boolean = {

    if (Storage.employees.get(employeeId).isEmpty) {
      Storage.employees += (employeeId -> new Employee(employeeId,name, dateOfBirth, title, salary, workingHours))
      true
    } else {
      false
    }
  }
  def calculateBills(): Int = {
    var sum = 0
    Storage.vehicles.foreach(element => sum += element._2.costOfRepair)
    sum
  }

  def showVehicles(): Unit = {
    Storage.vehicles.foreach(element => println(element.toString()))
  }

  def totalEmployeeHours(): Int = {
    var total = 0
    Storage.employees.foreach(employee => total += employee._2.workHours)
    total
  }

  def workDay(): Unit = {
    var revenue = 0
    var hours = 0
    var i = 0

    while(hours <= totalEmployeeHours() || i <= Storage.vehicles.size) {
      revenue += Storage.vehicles(i).costOfRepair *2
      hours += Storage.vehicles(i).timeToRepair
      Storage.vehicles.remove(i)
      i += 1
    }

    println(s"Total revenue made today: £$revenue")
  }
}

object Test extends App {
  val garage = new Garage()
  garage.addCar(1,"Ford", "Fiesta", 4, "round", 200,3)
  garage.addBike(2,"Yamaha", "Zoomer", 2, "chainy", 150,3)
  garage.addEmployee(1, "John Doe", "21/05/1997", "Mechanic", 23500, 3)
  garage.workDay()
  println(garage.calculateBills())

}
