package com.example.demo.controller;

import com.example.demo.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MyController {
    private CatService catService = new CatService();
    private int nVisitors = 0;

    private String wrapResponseBody(String responseBody){
        return  "<a href='/'>Home</a>"
            +   "<br/>"
            +   responseBody;

    }

    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        nVisitors++;
        return  "Welcome!!!!!!"
            +   "<br/>"
            +   "<a href='/getSingle'>Get a single cat fact</a>"
            +   "<br/>"
            +   "<a href='/getTen'>Get 10 cat facts</a>"
            +   "<br/>"
            +   "<a href='/getTenSortByDate'>Get 10 sorted cat facts</a>"
            +   "<br/>"
            +   "<a href='/contains/?char=a&amount=2'>Contains</a> <br/>"
                + "Number of visitors: " + nVisitors;
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String getSingleFact() {
        try {
            return wrapResponseBody(catService.getCatData().toString());
        } catch (IOException e) {
            return wrapResponseBody("can't access server");
        }
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTenCatFacts() {
        try {
            return wrapResponseBody(catService.getTenCatFacts().toString());
        } catch (IOException e) {
            return wrapResponseBody("can't access server");
        }
    }

    @GetMapping ("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate(){
        try {
            return wrapResponseBody(catService.sortCatFacts().toString());
        } catch (IOException e) {
            return wrapResponseBody("can't access server");
        }
    }

    @GetMapping ("/contains")
    @ResponseBody
    public String contains(@RequestParam(name="char") String character, @RequestParam int amount){
        try {
            return wrapResponseBody(catService.catFactContains(character, amount));
        } catch (IOException e) {
            return wrapResponseBody("can't access server");
        }
    }

}
