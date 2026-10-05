# 🛒 Supermarket POS System

## Lozano - Lascano

# 🎯 Project Goal

Build a terminal-based supermarket POS system that allows a cashier to:

* View available products
* Select products
* Enter quantities
* Add products to a cart
* Calculate subtotals
* Calculate the total purchase
* Accept payment
* Calculate change
* Display a receipt
* Update inventory
* Handle invalid input
* Serve multiple customers

---

# 🗺️ Development Roadmap

## Phase 0 — Planning

* [ ] Define what the POS needs to do
* [ ] Determine what information needs to be stored
* [ ] Decide how products will be represented
* [ ] Decide how inventory will be represented
* [ ] Decide how the shopping cart will be represented
* [ ] Sketch the program flow
* [ ] Sketch the main menu

### Concepts

* Problem decomposition
* Program flow
* Planning
* Data organization

---

# Phase 1 — Basic Program

Create the foundation of the program.

* [ ] Create the Java project
* [ ] Create one main class
* [ ] Create `main()`
* [ ] Display a welcome message
* [ ] Create the basic menu
* [ ] Read the user's menu choice
* [ ] Use `switch`
* [ ] Add an exit option
* [ ] Make the menu repeat

### Concepts

* `Scanner`
* Variables
* `System.out`
* `switch`
* `do-while`

---

# Phase 2 — Product Data

Create the supermarket's product inventory using basic data structures.

Decide what information needs to be stored:

```text
Product ID
Product Name
Product Price
Product Stock
```

* [ ] Create product IDs
* [ ] Create product names
* [ ] Create product prices
* [ ] Create product stock quantities
* [ ] Store product information using arrays or `ArrayList`
* [ ] Create several sample products
* [ ] Display all products

### Concepts

* Arrays
* `ArrayList`
* Indexes
* Strings
* Primitive data types

---

# Phase 3 — Product Selection

Allow the cashier to select products.

* [ ] Ask for product ID
* [ ] Search for the product
* [ ] Determine whether the product exists
* [ ] Display the selected product
* [ ] Ask for quantity
* [ ] Check available stock
* [ ] Reject invalid quantities
* [ ] Add the product to the cart

### Concepts

* `for` loops
* `if / else`
* Methods
* Arrays
* `ArrayList`

---

# Phase 4 — Shopping Cart

Create a temporary cart using basic data structures.

* [ ] Decide what information the cart needs
* [ ] Store selected product IDs
* [ ] Store selected quantities
* [ ] Display cart contents
* [ ] Calculate each item's subtotal
* [ ] Allow multiple products
* [ ] Handle multiple quantities
* [ ] Handle repeated products

Example:

```text
Cart

Product ID     Quantity
-----------------------
101               2
103               1
105               3
```

---

# Phase 5 — Checkout Calculations

Calculate the customer's total.

* [ ] Calculate product subtotal
* [ ] Calculate total purchase
* [ ] Display each subtotal
* [ ] Display final total
* [ ] Test one product
* [ ] Test multiple products
* [ ] Test different quantities

Example:

```text
Milk       ₱80 × 2 = ₱160
Bread      ₱50 × 1 = ₱50
-------------------------
TOTAL             ₱210
```

### Concepts

* Arithmetic
* Loops
* Variables
* Methods

---

# Phase 6 — Payment & Change

Implement payment processing.

* [ ] Display total
* [ ] Ask for payment
* [ ] Check whether payment is sufficient
* [ ] Reject insufficient payment
* [ ] Calculate change
* [ ] Display change
* [ ] Test exact payment
* [ ] Test excess payment
* [ ] Test insufficient payment

---

# Phase 7 — Receipt

Display a complete receipt in the terminal.

The receipt should contain:

* [ ] Store name
* [ ] Transaction number
* [ ] Product names
* [ ] Quantities
* [ ] Prices
* [ ] Subtotals
* [ ] Total
* [ ] Payment
* [ ] Change
* [ ] Thank-you message

Example:

```text
================================
        SUPERMARKET POS
================================

Product       Qty     Price
--------------------------------
Milk           2      ₱160.00
Bread          1       ₱50.00
--------------------------------
TOTAL                 ₱210.00

Payment               ₱500.00
Change                ₱290.00

================================
          THANK YOU!
================================
```

---

# Phase 8 — Inventory Management

Connect purchases to inventory.

* [ ] Reduce product stock after a successful purchase
* [ ] Prevent purchasing more than available stock
* [ ] Detect out-of-stock products
* [ ] Display updated inventory
* [ ] Ensure failed purchases don't modify stock incorrectly
* [ ] Test purchasing the last available item

---

# Phase 9 — Multiple Transactions

Allow the cashier to serve multiple customers.

```text
Customer 1
    ↓
Shopping Cart
    ↓
Checkout
    ↓
Receipt
    ↓
Reset Cart
    ↓
Customer 2
    ↓
...
```

