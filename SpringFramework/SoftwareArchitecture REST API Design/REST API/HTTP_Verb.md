## HTTP Verbs

- Set the action to be performed
    - Retrieve a resource
    - Add a resource
    - Update a resource
    - Delete a resource

- Above have their own acronym CRUD(Create, Read, Update and Delete)

- Improves readablility
- Should be treated as part of the URL

1) The GET verb

    - Used to retrieve resource(s)
    - NEVER use it to add/update/delete resources
    - The defualt verb of the browser's address bar
    - Usually combined with parameters
    - Should not include body
        - Method -> HTTP Verb(GET)
        - Url -> Location of the resource + parameters
        - Headers -> Meta-data of the request(User Agent...)
    - only limited characters can be sent
    - 404 status code uri is loo large
    - Sometimes GET cannot be used for retrival
        - for example: Too manu parameters
    - In this case - use POST

2) The POST verb
    - Used to add resource
    - Should contain a message body that specifies the resource to be added
    - should not contain query string paraments
        - ie `POST /api/entity?company=15`

3) The PUT verb
    - Used to modify resource(s)
    - Should contain a message body that specifies the resource to be modified
    - Should not contain query string parameters
        - ie `PUT /api/entity?company=15`
    - What happens if the resource to modify does not exist?
        - The spec states a new resource should be created (PUT should behave just like POST)
        - Use your own discretion (like our own error messages)
        - PUT is idempotent
            - idempotent means if we have some kind of action or method, then no matter how many time we execute this method, the result will always be same.
        - with POST if we send the same data again then therw will be identical entity
        - with PUT we ensure that there is no redundant entities.

4) The DELETE verb
    - Used to delete resource(s)
    - NEVER use it to add/ update/ retrieve resources
    - Almost always combined with parameters
        - if we are trying to delete something we should tell the server which one
    - Should not include body

Rarely Used Verbs
    - PATCH - Similar to Put, but with partial updates
        - server will recieve speicific properties to be updated
    - HEAD - Same as GET, but without the body in the response
        - this verb can be used for a pre-check
        - for ex. if we want to know a specific entity exists then we can send a HEAD request.
        - If we recieve 200 Status code then the entity exists, even though we don't get it back
    - OPTIONS - Describes the available verbs for the URL
        - `curl -X OPTIONS http://example.org -i`
            - Resopnse for the above url
                - HTTP/1.1 204 No Content
                - Allow: OPTIONS, GET, HEAD, POST
        - way for clients to use which type of verb while accessing it.

### Summary
| Verb | Role | Body? | Params in.. |
| --------------- | --------------- | --------------- | --------------- |
| GET | Retrieve resource(s) | No | URL |
| POST | Add resource(s) | Yes | Body |
| PUT | Modify resource(s) | Yes | Body |
| DELETE | Delete resource(s) | No | URL |
