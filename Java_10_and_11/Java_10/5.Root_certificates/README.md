## Root certificates

### Why introduce this feature?
- JDK was created in close collaboration with OpenJDK.
- The goal of this feature is to open-source the root certificates in Oracle Java SE, making OpenJDK builds more appealing to devs
- This feature also continues to reduce the difference between JDK and OpenJDK builds

### Cacerts: How does this work?
- Cacerts TrustStore file found in `${JAVA_HOME}/lib/security`
- This is where Java stores public certificates of root CAs
- Java uses cacerts to authenticate servers.


### How Does this work?
- Before, OpenJDK left the cacerts file empty
- In Java 10, the cacerts KeyStore will have certificates from the Oracle JDK issued by the Java SE Root CA program.

### Prerequisites for Certificates
- Each certificate must sign the Oracle Contributor Agreement(OCA) to grant Oracle the right to open-source their certificates
- Each certificate authority must confirm that they don't mind open-sourcing these certificates in OpenJDK repositories even if those certificates are already public.


### Goals
- Reduce the difference between OpenJDK and JDK builds
- Continue to make OpenJDK builds more appealing to developers.
- Making critical security pieces like TLS work by default in OpenJDK builds.
