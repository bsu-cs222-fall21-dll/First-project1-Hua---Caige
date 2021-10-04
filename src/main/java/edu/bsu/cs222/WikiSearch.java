package edu.bsu.cs222;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

public class WikiSearch {

    public static String getRevisionOf(String wikiTitle) throws IOException{
        String encodeUrlStr = URLEncoder.encode(wikiTitle,Charset.defaultCharset());
        String urlStr = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rbprop=timestamp|user&rvlimit=30",encodeUrlStr);
        ArrayGetter ag = new ArrayGetter();
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent","WikipediaArticle/0.1; carogers@bsu.edu");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            WikipediaRevisionParser parser = new WikipediaRevisionParser();
            CheckError2 test = new CheckError2();
            //test.pageCheck(inputStream);

            String revisions = parser.parse(inputStream);
//            String jsonWiki1 = revisions2.replace("},{", "\n");
//            String jsonWiki2 = jsonWiki1.replace("[{", "");
//            String jsonWiki3 = jsonWiki2.replace("}]", "");
//            String jsonWiki4 = jsonWiki3.replace("\"","");
//            String jsonWiki5 = ag.readLines(jsonWiki4);
            ListConvert listConvert = new ListConvert();
            return revisions;
        } catch(MalformedURLException malformedURLException){
            throw new RuntimeException(malformedURLException);
        }
    }
}
