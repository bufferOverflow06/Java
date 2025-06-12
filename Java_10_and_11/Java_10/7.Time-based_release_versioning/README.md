## Time-Based Release versioning

### New Release Cadence
- New release every six months
- Long-term support release every three years.

### Version Counter

- `$FEATURE, $INTERIM, $UPDATE, $PATCH`


### Feature-Release Counter
- Incremented for every feature release
- Features could be added or removed; if removed, advanced notice is given
- `$FEATURE` used to be called `$MAJOR`

### Interim-Release Counter
- Incremented for non-feature releases
- Non-feature releases may contain compatible bug fixes and enhancements, but no incompatible changes, no feature removals, and no changes to the standard APIs
- `$INTERIM` used to be called `$MINOR`

### Update-Release Counter
- Incremented for compatible update releases
- The releases fix security issues, regression, and bugs in newer features
- `$UPDATE` used to be called `$SECURITY`

### Emergency Patch-Release Counter
- Incremented only when it's necessary to produce an Emergency release to fix a critical issue.
- This additional element minimizes disruption to both devs and users of in-flight update releases
- Later elements are reserved for use by downstream consumers of the JDK code base

### How does this work?
- `Feature`: JDK 10(March 2018), JDK 11(September 2018)
- `Interim`: always zero, but reserved for possible revisions to release model
- `Update`: JDK 10.0.1(April 2018), JDK 10.0.2(July 2018)

### Other Enhancements
- The **Runtime.Version API** was updated with two new system properties, `java.version.date` and `java.vendor.version`
