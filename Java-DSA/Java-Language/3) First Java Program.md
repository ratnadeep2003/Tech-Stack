# First Java Program: Hello World

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
```

## Digging Through the Code

### 1) File name convention
- A `public` class must be in a file with the **exact same name**: `HelloWorld.java`. Otherwise the compiler throws an error.
- This lets Java find a class by name alone, instead of scanning every file in the project.
- It also means one public class per file.

### 2) `String[] args`
- Holds the **command line arguments** passed when running the program.
- Accessed as an array: `args[0]`, `args[1]`, ...

```bash
java HelloWorld Job Pune
```
```java
System.out.println(args[0]); // Job
```

### 3) Two different `public`s

| Where | Meaning |
|-------|---------|
| `public class HelloWorld` | The class is visible to other classes and packages |
| `public static void main` | The method is visible to the **JVM** (an outside caller) |

- Access modifiers apply **per member**, so a public class doesn't make its methods public automatically.
- Without `public` on `main`, the JVM can't access it and can't start the program.

### 4) `main` signature, word by word

| Keyword | Why |
|---------|-----|
| `public` | JVM must be able to access it |
| `static` | JVM calls it without creating an object of the class |
| `void` | It returns nothing to the JVM |
| `main` | The fixed name the JVM looks for as the entry point |
| `String[] args` | Command line arguments |

### 5) `System.out.println("Hello world");`
- `System`: a class in `java.lang` (auto-imported, no `import` needed).
- `out`: a static `PrintStream` object inside `System`.
- `println()`: a method of `PrintStream` that prints text and moves to a new line.

### 6) Compile and run

```bash
javac HelloWorld.java   # creates HelloWorld.class (bytecode) in the same directory
java HelloWorld         # JVM runs it (no .class extension)
```

Output:
```
Hello world
```

### 7) [Visit the full code](code/First%20Java%20Program/HelloWorld.java)