package garage

class Bike(val ownerId: Int, val make: String, val model: String, val numberOfWheels: Int, var chain: String) extends Vehicle {


  override def toString(): String = {
    s"This bike is a $make $model with $numberOfWheels and the chain is a $chain"
  }


}
