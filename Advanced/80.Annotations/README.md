## Annotations

- means suppliment to the compiler or the runtime, or the meta data
- Class level annotations and method level annotations
    - `Method level`
        - `@Override` (method level)
         - ensures that the method that we override is present in the base class
    - `Class level`
        - `@Deprecated`(class level)
            - shows that a class will be no longer used in future.
    - Custom annotaions
        - `@Retention`
            - till what level do you want to set the annotations, that is till compiler level or runtime level.
            - if compiler level then once after the code is compiled the annotations does not make any sense after that.
            - if runtime level then the annotaions is applicable during the runtime as well.

