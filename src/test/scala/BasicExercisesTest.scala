import garage.Car
import org.scalatest.{FeatureSpec, FlatSpec, GivenWhenThen, Matchers}


class BasicExercisesTest extends FlatSpec with Matchers with GivenWhenThen {

  "This method" should "return input" in {
    assertResult(BasicExercises.returnString("Hello")){"Hello"}

  }

  "this method when inputted 4" should "return 4 of type int" in {
    assertResult(BasicExercises.typeInterface(4)){4}
  }

  "The last 3 letters of Hello" should "be llo" in {
    assertResult(BasicExercises.lastOfString("Hello",3)){"llo"}
  }

  "Adding 3 and 2" should "equal 5" in {
    BasicExercises.sum(3,2) should be (5)
  }

}





