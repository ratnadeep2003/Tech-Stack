# Java Type Conversion and Type Casting Guide

Understanding how Java handles data types is essential for writing clean and bug-free code. Two core concepts govern how variables interact: **Type Conversion** and **Type Casting**.

---

### 1) Clearing Up LHS vs. RHS (Range vs. Literal Value)

A common confusion when assigning values between different data types is mixing up the *numerical value* itself (e.g., the number $5$ versus $100$) with the **data type capacity (range)**. 

It is not about the literal value you are storing, but rather the **size and range of the data type**:
* **Why an `int` fits inside a `float` automatically:** Both take up $4$ bytes of memory, but a `float` uses a representation that spans a vastly larger range and handles decimals. It has enough room to accommodate whole numbers without losing information.
* **Why a `float` cannot be stored inside an `int` automatically:** A `float` holds decimals and large ranges. An `int` holds *only* whole numbers. If Java allowed this without instruction, you would lose data (the decimal fractional part would be chopped off).

---

### 2) Type Conversion (Implicit / Widening)

**Type Conversion** happens automatically when you assign a "smaller" data type into a "larger" data type where there is **no risk of losing data**.

**Widening Order:** 
$\text{byte} \rightarrow \text{short} \rightarrow \text{int} \rightarrow \text{long} \rightarrow \text{float} \rightarrow \text{double}$

### Example of Type Conversion:
```java
int myInt = 100;
float myFloat = myInt; // Automatic conversion (Widening)
System.out.println(myFloat); // Output: 100.0
```

---

### 3) Type Casting (Explicit / Narrowing)

**Type Casting** happens when you force a "larger" data type into a "smaller" data type. Because this can cause data loss (such as truncating decimals), Java requires explicit instructions using parentheses `(targetType)`.

### Example of Type Casting:
```java
float myFloat = 67.54f;
int myInt = (int) myFloat; // Explicit casting (Narrowing)
System.out.println(myInt); // Output: 67 (The .54 decimal part is dropped!)
```

### 4) [Visit the full code](code/Inputs/Inputs.java)