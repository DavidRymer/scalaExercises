package garage

class Bike(val ownerId: Int, val make: String, val model: String, val numberOfWheels: Int,
           var chain: String, val costOfRepair: Int, var timeToRepair: Int) extends Vehicle {


  override def toString(): String = {
    s"This bike is a $make $model with $numberOfWheels wheels and the chain is a $chain. It will cost £$costOfRepair to fix."
  }


}
