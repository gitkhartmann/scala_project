import org.scalatest.funsuite.AnyFunSuite

class HundredDoorsTest extends AnyFunSuite {

  test("Initial state of doors") {
    val numberOfDoors = 100
    val doors = Array.fill(numberOfDoors)(false)
    assert(doors.forall(_ == false), "All doors should be initially closed")
  }

  test("Toggle doors correctly") {
    val numberOfDoors = 100
    val doors = Array.fill(numberOfDoors)(false)

    for (pass <- 1 to numberOfDoors) {
      for (door <- pass to numberOfDoors by pass) {
        doors(door - 1) = !doors(door - 1)
      }
    }

    val expectedOpenDoors = List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)
    val openDoors = doors.zipWithIndex.collect {
      case (isOpen, index) if isOpen => index + 1
    }

    assert(openDoors == expectedOpenDoors, "The open doors should be square numbers")
  }

  test("Final state of doors") {
    val numberOfDoors = 100
    val doors = Array.fill(numberOfDoors)(false)

    for (pass <- 1 to numberOfDoors) {
      for (door <- pass to numberOfDoors by pass) {
        doors(door - 1) = !doors(door - 1)
      }
    }

    assert(doors.count(_ == true) == 10, "Exactly 10 doors should remain open")
  }
}