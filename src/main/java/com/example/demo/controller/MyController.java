package com.example.demo.controller;

import com.example.demo.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MyController {

    private String wrapResponseBody(String responseBody){
        return  "<a href='/'>Home</a>"
            +   "<br/>"
            +   responseBody;

    }

    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return  "Welcome!!!!!!"
            +   "<br/>"
            +   "<a href='/getSingle'>Get a single cat fact</a>"
            +   "<br/>"
            +   "<a href='/getTen'>Get 10 cat facts</a>"
            +   "<br/>"
            +   "<a href='/getTenSortByDate'>Get 10 sorted cat facts</a>";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String getSingleFact() {
        CatService catService = new CatService();
        try {
            return wrapResponseBody(catService.getCatData().toString());
        } catch (IOException e) {
            return wrapResponseBody("can't access server");
        }
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTenCatFacts() {
        CatService catService = new CatService();
        try {
            return wrapResponseBody(catService.getTenCatFacts().toString());
        } catch (IOException e) {
            return wrapResponseBody("can't access server");
        }
    }

    @GetMapping ("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate(){
        CatService catService = new CatService();
        try {
            return wrapResponseBody(catService.sortCatFacts().toString());
        } catch (IOException e) {
            return wrapResponseBody("can't access server");
        }
    }

}
