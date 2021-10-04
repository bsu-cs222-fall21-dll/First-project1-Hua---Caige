package edu.bsu.cs222;


import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.*;

public class ArrayGetter {
    public String readLines(String jsonData,InputStream inputStream) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(inputStream, "$..query");
        System.out.println(result.get(0).toString());
        System.out.println(result);
        BufferedReader br = new BufferedReader(new StringReader(jsonData));
        Reformatting reform = new Reformatting("","");
        StringBuilder builder = new StringBuilder();
        String read;
        while ((read = br.readLine()) != null) {
            String user = reform.getUser();
            String time = reform.getTimeStamp();
            String line = String.format("At %s, %s made a change.\n",time,user);
            builder.append(read);
        }
        return builder.toString();
    }
}

