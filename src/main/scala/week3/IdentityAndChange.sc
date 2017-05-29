class BankAccount {
  private var balance = 0

  def deposit(amount: Int): Unit = {
    if (amount > 0) balance = balance + amount
  }

  def withdraw(amount: Int): Int = if (amount > 0 && amount <= balance) {
    balance = balance - amount
    balance
  } else throw new Error("insufficient funds")
}

// Operational equivalence
val x = new BankAccount
//val y = new BankAccount
x.deposit(30)
// Can not withdraw from y as nothing's been deposited.
//y.withdraw(20)  // java.lang.Error: insufficient funds

// Renaming all occurrences of y with x
x.withdraw(20)
// y.withdraw and x.withdraw result different, so we conclude they are not same.

// Establishing operational equivalence
val y = x
// nothing distinguishes them hence x and y are same in this case.

// The substitution model ceases to be valid when we add the assignment.