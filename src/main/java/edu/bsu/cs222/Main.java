package edu.bsu.cs222;


import java.io.IOException;
import java.util.Scanner;

public class Main extends WikiPaste{
    public static void main(String[] args) throws IOException {
        WikiPaste wikiPaste = new WikiPaste();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------\n+--Wikipedia-+\n--------------\n");
        System.out.println("Type what you want to search...");
        String entry = scanner.nextLine();
        System.out.println(wikiPaste.getRevisionOf(entry));


    }
}
