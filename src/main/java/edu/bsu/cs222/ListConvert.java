package edu.bsu.cs222;

import java.util.ArrayList;

public class ListConvert {
    public String revReversed(ArrayList<Reformatting> revisions){
        String reformatList = "";
        for(int i = 0;i < revisions.size();i++){
            Reformatting reformatting = revisions.get(i);
            String user = reformatting.getUser();
            String timeStamp = reformatting.getTimeStamp();
            String format = String.format("At %s, %s made a change.",timeStamp,user);
            reformatList += format;
        }
        return reformatList;
    }
}
