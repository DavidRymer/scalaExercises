package garage


import scala.collection.mutable.{ArrayBuffer}

class Garage {

object Storage {
  var vehicles = new ArrayBuffer[Vehicle]
  var employees = new ArrayBuffer[Employee]
}

  def addCar(ownerId: Int, make: String, model: String, numberOfWheels: Int, steeringWheel: String, costOfRepair: Int, timeToRepair: Int): Boolean = {

    if (findVehicleById(ownerId) == null) {
      Storage.vehicles += new Car(ownerId, make, model, numberOfWheels, steeringWheel, costOfRepair, timeToRepair)
      Storage.vehicles.mkString(" ")
      true
    } else {
      false
    }
  }

  def addBike(ownerId: Int, make: String, model: String, numberOfWheels: Int, chain: String, costOfRepair: Int, timeToRepair: Int): Boolean = {

    if (findVehicleById(ownerId) == null) {
      Storage.vehicles += new Bike(ownerId,make,model,numberOfWheels,chain, costOfRepair, timeToRepair)
      true
    } else {
      false
    }
  }

  def findEmployeeById(employeeId: Int): Employee = {
    var foundEmployee: Employee = null
    Storage.employees.foreach{employee =>
      if (employee.employeeId == employeeId) {
        foundEmployee = employee
      }
    }
    foundEmployee
  }

  def findVehicleById(ownerId: Int): Vehicle = {
    var foundVehicle: Vehicle = null
    Storage.vehicles.foreach{vehicle =>
      if (vehicle.ownerId == ownerId) {
        foundVehicle = vehicle
      }
    }
    foundVehicle
  }

  def addEmployee(employeeId: Int, name: String, dateOfBirth: String, title: String, salary: Int, workingHours: Int): Boolean = {

    if (findEmployeeById(employeeId) == null) {
      Storage.employees += new Employee(employeeId, name, dateOfBirth, title, salary, workingHours)
      true
    } else {
      false
    }
  }

  def calculateBills(): Int = {
    var sum = 0
    Storage.vehicles.foreach(element => sum += element.costOfRepair)
    sum
  }

  def showVehicles(): Unit = {
    if (Storage.vehicles.nonEmpty)
      Storage.vehicles.foreach(element => println(element.toString()))
    else
      println("No vehicles to show")

  }

  def totalEmployeeHours(): Int = {
    var total = 0
    Storage.employees.foreach(employee => total += employee.workHours)
    total
  }

  def workDay(): Unit = {
    var revenue = 0
    var hours = 0


    while(hours <= totalEmployeeHours()) {
      revenue += Storage.vehicles(0).costOfRepair *2
      hours += Storage.vehicles(0).timeToRepair
      println(s"Fixed vehicle ${Storage.vehicles(0).make}" + s" ${Storage.vehicles(0).model} with owner ID: ${Storage.vehicles(0).ownerId}")
      Storage.vehicles.remove(0)
    }

//    for(j <- 0 to i) Storage.vehicles.remove(j)

    println(s"Total revenue made today: £$revenue")
  }
}

object Test extends App {
  val garage = new Garage()
  garage.addCar(1,"Ford", "Fiesta", 4, "round", 200,3)
  garage.addBike(2,"Yamaha", "Zoomer", 2, "chainy", 150,3)
  garage.addEmployee(1, "John Doe", "21/05/1997", "Mechanic", 23500, 3)
  garage.workDay()

}
