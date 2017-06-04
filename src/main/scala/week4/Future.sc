import scala.concurrent.Future
import scala.util.{Failure, Success}

/*
The Try Class in previous section worked on synchronous computation. Synchronous programs with side effects block the
subsequent instructions as long as the current computation runs. Blocking on expensive computation might render the
entire program slow!.
 */

/*
Future is a type of monad the helps handle exceptions and latency and turns the program in a non-blocking asynchronous
program.
 */
// The function to be run asynchronously
val answerToLife: Future[Int] = Future {
  42
}

// These are various callback functions that can be defined
answerToLife onComplete {
  case Success(result) => result
  case Failure(t) => println("An error has occurred: " + t.getMessage)
}

answerToLife    // only works if the future is completed.