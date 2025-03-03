## Documenting JSON

- Description and Tables

- JSON response

| Element | Description | Type | Notes |
| --------------- | --------------- | --------------- | --------------- |
| Item1.1 | Item2.1 | Item3.1 | Item4.1 |

- Element: The key of the key/value pair
- Description: A sentence fragment, usually a descriptive noun
- Type: number, string, boolean, array(what kind of array) or object(what kind of object)
- Notes: additonal information

- JSON Requests

| Element | Description | Type | Required/Optional | Notes |
| --------------- | --------------- | --------------- | --------------- | --------------- |
| Item1.1 | Item2.1 | Item3.1 | Item4.1 | Item5.1 |

- Same as response table, but
- add a column called required
    - Indicates whether you have to have that element
    - Fill with either "Required" or "Optional"
    - Include default value in Notes

- What goes in Notes
    - Default values
    - If values are limited
        - examples
            - Can have these values: "teacher", "student", "admin"
            - Must be between 10 and 100.
    - Formatting
        - examples
            - Date is YYYY-MM-DD
            - URL
