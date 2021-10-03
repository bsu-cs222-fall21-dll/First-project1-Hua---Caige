package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class CheckError2 {
    public void pageCheck(InputStream inputStream) throws IOException {

        JSONArray page = JsonPath.read(inputStream,"$..pages");
        if(page.indexOf(0) == -1){
            System.out.println("No Article Found...");
            System.exit(2);
        }


    }
}