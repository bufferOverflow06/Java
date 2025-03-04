## URL Structure


- Defines the structure of the API's URL
    - what data should it contain, and in which order
- The most important part of the API
- Should be:
    - Self explanatory
    - Consistent across the API
    - Predictable

1. The Domain Name
    - The first part of the URL
    - Usually contains FQDN(Fully Qualified Domain Name) or a server name
    - Protocol should be HTTPS
    - For FQDN - should have api in its name
    - ie. `https://api.myapp.com`

2. The API Word
    - If the domain does not include api, it comes now
    - ie. `https://www.myapp.com/api`
    - Emphasizes this URL is for the API, not the website
    - Can be part of the domain name itself, like this one
        - `https://language.googleapis.com/v1/documents:analyzeEntities`

3. Version
    - If the version strategy is URL - it comes now
    - Only natural number
        - Positive
        - No decimals
    - Could be prefixed with v
    - ie. `https://www.myapp.com/api/v1`

4. Entity
    - REST deals with resourcws, or entities
    - The next part is the entity we're dealing with
    - Should be one word, no more
    - NEVER a verb
        - This is the HTTP verb role
    - examples
        - `/api/v1/order`
        - `api/v2/employees`
        - `/api/v2/travel`

5. ID Parameter (optional part)
    - When dealing with a specific entity - next is the entity ID
    - The ID is part of the URL
    - `/api/v1/order/17`
    - ID Parameter relevant for
        - GET - to retrieve a specific entity
        - PUT - when we are updating an entity we must speficy which entity we want to update.
        - DELETE - when we need to delete a specific entity using the ID Paramenter in the URL.
    - Not POST - No ID for new identity

6. Sub Entity
    - Used for accessing entities that are dependent on other entities
    - example: Get all the items of order no. 17
    - Common mistake:
        - `/api/v1/ItemsInOrder/17`
    - Not readable
    - Not simple

    - Sub Entity should come after the ID parameter
        - `/api/v1/order/17/items`
    - URL is Hierarchical, easy to understand

    - Same goes for sub-sub-entity, etc

7, Query Parameters
    - Used to query the entites in GET method
    - Come at the end of the URL, after?
    - Concatenated with `&`
        - `/api/v1/orders?fromDate=12/12/2018&toDate=2/2/2019`

    - Query Parameters vs ID Parameters
|  | Query Parameters | ID Parameters |
| --------------- | --------------- | --------------- |
| Location | At the end of the URL| End or middle of URL |
| Param count | 0..N parameters | 1 parameter |
| Example | `/api/v1/orders?user=john` | `/api/v1/order/17` |
| Return Value | May return 0..N entities | `Must` return exactly 1 entity|
| If not found| Thats's fine | Error! |


- Singular vs Plural

    - The dilemma #1:
        - `/api/v1/order/17`
        - or
        - `/api/v1/orders/17`

    - The dilemma #2
        - `/api/v1/order?user=john`
        - or
        - `/api/v1/orders?user=john`

    - No concrete answer
    - Best practice: Always prefer readablity and ease of use
    - So when the api is returning only single entity use
        - `/api/v1/order/17` -> Returns single entity
        - `/api/v1/orders?user=john` -> Return 0...N entities
