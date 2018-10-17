import garage._
import org.scalatest.{FeatureSpec, GivenWhenThen}

class VehicleTest extends FeatureSpec with GivenWhenThen {
  feature("Fixing a car") {
    scenario("Mechanic fixes a car") {

      Given("The vehicle is broken")
      val car = new Car(1, "ford", "fiesta", 4, "round", 44, 3)
      assert(car.timeToRepair > 0)

      When("the car is fixed")
      car.fixVehicle(4)

      Then("The car should be fixed")
      assert(car.timeToRepair == 0)
    }
  }

  feature("Fixing a bike") {
    scenario("Mechanic fixes a bike") {

      Given("The vehicle is broken")
      val bike = new Bike(1, "Yamaha", "Zoomer", 2, "round", 44, 3)
      assert(bike.timeToRepair > 0)

      When("the bike is fixed")
      bike.fixVehicle(4)

      Then("The bike should be fixed")
      assert(bike.timeToRepair == 0)
    }
  }
}