package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WikipediaRevisionParser {
    public String parse(InputStream testDataStream) throws IOException{
        ArrayList<String> list = new ArrayList<>();
        JSONArray revisions = getRevisions(testDataStream);
        JSONArray result = JsonPath.read(revisions,"$..user");
        JSONArray result2 = JsonPath.read(revisions,"$..timestamp");
        String time;
        String user;
        StringBuilder line;
        if(result.size() < 1){
            System.out.println("No Article Found...");
            System.exit(2);
        }
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
            line.append("\n").append(list.get(k - 1)).append("\n");
        }
        return line.toString();
    }
    public JSONArray getRevisions(InputStream testDataStream) throws IOException {
        JSONArray revision = JsonPath.read(testDataStream,"$..revisions");
        return revision;
    }
}
