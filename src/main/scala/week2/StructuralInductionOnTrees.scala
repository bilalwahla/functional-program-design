package week2

/**
  * .
  */
object StructuralInductionOnTrees {
  def main(args: Array[String]): Unit = {
    println(Empty contains 1)
    println(Empty incl 1 contains 1)
    println(Empty incl 1 incl 2 contains 2)
  }
}
