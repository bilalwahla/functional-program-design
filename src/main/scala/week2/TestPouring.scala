package week2

/**
  * .
  */
object TestPouring {
  def main(args: Array[String]): Unit = {
    val problem = new Pouring(Vector(4, 9, 19))
    println(problem.moves)

    println(problem.pathSets.take(2).toList)

    println(problem.solution(17))
  }
}
