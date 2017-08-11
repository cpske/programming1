## Email 

For my email, invoke this method with my name:
```java
// Email for Java programmers :-)
public static String email(String first, String last) {
    final char AT = '@';
    StringBuilder sb = new StringBuilder();
    sb.append(Character.toLowerCase(first.charAt(0)))
      .append('.')
      .append(last.toLowerCase())
      .append(AT).append("ku.th");
    return sb.toString();
}
```
When you need to join or modify many Strings, its much more efficient to use a 
<a href="https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html">
StringBuilder</a> (as above), instead of Strings.
Stringbuilder is mutable while Strings are immutable, which means every String
operation creates a new String! (most of which are discarded)

