## Spring Boot Web

- Web archives
- embedded tomcat and external tomcat

- Servlet
    - Java class used to handle http requests

- before used to map the url using the `web.xml` file

- When using external tomcat `@WebServlet("/path")` annotation works
- for embedded tomcat configuration is needed

- `doGet` and `doPost`

## MVC (Model View Controller)

- Adding HTML codes inside java
- multiple view technologies
- having an entire HTML code and putting java code in between is possible through `JSP (Jakarta Server Pages), formerly, JavaServer Pages`

- Servlet is responsible to accept the request from the client
- JSP is responsible to create the web pages
- Data is the object
    - the object in which we have the data is called Model
- data will move from the model object to the controller after processing will be accessed by the view and then displayed to the clients

- When we are using Controller we will be using Servlet
- When we are using View we will be using JSP
- When we are using Model we will be using Simple java class POJO(Plain old java object)

- Inside main directory create a folder named `webapp` and create a file named `index.jsp` which will be searched by the spring

- `@RequestMapping` -> to map the url path
    - we have many methods
- By default spring boot does not support jsp, we have to convert jsp into servlet
    - by adding a dependency `Tomcat Jasper`

- `Dispatcher servlet`
    - mapping required things

- `Session`
    - sending data to different jsp file
    - we can put the data in the session object

    - `HttpSession session`
        - `session.setAttribute("name", value)`

- to write java code in jsp we use `<% %>`
    - for value `<%=  %>`
- while accepting the session variable using `getAttribute()` method the jsp provides the session object by default no need to inject it

- Using JSTL we can directly access the variables as `${variable_name}`

- If the variables in the form match then we directly use them as parameters, without using `HttpServeletRequest req` object
- We can use `@RequestParam("name")` annotation to get the value from the `url`

- to transfer values between `controller` and the `jsp` we can use `Model` interface
- `Model model` -> `model.addAttribute("name", value);`

- `Prefix` -> view folder
- `Suffix` -> `.jsp`

- ModelAndView object to transfer the values

- `ModelAttribute` if there are multiple attributes we can use this also specifying this is also optional.
