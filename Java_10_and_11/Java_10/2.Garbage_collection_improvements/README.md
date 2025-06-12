## Garbage collector Interface

- Increases the code isolation of different garbage collectors
- Makes it easier to exclude a garbage collector from a JDK build
- Makes it easier to add a new garbage collector without affecting the code base

### What does this mean?
- Previously, GC(garbage collector) source fiels were scattered over HotSpto sources
- made implementing a new GC difficult
- goal new GC -> modularity

### Garbage Collection
- Java 9 made the G1(Garbage-First) garbage collector the default garbage collector for the JVM, desigend to avoid full garbage collection.
- The fallback was the full GC(full garbage collector)

- In java 10 makes the full garbage collector parallel
- Latencies are lessened
- In other words, when we have to do our deep clean, it's now more efficient because we have more people(threads) to help us.
- Use this feature with `-XX:ParallelGCThreads` option
