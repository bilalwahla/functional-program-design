val aStream = Stream(1, 2, 3) // tail is computed only when needed
aStream.size
aStream.tail

(1 to 1000).toStream

def streamRange(lo: Int, hi: Int): Stream[Int] = {
//  print(lo + " ")
  if (lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

streamRange(1, 10).take(3).toList

def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
(streamRange(1000, 10000) filter isPrime) apply 1