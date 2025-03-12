## Java-Based Configs

- `ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class)`
- The `ConfigClass` should have the annotation:
    - `@Configuration`
- In Java-based configuration, we have to manually create objects in the Config class:
    - `@Bean` annotation for Spring to create the object.
    - Even though we are creating the object using `new`, the actual creation, managing, and injecting are done by Spring.

## Bean Name
- The bean name is actually the method name mentioned in the config class.
- We can specify our own name for the bean in the annotation itself:
  `@Bean(name="newName")`
- The name can then be used in the `getBean()` method:
    - `Object obj = context.getBean("newName", ConfigClassName.class)`
- We can also use multiple names:
  `@Bean(name={"name1", "name2", "name3"})`
    - Any of these names can be used in the `getBean` method.

## Scope Annotation
- `@Scope`
- By default, the value will be `singleton`.
- We can change it by using `@Scope("prototype")`.

## Autowire
- We can specify dependencies by passing the object as a parameter while creating the bean in the config class.
- In previous versions, `@Autowired` was used explicitly.

## Primary and Qualifier
- We can use the `@Qualifier("methodName")` annotation to specify the object to refer to.
- If we do not want to specify a qualifier, we can make a method primary using the `@Primary` annotation.

## Component Stereotype Annotation
- `@Component` is a stereotype annotation that tells the Spring framework to manage object creation.
- Any class that should be automatically managed by Spring must be annotated with `@Component`.
- After adding `@Component`, we don’t need `@Bean` methods—Spring will handle object creation automatically.
- We can also use `@ComponentScan("package name")` to specify package scanning.

## Autowired Field, Constructor, and Setter
- If Spring is unable to create objects for a specified field, we can use `@Autowired` with `@Qualifier` to explicitly specify which object to create.
- We can also specify a name in `@Component("name")`, which can be referenced in `@Qualifier`.

### Types of Dependency Injection:
1. **Field Injection** → `@Autowired` above a field.
2. **Constructor Injection** → `@Autowired` above a constructor.
3. **Setter Injection** → `@Autowired` above a setter.
    - If not using field injection, it is recommended to use `@Autowired` with setters.

## Primary Annotation
- We can mention any one of the class as `@Primary` then this class will be used by the spring to create an object if there is confusion
- If we mention both `@Qualifier` as well as `@Primary` then the first preference will be given to `@Qualifier` one.

## Scope and Values
-  We can inject values by using `@Value` annotation
-  Advantage of using this is that we can use a separate properties file to inject the values.
