---
layout: page
title: Contact
---
## Email 

For Jim's email, invoke this method:
```java
public static String email(String firstname, String lastname) {
    final char AT = '@';
    StringBuilder sb = new StringBuilder();
    sb.append(Character.toLowerCase(firstname.charAt(0)))
      .append('.')
      .append(lastname.toLowerCase())
      .append(AT).append("ku.th");
    return sb.toString();
}
//TODO Modify algorithm to work for Thai names, too.
```
When you need to join or modify Strings, 
a
<a href="https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html">
StringBuilder</a> (as above) is more efficient than using Strings.
Stringbuilder is mutable (the methods modify the StringBuilder object)
while Strings are immutable (every operation creates a new String). 
