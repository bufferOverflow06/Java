## HotSpot JVM Just-in-time Compilers

- **C1**: fast, simple, less optimization, good for quick startup
- **C2**: slower, more optimization, good for long-running server apps
- **Graal**: one more JIT compiler

### Graal: An Experimental JIT Compiler
- Jit compiler writtern in Java to compile java bytecode
- The basis of an experimental ahead-of-time(AOT) compiler
- Graal was added in Java 9, but we can enable it with JVM-specific arguments.
`-XX:+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler`

### Goals
- Enabling this compiler will help Graal and HotSpot teams investigate the feasibilty of Java-based JIT compiler.
- Since it's in an experimental stage, you should not use it for production.
