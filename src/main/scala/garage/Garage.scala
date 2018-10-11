package garage

import scala.collection.mutable.HashMap

class Garage {

object Storage {
  val vehicles = HashMap[Int, Vehicle]()
  val employees = HashMap[Int, Employee]()
}

  def addCar(ownerId: Int, make: String, model: String, numberOfWheels: Int, steeringWheel: String): Boolean = {

    if (Storage.vehicles.get(ownerId) == null) {
      Storage.vehicles += (ownerId -> new Car(ownerId, make, model, numberOfWheels, steeringWheel))
      true
    } else {
      false
    }
  }

  def addBike(ownerId: Int, make: String, model: String, numberOfWheels: Int, chain: String): Boolean = {

    if (Storage.vehicles.get(ownerId) == null) {
      Storage.vehicles += (ownerId -> new Bike(ownerId,make,model,numberOfWheels,chain))
      true
    } else {
      false
    }
  }

  def addEmployee(employeeId: Int, name: String, dateOfBirth: String, title: String, salary: Int): Boolean = {

    if (Storage.employees.get(employeeId) == null) {
      Storage.employees += (employeeId -> new Employee(employeeId,name, dateOfBirth, title, salary))
      true
    } else {
      false
    }

  }
}
