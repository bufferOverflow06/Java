## JSON and XML

- Data types and Structured Data
    - Integer numbers
    - Decimal numbers
    - Text
    - True/false
    - Dates
    - Custom types

- Json has three types
    - Number
    - String - enclosed with quotation
    - Boolean - true or false

- XML has one type
    - String

- Collections
    - groups of data
        - Arrays(lists)
        - Dictionaries(look up tables)
    - We can have
        - Dictionaries of lists
        - Lists of Dictionaries
        - Dictionaries of Dictionaries
    - We end up with a tree structure where each collection is a branch and at the end of each branch is a data value

- JSON info
    - what is json?
        - javascript object notation
        - most popular way of sending data for Web APIs
    - Basic types
        - Strings
        - Numbers
            - Integer or decimal, positive or negative
        - Booleans
            - true or false
            - no quotation marks
        - null
            - means "nothing"
            - no quotation marks
    - Arrays
        - Arrays are lists
        - enclosed in square brackets[]
        - comma separated
        - can mix data types
    - Objects
        - Objects are JSON's dictionaries
        - they are enclosed in curly brackets{}
        - keys and values are separated by a colon
        - pairs are separated by commas
        - keys and values can be any data type
    - Nesting
        - nesting involves putting arrays and objects inside each other
        - can put arrays inside objects, objects inside arrays, arrays inside arrays, etc
        - often a JSON file is one big object with lots of objects and arrays inside
```json
<!-- example json -->
{
    "song":
    {
        "title": "Hey Jude",
        "artist": "The Beatles",
        "musicians":
        ["John Lennon", "Paul McCartney",
            "George Harrison", "Ringo Starr"]
    }
}

<!-- Describing a menu -->
{
    "menu": [
        { "header": "File",
            "items": [
                { "id": "Open", "label": "Open" },
                { "id": "New", "label": "New" },
                { "id": "Close", "label": "Close" },
            ]},
        { "header": "View",
            "items":[
                { "id": "ZoomIn", "label": "Zoom In" },
                { "id": "ZoomOut", "label": "Zoom Out" },
                { "id": "OriginalView", "label": "Original View" },
            ]}
    ]
}
```
- Indentation
    - "white space" means spaces, new lines etc
    - white space doesn't matter
         - unless it's inside quotation marks
    - Good JSON formatting
        - In general, add an indent for every new level of brackets
        - end lines with commas
        - lots of exception to this
        - use JSON formatting tools
