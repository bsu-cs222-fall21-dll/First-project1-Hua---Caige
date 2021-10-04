package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser {
    public String parse(InputStream testDataStream) throws IOException{
        Reformatting reform = new Reformatting();
        JSONArray revisions = JsonPath.read(testDataStream,"$..revisions");
        JSONArray result = (JSONArray) JsonPath.read(revisions,"$..user");
        JSONArray result2 = (JSONArray) JsonPath.read(revisions,"$..timestamp");
        reform.getUser(result);
        String time;
        String user = "";
        String line = "";
        for(int i = 0;i < 30;i++){
            user = result.get(i).toString();
            for(int j = 0;j < 1;j++){
                time = result2.get(i).toString();
                line = user + " " + time;
                System.out.println(line);
            }
        }

        return line;
    }
}
