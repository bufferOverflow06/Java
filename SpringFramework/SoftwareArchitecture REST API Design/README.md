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
            - ex. User library and logging library(logging API)
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
            - It mandates that both the components must use the same development platform like
                - It is not possible to develop the user component with .NET and orders proxy component with python both should be same development platform
            - ex. DCOM, .NET Remoting, Java RMI
        - Web API
            -  ex. My Web app communicating with Weather Web app using WebAPI
            - both the components can be built with any platforms


- Importance of API
    - Your API will be used
        - By your UI
        - To extend your app's reach
        - Modern apps are built for web and mobile
        - Mobile apps MUST have an API on the server in order to communicate with it
        - Web clients built using SPA also MUST have an API on the server

Some more details on Web API:

- Platform Agnostic
    - meaning .NET component can easily communicate with the python component using WebAPI
- Use Standard Protocols over HTTP
- Usually request/response based
    - request will be based on HTTP request say from .NET to python component and we receive back an HTTP response. This is part of the HTTP protocol

- WebAPI are differentiated by
    - Request Format(JSON, XML ...)
    - Request Contents
    - Response Format
    - Response Contents

### Types of WebAPI's
    - SOAP
    - REST
    - GraphQL
    - gRPC

1) SOAP
    - Simple Object Access Protocol
    - Designed in 1998 for Microsoft
    - XML - Based
    - RPC Style
        - when a client calls a server it calls a specific method or a specific procedure RPC (Remote Procedure Call) which means a client calls a very specific method
    - Extensible
        - means there is a base protocol which is used to call a method and get a response and it could be extended also for various attributes such as authentication, routing, transaction, federation, and so on.
    - Outdated
    - Do not use it unless have to

2) REST
    - Representational State Transfer
    - Designed in 2000 by Roy Fielding
    - URL + JSON - send to URL and we get back JSON
    - Message Style
        - we are not calling a specific method or procedure, we are just calling a URL and passing the message, the URL endpoint should be able to understand what to do with this message and then pass it along and return us the response.
    - De Facto Standard for APIs

3) GraphQL
    - Developed internally in 2012 by Facebook
    - Released publicly in 2015
    - Enables very flexible querying, updating and subscribing to data changes
        - means in contrast to REST that allows you to query an entity and then get the whole entity back, GraphQL allows you to specify exactly which fields you want to get back, and specify what parameters to use in the query itself
        - In addition we have subscribing capabilities meaning you can get notifications about updates for the entities that you have retrieved and merge those updates in the entities.
    - similar to REST, based on JSON in and out
    ```graphql
    <!-- Request -->
    query{
        posts {
            id
            title
            body
            published
            author{
                name
            }
        }
    }

    <!-- Response -->
    {
        "data":{
            {
                "posts": [
                    "id": "1",
                    "titles": "Why and how?",
                    "body": "this is a post",
                    "published": true,
                    "author": {
                        "name": "AAA",
                    }
                ]
            }
        }
    }
    ```
- Very flexible
- Requires some upfront dev effort
- Requires performance optimization
- Gains ground(ie. Github)
    - only specific fields required

4) gRPC
    - Developed by Google in 2015
    - Using HTTP/2
        - HTTP/2 allows two way streaming means instead of a request and then a response we can implement it duplex meaning the server can send messages to the client and the other way around
    - Uses `Protobuf` as a transport mechanism instead of XML or JSON
        - Protobuf is a serialization protocol developed by Google it allows different development platforms such as .NET or Java to communicate between them using code generators that read the protobuf protocol and message
    - Supports bi-directional and streaming messages
        - as it used HTTP/2
```gRPC
service HelloService{
    rpc SayHello (HelloRequest) returns (HelloResponse);
}

message HelloRequest{
    string greeting = 1;
}

message HelloResponse {
    string reply = 1;
}
```
    - gRPC takes care of all serialization of the request and the response, and we don't need to worry about it
- In contrast to GraphQL the performance of gRPC is great
- Not widely used yet as HTTP/2 is not widely used yet
- Requires specilalized libraries at both ends because of protobuf,
    - In order to use protobuf we need to have code generators at both ends to serialize the protocol to classes in the platform you are using. So this another thing that we have to take into account while using gRPC
