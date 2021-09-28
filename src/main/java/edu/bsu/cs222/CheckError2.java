package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class CheckError2 {
    public void pageCheck(InputStream inputStream) throws IOException {

        JSONArray page = JsonPath.read(inputStream,"$..pages");
        System.out.println(page.get(0).toString());
        if(0 == Integer.parseInt(page.get(0).toString())){
            System.out.println("There is no pages for this topic");
        }

    }
}