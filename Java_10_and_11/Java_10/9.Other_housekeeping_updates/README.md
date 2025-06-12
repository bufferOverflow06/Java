## Other housekeeping updates

### Consolidate the JDK Forest
- Combined numerous repositories of the JDK forest into single repository
- Simplified and streamlined development

### Remove javah, the native-header generation tool
- Lived in `${JAVA_HOME}/bin`
- Functionlality supported by javac since Java 8, removing redundancy.

### Additional Unicode language-tag extensions
- Enhanced `java.util.Locale` and related APIs
- Made it possible to implement additional Unicode extensions of language syntax

### Language Tags
- Example: en-US, ja-JP
- The fist subtag is the language; the second subtag is the region
- A language tag can contain more subtags, including an `extension subtag`, which attaches additional information to a language tag.

### New Language Tag Extensions
- Currency type(cu)
- First Day of the week(fw)
* Region override(rg)
* Time zone(tz)
