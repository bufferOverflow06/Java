### CDS: Class Data Sharing
- is about java class files
- it allows for a set of classes to be pre-processed into a shared archive file


### Why is CDS Good?
- Each time the JVM loads a class it must do a bunch of work
- Certain classes are included in Java by default
- Creating a shared archive with these pre-processed classes reduces `startup time` and `memory footprint` if multiple JVMs share the same archive file.

### Application Class Data Sharing
- Class data sharing was introduced in Java 5
- Only the bootstrap class loader can load archived classes with CDS
- `Application CDS(AppCDS)` allows other class loaders, including the built-in system class loader and the built-in platform class loader, to load archived classes.

### Why AppCDS Matters
- Many enterprise applications load tens of thousands of classes
- AppCDS results in `significant memory savings`
- Serverless cloud services also load several thousand application classes at startup, and AppCDS can `improve startup time` and `improve overall system response time`

### What CDS Cannot Do
- In this release, CDS cannot archive classes from user-defined modules
- This may be suppored in future releases.
