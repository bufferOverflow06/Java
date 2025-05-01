```
To avoid sending passwords in your API response:

Use a DTO (Data Transfer Object) to control what fields are returned.

Or use @JsonIgnore on User.password if you're not ready for DTOs yet:

@JsonIgnore
private String password;
```
