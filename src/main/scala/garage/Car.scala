package garage

class Car(val ownerId: Int, val make: String, val model: String, val numberOfWheels: Int, var steeringWheel: String) extends Vehicle {


  override def toString(): String = {
    s"This car is a $make $model with $numberOfWheels and the steering wheel $steeringWheel"
  }


}
