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

// Query with for
for (b <- books; a <- b.authors; if a.startsWith("Bird,")) yield b.title
// 'for' translation scheme used by compiler
// Step 1.
books.flatMap(b => for (a <- b.authors; if a.startsWith("Bird,")) yield b.title)
// Step 2.
books.flatMap(b => for(a <- b.authors.withFilter(a => a.startsWith("Bird,"))) yield b.title)
// Step 3.
books.flatMap(b => b.authors.withFilter(a => a.startsWith("Bird,")).map(y => b.title))

// last step of the translation above can also be written as
books.flatMap(b => b.authors.withFilter(_.startsWith("Bird,")).map(_ => b.title))
// and using postfix notation
books flatMap(b => b.authors withFilter(_ startsWith "Bird,") map(_ => b.title))

for (b <- books; if b.title.contains("Program")) yield b.title
// 'for' translation
books.withFilter(b => b.title.contains("Program")).map(b => b.title)

for {
  b1 <- books; b2 <- books; if b1.title < b2.title
  a1 <- b1.authors; a2 <- b2.authors; if a1 == a2
} yield a1
