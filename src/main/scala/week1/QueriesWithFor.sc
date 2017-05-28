case class Book(title: String, authors: List[String])
val books = Set(
  Book(
    "Structure and Interpretation of Computer Programs",
    List("Abelson, Herald", "Sussman, Gerald J.")
  ),
  Book(
    "Introduction to Functional Programming",
    List("Bird, Richard", "Wadler, Phil")
  ),
  Book("Effective Java", List("Bloch, Joshua")),
  Book("Effective Java 2", List("Bloch, Joshua")),
  Book("Java Puzzlers", List("Bloch, Joshua", "Gafter, Neal")),
  Book(
    "Programming in Scala",
    List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")
  )
)

for (b <- books; a <- b.authors; if a.startsWith("Bird,")) yield b.title

for (b <- books; if b.title.contains("Program")) yield b.title

for {
  b1 <- books; b2 <- books; if b1.title < b2.title
  a1 <- b1.authors; a2 <- b2.authors; if a1 == a2
} yield a1