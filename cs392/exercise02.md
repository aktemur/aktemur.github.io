---
layout: cs392default
---

## Exercise 02 (a)

Revise the [Exercise 01](exercise01.html) to eliminate memory leaks
that may be caused by cyclic strong references.
Use strong/weak/unowned references and option types.

**Case 1:** A customer may or may not have an account; an account may or may not have an owner.

**Case 2:** A customer may or may not have an account; an account always has an owner.

**Case 3:** A customer always has an account; an account always has an owner.

### Objective

Learn the uses of strong/weak/unowned references and option types.

## Exercise 02 (b)

Create an iOS app where there is a single customer with an account in the model (ignore the bank).
Display the customer name, account number and the current balance on the view.

Also have a text field and two buttons on your view.
The first button is labeled "Deposit", the second is labeled "Withdraw".
When the Deposit button is tapped, read the amount entered in the field, and deposit that amount into the account.
When the Withdraw button is tapped, read the amount entered in the field, and withdraw that amount from the account.
After either operation, update the account balance shown on the screen.

### Objective

Practice the MVC structure.
