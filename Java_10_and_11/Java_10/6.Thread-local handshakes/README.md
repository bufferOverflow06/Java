## Thread-local handshakes

### JVM safepoints
- A JVM safepoint suspends all Java threads
- This is necessary to make sure that we only have access to data structures in the JVM to safely work with them.
- Used for garbage collection, code de-optimization, biased lock revocation, etc.

### Goal
- Reduce number of global safepoints

- This feature introduces a way to execute a callback on threads without performing a global VM safepoint.
- This makes it possible and cheap to stop individual threads, laying the groundwork for improved VM performance.

- What bout handshakes? Well, the callback is the handshake.