* [ ] Complete a transaction
* [ ] Reset the cart
* [ ] Start another transaction
* [ ] Preserve inventory changes
* [ ] Generate transaction numbers
* [ ] Allow the cashier to exit
* [ ] Make sure previous cart data is cleared

---

# Phase 10 — Input Validation

Make the program handle invalid input.

* [ ] Invalid menu choice
* [ ] Invalid product ID
* [ ] Invalid quantity
* [ ] Negative quantity
* [ ] Zero quantity
* [ ] Quantity greater than stock
* [ ] Out-of-stock product
* [ ] Insufficient payment
* [ ] Invalid numeric input
* [ ] Empty cart checkout

### Concepts

* `if / else`
* Loops
* Input validation
* Basic exception handling

---

# Phase 11 — Methods & Organization

Since the project uses only one class, methods will be important for keeping the program organized.

Identify repeated operations and turn them into methods.

Possible responsibilities:

* [ ] Display menu
* [ ] Display products
* [ ] Search for a product
* [ ] Add product to cart
* [ ] Display cart
* [ ] Calculate subtotal
* [ ] Calculate total
* [ ] Process payment
* [ ] Print receipt
* [ ] Update inventory
* [ ] Reset cart

### Goal

Keep `main()` from becoming one giant block of code.

The program should still have **one class**, but different tasks should be separated into methods.

---

# Phase 12 — Testing & Debugging

## Normal Cases

* [ ] Buy one product
* [ ] Buy multiple products
* [ ] Buy multiple quantities
* [ ] Pay exact amount
* [ ] Pay more than total
* [ ] Complete multiple transactions

## Edge Cases

* [ ] Product doesn't exist
* [ ] Product has zero stock
* [ ] Quantity is zero
* [ ] Quantity is negative
* [ ] Quantity exceeds stock
* [ ] Payment is insufficient
* [ ] Invalid menu input
* [ ] Invalid number input
* [ ] Empty cart checkout

## Debugging

* [ ] Find logical errors
* [ ] Fix logical errors
* [ ] Find runtime errors
* [ ] Fix runtime errors
* [ ] Test every major feature
* [ ] Verify inventory calculations
* [ ] Verify total calculations
* [ ] Verify change calculations
* [ ] Verify cart reset

---

# Phase 13 — Optional Improvements

Only work on these **after the basic POS is complete**.

## Beginner+

* [ ] Product search
* [ ] Product categories
* [ ] Discounts
* [ ] Tax calculation
* [ ] Low-stock warnings
* [ ] Remove item from cart
* [ ] Change item quantity

## Intermediate

* [ ] Transaction history
* [ ] Daily sales total
* [ ] Multiple payment methods
* [ ] Better receipt formatting
* [ ] Product management menu

These should still follow the **single-class restriction**.

---

# 🧠 Java Concepts Practiced

By completing this project, I should understand:

* [ ] Variables
* [ ] Data types
* [ ] Strings
* [ ] Arithmetic operators
* [ ] `Scanner`
* [ ] `System.out`
* [ ] `if / else`
* [ ] `switch`
* [ ] `for`
* [ ] `while`
* [ ] `do-while`
* [ ] Methods
* [ ] Arrays
* [ ] `ArrayList`
* [ ] Searching through arrays/lists
* [ ] Input validation
* [ ] Basic exception handling
* [ ] Program flow
* [ ] State management
* [ ] Debugging

---

# 🏁 Definition of Done

The project is complete when a cashier can:

```text
View Products
      ↓
Select Products
      ↓
Enter Quantities
      ↓
Add to Cart
      ↓
View Cart
      ↓
Calculate Total
      ↓
Accept Payment
      ↓
Calculate Change
      ↓
Print Receipt
      ↓
Update Inventory
      ↓
Reset Cart
      ↓
Serve Another Customer
```

The program must be able to perform all of this using:

**ONE Java class + basic Java fundamentals.**

---

# 📈 Skill Progression

```text
Variables
    ↓
Input / Output
    ↓
if / else
    ↓
switch
    ↓
Loops
    ↓
Methods
    ↓
Arrays
    ↓
ArrayList
    ↓
Searching
    ↓
Data Management
    ↓
Input Validation
    ↓
Debugging
    ↓
Complete Java Application
```

---

# ⚠️ Project Rules

1. **One Java class only.**
2. No OOP.
3. No advanced Java features.
4. Build the system yourself.
5. Do not copy complete solutions.
6. Understand every feature before moving forward.
7. Use methods to organize the single class.
8. Test each phase before continuing.
9. Fix the basic system before adding optional features.
10. Prioritize understanding over complexity.

> **Build first. Improve later.**
>
> The purpose of this project is to strengthen Java fundamentals by building a working application from scratch—not to create the most advanced POS system possible.
