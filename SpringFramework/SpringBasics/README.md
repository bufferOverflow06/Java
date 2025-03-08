## Spring Basics

- We can create objects by using following methods
1. using xml configuration
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
    - The number of beans mentioned those many objects will be created
    - If we mention two different beans for the same class it will create two different objects
    - If we call the reference two times then the object will be created only once for a class
        - that means even if there are two different references they are the same objects

- Scopes of beans
    - Singleton
    - Prototype
        - If we mention `scope="prototype"` it will create new object every time we do `getBean()`
    - Request
    - Session

    - Singleton and Prototype is used in spring core
    - Request and session works for web or web sockets


```java
// in the java code we have to mention this
// This line directly creates the object
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
// we are getting the reference using context
obj = context.getBean("idName"); // this creates the object
```
2. using java based configuration
3. annotations

- Setter Injection
    - we are using setter method to assign the value
    - `<property name="variableName" value=""></property>` in xml file
    - for primitive types value works fine


