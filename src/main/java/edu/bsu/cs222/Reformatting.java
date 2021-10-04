package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Reformatting {

    public ArrayList getUser(JSONArray result){
        ArrayList<String> user = new ArrayList<>();
        System.out.println(result.get(0).toString());
        user.add(result.get(0).toString());
        System.out.println();
        return user;
    }
    public String getTime(String info){
        String time = "";
        return time;
    }
}