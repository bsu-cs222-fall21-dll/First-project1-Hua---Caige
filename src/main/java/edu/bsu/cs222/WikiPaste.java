package edu.bsu.cs222;

import com.sun.tools.javac.Main;

import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class WikiPaste {
    public String getRevisionOf(String wikiTitle) throws IOException{

        String urlStr = String.format("en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rbprop=timestamp&rvlimit=1",wikiTitle);
        String encodedUrlStr = URLEncoder.encode(urlStr, Charset.defaultCharset());
        if( wikiTitle == ""){
            System.out.println("There was no Input");
            System.exit(1);
            return null;
        }
        URL url = new URL(encodedUrlStr);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent","Revision Reporter/0.1; carogers@bsu.edu");
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String pageTitle = br.readLine();
        System.out.printf("Redirected to %s",pageTitle);
        try {
            String revisions = parser.parse(inputStream);
            String jsonWiki1 = revisions.replace("},{", "\n");
            String jsonWiki2 = jsonWiki1.replace("[{", "");
            String jsonWiki3 = jsonWiki2.replace("\"user\":\"","");
            String jsonWiki4 = jsonWiki3.replace("\",\"timestamp\":\"", "change was made at");
            String jsonWiki5 = jsonWiki4.replace("}]", "");

            return jsonWiki5;
        } catch(ConnectException connectException){
            System.out.println("There was a network Error");
            System.exit(3);
        }

        String checkPage = br.readLine();
        br.close();
        System.exit(2);
        return checkPage;

    }
}
