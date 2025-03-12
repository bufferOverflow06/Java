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
    - We can mention what is dependant on by passing the Object as parameter to the method while creating the bean in config class
    - In before version used to use `Autowired` keyword

## Primary and Qualifier
    - We can use the `@Qualifier("methodName")` to mention the name of the object that we want to refer to.
    - If we do not wish to mention this we can make the methodName primary using the `@Primary` annotation above the method that we want to create the object of.

## Component sterotype annotation
    - `@Component` is a sterotype annotation which helps the spring framework to understand that The below class must be managed by `spring` to create objects for it.
    - whichever class we want the spring to automatically create the objects we have to mention this annotation
    - After mentioning this we don't have to create separate methods for with `@Bean` to create the objects spring will manage it automatically by one more annotation called
        - `@ComponentScan("package name")` with the attributes
        - the attributes includes the package name or the model folder which included all the models



