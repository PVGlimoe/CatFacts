package com.example.demo.services;
import com.google.gson.Gson;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CatService {
    public CatFact getCatData() throws IOException {
        //Choose what API to consume
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        //Instantiate a Buffered Reader to consume the InputStream from the URL
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        //Map the data from Json to an object
        CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
        //Close the BufferedReader
        inputFromCatURL.close();

        return data;
    }
    public ArrayList<CatFact> getTenCatFacts() throws IOException {
        ArrayList<CatFact> listOfCatFacts = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            listOfCatFacts.add(getCatData());
            System.out.println(i);
        }
        return listOfCatFacts;
    }

    public ArrayList<CatFact> sortCatFacts() throws IOException {
       ArrayList<CatFact> listOfCatFacts = getTenCatFacts();
        Collections.sort(listOfCatFacts);
        return listOfCatFacts;
    }

    public String catFactContains(String character, int amount){
        String catFact = getCatData().toString();
        int occurrences = StringUtils.countOccurrencesOf(catFact, character);
        if(occurrences == amount) {
            return catFact;
        }
        return "Sorry no luck";

    }
}
