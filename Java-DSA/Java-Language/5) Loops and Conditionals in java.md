# Loops and Conditionals in Java

## Conditionals

### `if`, `if-else`, and `else-if` ladder
If the condition is `true`, the `if` block runs. Otherwise the next condition is checked, and `else` runs if none match. Only the first matching block executes.

```java
int score = 78;

if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 75) {
    System.out.println("Grade: B"); // Executes this block
} else {
    System.out.println("Grade: C");
}
```

### Ternary operator `?:`
A short form of if-else that returns a value.

**Syntax:** `condition ? valueIfTrue : valueIfFalse`

```java
int num = 10;
String parity = (num % 2 == 0) ? "Even" : "Odd";
System.out.println(parity); // Even
```

### `switch` statement (classic)
Compares one variable (`byte`, `short`, `char`, `int`, `String`, or `enum`) against multiple constant `case` labels. Without `break`, execution **falls through** into the next cases.

```java
int day = 2;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday"); // Executes and exits switch
        break;
    default:
        System.out.println("Other day");
}
```

## Loops

| Loop | Type | Use when |
|------|------|----------|
| `for` | Entry-controlled | Number of iterations is known |
| `while` | Entry-controlled | Number of iterations is unknown |
| `do-while` | Exit-controlled | Body must run at least once |

### `for` loop
Syntax: `for (initialization; condition; update)`

```java
for (int i = 1; i <= 3; i++) {
    System.out.println("Count: " + i); // 1, 2, 3
}
```

### `while` loop
Checks the condition **before** each iteration, so the body may never run.

```java
int battery = 3;

while (battery > 0) {
    System.out.println("Running... Battery at " + battery);
    battery--;
}
```

### `do-while` loop
Checks the condition **after** the body, so it always runs at least once. Note the `;` after `while (...)`.

```java
int x = 5;

do {
    System.out.println("Executed once even though condition is false");
    x++;
} while (x < 5);
```

## `break` and `continue`

| Keyword | Effect |
|---------|--------|
| `break` | Exits the loop (or switch) immediately |
| `continue` | Skips the rest of the current iteration and moves to the next |

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) break;      // Stops loop when i hits 3
    System.out.println(i);  // 1, 2
}
```

```java
for (int i = 1; i <= 4; i++) {
    if (i == 2) continue;   // Skips 2
    System.out.println(i);  // 1, 3, 4
}
```