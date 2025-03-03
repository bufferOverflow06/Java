## REST API Design

- Why REST API?
    - standard API
    - used by all major websites
    - Developers expect it
    - Supported by all platforms
    - Top skill
    - simple to implement

- API Basics
    - What is an API?
        - Application Programming Interface
        - A set of clearly defined methods of communication among various components.
        - Interfaces
            - User Interface
                - exposed to user
            - Application Interface
                -  interface that is exposed to a part of an application not an end user

    - API Types
        - Operating System API
            - File System
            - Network Devices
            - User Interface Elements
            - ex. Win32 API
        - Library API
            - ex. user library and logging library(logging API)
            - executed in the same single process
            - Class Library
                - .NET
                - Java
                - Python
                - node.js
        - Remote API
            - if two components are distributed over the network(not in the same process or not in the same server or virtual machine or PC)
            - ex. Users component and Orders Component
            - Users component uses Orders Proxy to communicate with the orders component
            - after building the access the orders proxy can access the orders component using proprietary protocol
            - It mandates that both the components must use the same developement platform like
                - It is not possible to develop the user component with .NET and orders pcoxy compnent with python both should be same development platform
            - ex. DCOM, .NET Remoting, Java RMI
        - Web API
            -  ex. My Web app communicating with Weather Web app using WebAPI
            - both the components can be built with any platforms


- Importance of API
    - Your API will be used
        - By your UI
        - To extend your app's reach
        - Mordern apps are built for web and mobile
        - Mobile apps MUST have an API on the server in order to communicate with it
        - Web clients built using SPA also MUST have an API on the server
