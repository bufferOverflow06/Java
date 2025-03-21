package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    // `service()` is an important method in servlet
    // which gets executed whenever we send a request

    // to send data from client to server we need object
    // we can pass two parameters one for the request and one for response
    public void service(HttpServletRequest req, HttpServletResponse res){
        System.out.println("In service method");
    }
}
