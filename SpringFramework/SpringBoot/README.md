## SpringBoot Basics

- can use the annotations without much configuration

## Different Layers

```
<!-- General view -->
Client <-> Server <-> Database
              |
Controller <-> Service <-> Repository
```

- Controller's job is to only work with the request and send data back
- Service is a layer which is responsible for processing data
- Service to get the data from database there should be a layer called `Data Access Object (DAO)` or `Repository` layer
    - Repository layer interacts with the database, get the data and give it to service.

- To manage objects by spring we should have `@Component` but if we are working with Service class we can use `@Service` stereotype annotation

- write jdbc code in a separate class called `Repository` class -> all the database connections
