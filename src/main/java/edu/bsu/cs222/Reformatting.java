package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Reformatting {
    private JSONArray reformatItems;

    public Reformatting(String user, String time) {
        this.getUser();
        this.getTimeStamp();
    }

    public void Revision(JSONArray reformatItems){
        this.reformatItems = reformatItems;
    }

    public String getUser() {
        JSONArray user = JsonPath.read(reformatItems,"$..user");
        return user.get(0).toString();
    }

    public String getTimeStamp() {
        JSONArray timeStamp = JsonPath.read(reformatItems,"$..timestamp");
        return timeStamp.get(0).toString();
    }
}