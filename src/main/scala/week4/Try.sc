import scala.util.{Try, Success, Failure}

def answerToLife(nb: Int) : Try[Int] = {
  if (nb == 42) Success(nb)
  else Failure(new Exception("WRONG"))
}

answerToLife(42) match {
  case Success(t)           => t        // returns 42
  case failure @ Failure(_) => failure  // returns Failure(java.Lang.Exception: WRONG)
}