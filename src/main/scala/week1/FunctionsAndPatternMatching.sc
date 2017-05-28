val f:String => String = { case "ping" => "pong" }
f("ping")
//f("abc")

val f2: PartialFunction[String, String] = { case "ping" => "pong" }
f2.isDefinedAt("abc")
f2.isDefinedAt("ping")

val f3: PartialFunction[List[Int], String] = {
  case Nil => "one"
  case _ :: _ :: _ => "two"
}
f3.isDefinedAt(List(1))
f3.isDefinedAt(List(1, 2, 3))

val g: PartialFunction[List[Int], String] = {
  case Nil => "one"
  case x :: rest => rest match {
    case Nil => "two"
  }
}
g.isDefinedAt(List(1, 2, 3)) // is true
// BUT
//g(List(1, 2, 3)) // we get MatchError!!!
g(List(1))
/*
that means that isDefinedAt guarantees only at the outermost pattern
matching block.
 */