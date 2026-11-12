# Methods in Java

## Why "methods" and not "functions"?

Java has no standalone functions. **Every function must live inside a class**, and a function that belongs to a class is called a **method**. `main` is a method for the same reason: it sits inside `HelloWorld`.

## Why use methods?
- Avoids code repetition (write once, call many times).
- Makes code easier to read and debug.
- The block runs **only when called**.

## Syntax

```java
returnType methodName(parameters) {
    // body
    return value; // skip if returnType is void
}
```

## Parameters vs Arguments

| Term | Where | Meaning |
|------|-------|---------|
| **Parameter** | In the method definition | Placeholder variable that receives a value |
| **Argument** | In the method call | The actual value passed in |

```java
static int add(int a, int b) { ... }   // a, b are parameters
add(5, 3);                              // 5, 3 are arguments
```

## Example: Add Two Numbers with User Input

```java
import java.util.Scanner;

public class AddNumbers {

    static int add(int a, int b) {   // a and b are parameters
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        int result = add(x, y);      // x and y are arguments
        System.out.println("Sum: " + result);

        sc.close();
    }
}
```

**Notes:**
- `static` is needed because `main` is static and can directly call only static methods.
- `Scanner` lives in `java.util`, so it needs an `import` (unlike `System` in `java.lang`).

---

## Method Overloading

Same method name, **different parameter list** (different number, type, or order of parameters). Java picks the right one based on the arguments. Changing only the return type is **not** overloading.

```java
public class Overload {

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 3));       // 5     -> add(int, int)
        System.out.println(add(2.5, 3.5));   // 6.0   -> add(double, double)
        System.out.println(add(1, 2, 3));    // 6     -> add(int, int, int)
    }
}
```

---

## Pass by Value (and the "pass by reference" myth)

### The two concepts

| Concept | What the method receives | Effect of changing the parameter |
|---------|--------------------------|----------------------------------|
| **Pass by value** | A **copy** of the argument's value | Original variable is never affected |
| **Pass by reference** | An **alias** of the original variable itself (same variable, two names) | Reassigning or modifying it changes the original variable |

Languages like C++ (with `&`) support true pass by reference. Java does **not**.

### Why Java is always pass by value

Java always copies whatever is in the variable and hands the copy to the method:
- For a **primitive**, the variable holds the actual value, so the value is copied.
- For an **object or array**, the variable holds a **reference (address)**, so the address is copied.

In both cases it is a copy. The method never gets the original variable itself, so it can never reassign the caller's variable.

### Why `x` stays unchanged (primitive)

```java
static void change(int n) {
    n = 100;   // changes only the copy
}

public static void main(String[] args) {
    int x = 10;
    change(x);
    System.out.println(x);   // 10
}
```

Memory view:

```
main:    x = [10]
            |  value copied
            v
change:  n = [10]  ->  n = 100  ->  n = [100]

x is still [10]. n was a separate box.
```

`x` and `n` are two separate boxes. The value `10` was copied into `n`. Changing `n` has no connection to `x`.

### Why an array changes (reference copy)

```java
static void change(int[] arr) {
    arr[0] = 100;   // follows the address, modifies the real array
}

public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    change(nums);
    System.out.println(nums[0]);   // 100
}
```

Memory view:

```
Stack                    Heap
main:   nums = [addr1] ----+
                           +--> [1, 2, 3]  ->  [100, 2, 3]
change: arr  = [addr1] ----+
```

`nums` and `arr` are still two separate boxes, and `arr` holds a **copy of the address**. Both addresses point to the **same array** on the heap. `arr[0] = 100` follows the address and edits that shared array, so `nums` sees the change.

### Proof it is still pass by value: reassigning

```java
static void reassign(int[] arr) {
    arr = new int[]{9, 9, 9};   // copy now points to a new array
}

public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    reassign(nums);
    System.out.println(nums[0]);   // 1 (unchanged)
}
```

```
Stack                    Heap
main:   nums = [addr1] ------> [1, 2, 3]
change: arr  = [addr2] ------> [9, 9, 9]   (arr's copy now points elsewhere)
```

With true pass by reference, `arr = new ...` would have changed `nums` too. It doesn't, because `arr` is only a copy of the address.

### Summary

> Java copies the variable's contents. For primitives that is the value; for objects that is the address. **Changing the object through the address is visible to the caller. Changing the copy itself is not.**
---

## Recursion

A method that **calls itself**. Every recursive method needs:
1. **Base case**: when to stop (otherwise `StackOverflowError`).
2. **Recursive case**: calls itself with a smaller problem.

### Example: Factorial

```java
public class Recursion {

    static int factorial(int n) {
        if (n == 0 || n == 1) {      // base case
            return 1;
        }
        return n * factorial(n - 1); // recursive case
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));   // 120
    }
}
```

**How it unwinds:**
```
factorial(5) = 5 * factorial(4)
             = 5 * 4 * factorial(3)
             = 5 * 4 * 3 * factorial(2)
             = 5 * 4 * 3 * 2 * factorial(1)
             = 5 * 4 * 3 * 2 * 1 = 120
```