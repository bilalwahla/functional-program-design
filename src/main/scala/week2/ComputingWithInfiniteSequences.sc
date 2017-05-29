def from(n: Int): Stream[Int] = n #:: from(n + 1)

// stream of all natural numbers
val nat = from(0)

// stream of all multiples of 4
val m4s = nat map(_ * 4)

(m4s take 3).toList

def sieve(s: Stream[Int]): Stream[Int] = s.head #:: sieve(s.tail filter(_ % s.head != 0))

// first 10 primes
sieve(from(2)).take(10).toList

def sqrtStream(x: Double): Stream[Double] = {
  def improve(guess: Double) = (guess + x / guess) / 2
  lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
  guesses
}
sqrtStream(4).take(10).toList

def isGoodEnough(guess: Double, x: Double) = math.abs((guess * guess - x) / x) < 0.0001

sqrtStream(4).filter(isGoodEnough(_, 4)).take(3).toList

val xs = from(1) map(_ * 2)
val ys = from(1) filter(_ % 2 == 0)
// computation of xs above is quicker than ys for multiples of 2

