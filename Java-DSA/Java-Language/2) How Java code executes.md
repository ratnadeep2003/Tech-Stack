# Java: How Code Runs

## Compilation & Execution

- `.java` file: human-readable source code.
- The compiler (`javac`) converts it into a `.class` file (**bytecode**).
- Bytecode does not run directly on the OS. The **JVM** is required to run it, which makes Java **platform independent**.
- The JVM interprets bytecode into machine code (0s and 1s), line by line.

**Platform independence:** bytecode runs on any OS that has a JVM. Machines only understand 0s and 1s, so the JVM translates for each one.

## JDK vs JRE vs JVM vs JIT

```
┌──────────────────────────────────────────────┐
│ JDK  (Development Kit)                       │
│   javac, debugger, dev tools                 │
│  ┌────────────────────────────────────────┐  │
│  │ JRE  (Runtime Environment)             │  │
│  │   core libraries (System.out, etc.)    │  │
│  │  ┌──────────────────────────────────┐  │  │
│  │  │ JVM  (Virtual Machine)           │  │  │
│  │  │   class loader + interpreter     │  │  │
│  │  │  ┌────────────────────────────┐  │  │  │
│  │  │  │ JIT  (Just-In-Time)        │  │  │  │
│  │  │  └────────────────────────────┘  │  │  │
│  │  └──────────────────────────────────┘  │  │
│  └────────────────────────────────────────┘  │
└──────────────────────────────────────────────┘
```

| Component | Role | Analogy |
|-----------|------|---------|
| **JDK** | Write and compile code (`javac` gives `.class`) | Workshop |
| **JRE** | Run code: JVM + core libraries | Engine room |
| **JVM** | Loads `.class`, converts bytecode to machine code line by line | Interpreter |
| **JIT** | Part of the JVM. Compiles frequently repeated (hot) methods straight to machine code for speed | Shortcut |

> Once compiled, only the JRE is needed to run the program.

## HelloWorld Flow

```mermaid
flowchart TD
    A["1. Write HelloWorld.java<br/>(source code)"] --> B["2. javac (JDK) compiles it"]
    B --> C["3. HelloWorld.class<br/>(bytecode)"]
    C --> D["4. JRE starts the JVM<br/>and loads the .class file"]
    D --> E["5. JVM interprets bytecode<br/>line by line"]
    E --> F{"Method called<br/>repeatedly?"}
    F -- Yes --> G["6a. JIT compiles it to<br/>machine code (faster)"]
    F -- No --> H["6b. Keep interpreting"]
    G --> I["7. CPU executes machine code<br/>(0s and 1s)"]
    H --> I
    I --> J["8. Output: Hello, World!"]
```