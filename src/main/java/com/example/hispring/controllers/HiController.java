package com.example.hispring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;

@Controller
public class HiController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if  (name == null) {
            name = "World";
        }

        return "Yello " + name + "!";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hiForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Notice me!' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String hiPost(HttpServletRequest request) {

        String name = request.getParameter("name");

        return "Yello " + name +"!";
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String hiUrlSegment(@PathVariable String name) {
        return "Yello " + name + "!";

    }

    @RequestMapping(value = "latergator")
    @ResponseBody
    public String latorgator() {
        return "redirect:/";
    }

    @RequestMapping(value = "hungry")
    @ResponseBody
    public String hungry() {
        return "Feed me";
    }
}
