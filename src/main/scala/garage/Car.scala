package garage

class Car(val ownerId: Int, val make: String, val model: String, val numberOfWheels: Int,
          var steeringWheel: String, var costOfRepair: Int, var timeToRepair: Int) extends Vehicle {

  override def toString(): String = {
    s"This car is a $make $model with $numberOfWheels wheels and the steering wheel $steeringWheel. It will cost £$costOfRepair to fix." +
      s" It has $timeToRepair more hour(s) to repair."
  }

  override def fixVehicle(hoursLeftOfDay: Int): Unit = {
    if (hoursLeftOfDay < timeToRepair)
      timeToRepair -= hoursLeftOfDay
    else
      timeToRepair = 0
  }




}
