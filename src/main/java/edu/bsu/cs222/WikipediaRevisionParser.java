package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser {
    public String parse(InputStream testDataStream) throws IOException{
        ArrayList<String> list = new ArrayList<>();
        Reformatting reform = new Reformatting();
        JSONArray revisions = JsonPath.read(testDataStream,"$..revisions");
        JSONArray result = JsonPath.read(revisions,"$..user");
        JSONArray result2 = JsonPath.read(revisions,"$..timestamp");
        reform.getUser(result);
        String time;
        String user;
        StringBuilder line;
        for(int i = 0;i < 30;i++){
            user = result.get(i).toString();
            for(int j = 0;j < 1;j++){
                time = result2.get(i).toString();
                line = new StringBuilder(user + " " + time);
                list.add(i, line.toString());
            }
        }
        line = new StringBuilder();
        for(int k = 30;k > 0; k--){
            line.append(list.get(k - 1)).append("\n");
        }
        return line.toString();
    }
}
