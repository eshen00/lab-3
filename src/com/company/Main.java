package com.company;


import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Main {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
        String input = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] splitedString = input.split(" ");
        long word = splitedString.length;
        System.out.println("Words in the text: " + word);
        String specificedWord = "Prince";
        long wordRepeat = 0;
        for (int i = 0; i < splitedString.length; i++) {
            if (splitedString[i] == specificedWord) {
                wordRepeat++;
                System.out.println(splitedString[i]);
            }
        }
        System.out.println(wordRepeat);
    }
}
