package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value="")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye";
    }

    // Example request
    // http://localhost:8080/servletRequest?name=chris
    @RequestMapping(value="servletRequest")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "Hello " + name;
    }

    // Example request
    // http://localhost:8080/helloForm
    @RequestMapping(value = "helloForm", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "helloForm", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Hello " + name;
    }

    // Example request
    // errors out if param not given or given incorrectly
    // http://localhost:8080/helloPath/chris
    @RequestMapping(value = "helloPath/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }
}
