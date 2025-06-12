## HotSpot VM

- Core component of the Java SE Platform: implements the JVM specification, accessible as a shared library.
- Provides runtime faciltites, including dynamic compilers.
- Manages the Java heap and provides data to debugging tools.

- The HotSpot VM is also `ergonomic`
- This means it selects a compiler, heap configuration, and garbage collector based upon platform configuration.
- Under special circumstances, tuning may be required to get optimal performance.

- In java 10, the `HotSpot VM` can now allocate the java object `heap` on an `alternative memory device` specified by the user.

### Why is this Good?

- `Non-volatile dual in-line memory(NV-DIMM)` is becomming cheaper
- This means future systems may have heterogenous architectures, which will have `dynamic random access memory(DRAM)` and non-DRAM memory.

- Alternative memory devices can be used instead for the object heap without change to the existing code.
