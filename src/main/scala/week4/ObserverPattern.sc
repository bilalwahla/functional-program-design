trait Subscriber {
  def handler(publisher: Publisher)
}

trait Publisher {
  private var  subscribers: Set[Subscriber] = Set()

  def subscribe(subscriber: Subscriber): Unit = subscribers += subscriber

  def unsubscribe(subscriber: Subscriber): Unit = subscribers -= subscriber

  def publish(): Unit = subscribers.foreach(_.handler(this))
}

class BankAccount extends Publisher {
  private var balance = 0

  def currentBalance = balance

  def deposit(amount: Int): Unit = {
    if (amount > 0) balance = balance + amount
    publish()
  }

  def withdraw(amount: Int): Unit =
    if (amount > 0 && amount <= balance) {
      balance = balance - amount
      publish()
  } else throw new Error("insufficient funds")
}

class Consolidator(observed: List[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))

  private var total: Int = _

  compute()

  private def compute() = total = observed.map(_.currentBalance).sum

  def handler(publisher: Publisher) = compute()

  def totalBalance = total
}

val a = new BankAccount
val b = new BankAccount
val c = new Consolidator(List(a, b))
c.totalBalance
a.deposit(20)
c.totalBalance
b.deposit(30)
c.totalBalance

/*
Good:
- decouples view from state
- allows to have a varying number of views given state
- simple to setup
Bad:
- forces imperative style since handlers are Unit-types
- many moving parts that needs to be coordinated
- concurrency makes things complicated
- views are still tightly bound to one state. Not coupled loosely enough
 */