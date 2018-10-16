package garage


import scala.collection.mutable.ArrayBuffer

class Garage {

object Storage {
  var vehicles = new ArrayBuffer[Vehicle]
  var employees = new ArrayBuffer[Employee]
}

  def addCar(ownerId: Int, make: String, model: String, numberOfWheels: Int, steeringWheel: String, costOfRepair: Int, timeToRepair: Int): Boolean = {

    if (findVehicleById(ownerId).isEmpty) {
      Storage.vehicles += new Car(ownerId, make, model, numberOfWheels, steeringWheel, costOfRepair, timeToRepair)
      Storage.vehicles.mkString(" ")
      true
    } else {
      false
    }
  }

  def addBike(ownerId: Int, make: String, model: String, numberOfWheels: Int, chain: String, costOfRepair: Int, timeToRepair: Int): Boolean = {

    if (findVehicleById(ownerId).isEmpty) {
      Storage.vehicles += new Bike(ownerId,make,model,numberOfWheels,chain, costOfRepair, timeToRepair)
      true
    } else {
      false
    }
  }

  def findEmployeeById(employeeId: Int): Option[Employee] = {
    var foundEmployee: Option[Employee] = None
    Storage.employees.foreach{employee =>
      if (employee.employeeId == employeeId) {
        foundEmployee = Some(employee)
      }
    }
    foundEmployee
  }

  def findVehicleById(ownerId: Int): Option[Vehicle] = {
    var foundVehicle: Option[Vehicle] = None
    Storage.vehicles.foreach{vehicle =>
      if (vehicle.ownerId == ownerId) {
        foundVehicle = Some(vehicle)
      }
    }
    foundVehicle
  }

  def addEmployee(employeeId: Int, name: String, dateOfBirth: String, title: String, salary: Int, workingHours: Int): Boolean = {

    if (findEmployeeById(employeeId).isEmpty) {
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
    var hoursUsed = 0

    Storage.vehicles.foreach{vehicle =>
      revenue += vehicle.costOfRepair * 2

      var hoursLeft = 0

      if (totalEmployeeHours() - hoursUsed > 0) {
        hoursLeft = totalEmployeeHours() - hoursUsed
      }
      else {
        hoursLeft = 0
      }
      hoursUsed += vehicle.timeToRepair
      vehicle.fixVehicle(hoursLeft)
      println(s"Fixed vehicle ${vehicle.make}" + s" ${vehicle.model} with owner ID: ${vehicle.ownerId}.")


    }

    println(s"Total revenue made today: £$revenue")
  }
}

object Test extends App {
  val garage = new Garage()
  garage.addCar(1,"Ford", "Fiesta", 4, "round", 200,3)
  garage.addBike(2,"Yamaha", "Zoomer", 2, "chainy", 150,3)
  garage.addEmployee(1, "John Doe", "21/05/1997", "Mechanic", 23500, 5)
  garage.workDay()




}
