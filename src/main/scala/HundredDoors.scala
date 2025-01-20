object HundredDoors extends App {
  val numberOfDoors = 100
  val doors = Array.fill(numberOfDoors)(false)

  for (pass <- 1 to numberOfDoors) {
    for (door <- pass to numberOfDoors by pass) {
      doors(door - 1) = !doors(door - 1) // Меняем состояние двери
    }
  }

  val openDoors = for {
    (isOpen, index) <- doors.zipWithIndex
    if isOpen
  } yield index + 1

  println(s"Открытые двери: ${openDoors.mkString(", ")}")
}