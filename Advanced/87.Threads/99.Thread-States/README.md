## Thread States

- Every time we create a thread it goes into a `New` state
- `Runnable`
    - when we do `start()` it goes to `Runnable()` state
    - `stop()` will put to dead state
- `Running`
    - when the thread is actually running in CPU
    - `run()` method
    - `stop()` will take put to dead state
- `Waiting/Block`
    - `sleep()` method makes the thread go to waiting state
    - `wait()`
    - `notify()` will take the thread back to `Runnable()` state
- `Dead`
