package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {
    public String parse(InputStream testDataStream) throws IOException{
        JSONArray result = (JSONArray) JsonPath.read(testDataStream,"$..user");
        String time;
        String user;
        String line = "";
        for(int i = 0;i < 30;i++){
            user = result.get(i).toString();
            JSONArray result2 = (JSONArray) JsonPath.read(testDataStream,"$..timestamp");
            for(int j = 0;j < 1;j++){
                time = result2.get(j).toString();
                line = user + time;
                System.out.println(line);
            }

        }

        return line;
    }
}
