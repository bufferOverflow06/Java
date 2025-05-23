## Spring Basics

#### We can create objects by using following methods
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

## Scopes of beans
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

## Setter Injection
    - we are using setter method to assign the value
    - `<property name="variableName" value=""></property>` in xml file
    - for primitive types value works fine

### `ref` Attribute
     - getters and setters must be there
     - `<property name="variableName" ref="idOfrefBean"></property>`
     - as we are daling with the object reference bean must exist.
     - We can have multiple references for the same class the `id` differentiates these.

## Constructor Injection
    - `<constructor-arg value="">`
    - for objects -> `<constructor-arg ref="beanID"/>`
    - when dealing with objects as parameters we have to provide referenes
    - if there are multiple parameters in the constructor the **sequence** will be considered and matched accordingly.
    - we can also use `index` attribute
        - `<constructor-arg index="0" value="">`
        - `<constructor-arg index="1" value="">`
    - we can direclty use the `variable name` but sequence matters
        - `<constructor-arg name="var1" value="">`
        - `<constructor-arg name="var2" value="">`
        - If we are not providing the constructor arguments in sequence then we can use
        - `@ConstructorProperties({"var1", "var2"})` annotation on top of the constructor being used.

## Autowire
    - if we don't want to mention the property explicitly if we want to ask spring framework to search for the dependancy based on name and type we can use
    - `autowire="byName"`
        - tries to match the object by name
    - if I have `autowire=byName` then if I explicitly provide
        - `<property name="name" ref="reference"` then this will be preferred over `Autowire`
    - `autowire="byType"`
        - tries to match the object by type

## Primary Bean
    - if there is a confusion say the objects created for the insterfaces in bean and `autowire` is specified then `primary=true` specifed bean will be choosen
    - if we are mentioning explicitly then it will prefer the specifed one

## Lazy init Bean
    - The Object will not be created by default only when we want to use it, it will be created.
    - still singleton
    - `lazy-init="true"`
    - if a non-lazy(eager) bean is dependent on a lazy bean still it will create the object of a lazy bean.

## Get bean by type
    - we can specify the class of which you want the object in the `getBean()` method
    - Don't have to do type caste for the required class
    - `<T> T getBean(String name, Class<T> requiredType)`
    - We can either specify name of the bean or the type of class the object we want
        - if we are specifing the class then in the bean tag there is no need for `id` vale

## Inner Bean
    - To limit a bean only for a particular class
```xml
<!-- example -->
<bean id="alien" class="com.example.Alien" autowire="byType">
    <property name="age" value="21"/>
    <property name="com">
        <bean id="com1" class="com.example.Laptop" primary="true">
        </bean>
    </property>
 </bean>
```
