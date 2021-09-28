package edu.bsu.cs222;

import java.io.IOException;

public class Main extends WikiPaste{
    public static void main(String[] args) throws IOException {
        WikiPaste wikiPaste = new WikiPaste();
        System.out.println("--------------\n+--Wikipedia-+\n--------------\n");
        System.out.println("Type what you want to search...");
        // calls WikiPaste Class
        System.out.println(wikiPaste.wikiPaste());
        System.exit(0);


    }
}