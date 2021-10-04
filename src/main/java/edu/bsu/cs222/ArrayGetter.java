package edu.bsu.cs222;


import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.*;

public class ArrayGetter {
    public String readLines(String jsonData) throws IOException {
        StringReader fr = new StringReader(jsonData);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder builder = new StringBuilder();
        Reformatting reform = new Reformatting();
        String read;
        while ((read = br.readLine()) != null) {
            System.out.println(read);
            String getInfo = reform.oneForAll(reform.getUser(read),reform.getTime(read));
            builder.append(getInfo);
        }
        return builder.toString();
    }
}

