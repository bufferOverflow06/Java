## REST API

- Basics
    - State:
        - The current resource properties
        - Result of an action on the resource
        - Server sends the resource with some kind of representation
        - response represents the state in some way usually json

        - request usually looks like
             - `GET /api/order/17`
        - response looks like
            - `200 OK, JSON`

- Structure of REST API request
    - Method -> HTTP Verp (GET, POST, PUT, DELETE...)
    - URL -> Location of the resource + parameters
    - Headers -> Meta-data of the request (User Agent...)
    - Body -> Contents of the request (optional)

- Structure of REST API Response
    - Status Code -> 200(Success), 404(Not Found), etc...
    - Headers -> Meta-data of the response(Content Type...)
    - Body -> Contents of the response(optional)

- [HTTP Verbs](./HTTP_Verbs.md)

