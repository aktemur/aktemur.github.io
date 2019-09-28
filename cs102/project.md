---
layout: cs102default
---

## Term Project

Write an object-oriented program with a GUI for a FarmBank
according to the description below.
**The project should be conducted in pairs.**
Form a pair with a classmate, and inform Furkan Kınlı
by emailing him your names.

**Due date:** May 17th, 2018, 23:55.
Upload a zip file containing your project files to LMS.

FarmBank is an application that aims to connect
customers with local farmers.
Customers place orders and farmers receive these orders.
The cost of an order is
deducted from the customer's account and deposited
into the farmer's account. FarmBank gets 2% commission from each
order that a farmer receives.
So, for instance, if customer Deniz places an order from farmer Çetin
for a total of 80 TL, Deniz's account will be reduced by 80 TL,
Çetin's account will be increased by 78.40 TL, and FarmBank's
account will be increased by 1.60 TL.

A local farmer has a name, a list of locations that they can deliver to,
and a list of products.
A customer has a name and location.
A location has a name and zip code.

Generic products are:
milk, cheese, egg, meat, tomato, potato, apple, olive oil, artichoke.

Your program should have the following features:
1.  There should be a screen where a new customer can be registered to FarmBank
with an initial balance.

2.  a. There should be a screen where a new farmer can be registered to FarmBank.
When registering the farmer, the list of locations that the farmer can deliver to,
and the products he/she possesses must be created.

    b. To create a product, a generic product must be selected (e.g. cheese),
with a farmer-specific short description (e.g. "whole-fat Ezine"),
and the product's unit price must be entered. Unit can be "per kg",
"per liter", or "per piece" (e.g. for eggs, 1.10 TL per piece).

3.  There should be a screen where a customer can build an order.
An order is a collection of items. An item is a product together with
the specified amount (e.g. 2 kg of apples).
For this, the list of farmers that can deliver to the location of the
customer should be shown. When a farmer is selected, the products that can
be ordered should be shown. The customer should be able to create an item
and append this item into their order by picking a product
and entering the amount requested.

4.  When an order is placed, the money transfer shall occur.

5.  There should be a screen where we can see the list of registered customers,
farmers, and the balance of FarmBank.

### Implementation tips

Consider using [JTabbedPane](https://docs.oracle.com/javase/tutorial/uiswing/components/tabbedpane.html),
[JComboBox](https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html),
[JList](https://docs.oracle.com/javase/tutorial/uiswing/components/list.html).


### Grading schema
* Object-oriented design: 40 pts
* Completeness of features:
  - Feature 1: 8 pts
  - Feature 2.a: 6 pts
  - Feature 2.b: 6 pts
  - Feature 3: 20 pts
  - Feature 4: 10 pts
  - Feature 5: 10 pts
  
