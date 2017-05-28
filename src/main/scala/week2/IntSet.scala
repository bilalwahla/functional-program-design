package week2

/**
  * .
  */
abstract class IntSet {
  def incl(x: Int): IntSet

  def remove(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  def remove(x: Int): IntSet = this

  def contains(x: Int): Boolean = false

  override def toString: String = "."

  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def remove(x: Int): IntSet = if (x < elem) new NonEmpty(elem, left.remove(x), right)
  else if (elem < x) new NonEmpty(elem, left, right.remove(x))
  else left.union(right)

  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  override def toString: String = "{" + left + elem + right + "}"

  def union(other: IntSet): IntSet = ((left union right) union other) incl elem
}