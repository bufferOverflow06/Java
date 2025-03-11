## Java Based configs

- `ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class)`
- the `ConfigClass` should have the annotation
    - `@Configuration`
- In java based configuration we have to manually create objects in the Config class
    - `@Bean` annotation for spring to create the object
    - even though we are creating the object using `new`, the actual creating, managing and injecting is done by spring

## Bean name
    - Bean name is actually the method name mentioned in the config class
    - we can specify our name for the bean name in the annotation itself `@Bean(name="newName")`
    - and the name can be used in the `getBean()` method
        - `Object obj = context.getBean("newName", cofigClassname.class)`
    - we can also use multiple names as `@Bean(name={"name1", "name2", "name3"})`
        - we can use any of the one name in the getBean method

## Scope Annotation
    - `@Scope`
    - by default the value will `singleton`
    - we can change the value by using `@Scope("prototype")`

## Autowire



