## Spring Basics

1. We can create objects by using following methods
- using xml configuration
    - make sure to put the file in resources and path should be classPath
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
<!--    if we have one more class we can mention it here-->
<bean id="idName" class="fullclassPath"></bean>
</beans>
```

```java
// in the java code we have to mention this
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
obj = context.getBean("idName"); // this creates the object
```
- using java based configuration
- annotations
