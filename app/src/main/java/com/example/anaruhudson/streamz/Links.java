package com.example.anaruhudson.streamz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.util.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Links {
    private String url;
    private Map<String, Collection<String>> finalLinks = new HashMap<>();

    Links(String url){
        this.url = url;
        setLinksToDive();
    }

    /**
     * Tries to connect to the link set in data-field,
     * Then finds the posts on Reddit for each Game Thread, and calls diveLink on each Game Thread link.
     */
    private void setLinksToDive(){
        try {
            Document doc = Jsoup.connect(this.url).get();

            /* Need better way of getting links to dive, otherwise will have to manually update reddit CSS selectors */
            //Elements h2Only = doc.select("h2.s56cc5r-0");
            Elements h2Only = doc.select("h2.s1okktje-0");

            for(Element m : h2Only){
                String text = m.text();
                /* FIGURE OUT A BETTER WAY OF FILTERING LINKS?? */
                /* Doesnt make sense to keep manually filtering links? - most are permanent links though.. */
                if((text.matches(".*\\d+.*") || text.contains("Game Thread")) && !text.contains("PS4") && !text.contains("NHL TV") && !text.contains("PLEASE")){
                    String httpHref = m.parent().attr("abs:href");

                    text = text.replaceAll("(\\[)([A-Za-z0-9:\\s])*(])", "").trim();
                    text = text.replaceAll("(?i)game thread:", "").trim();
                    text = text.replaceAll("(?i)archive thread:", "").trim();
                    text = text.replaceAll("(?i)event thread thread:", "").trim();

                    if(httpHref.length() > 0){
                        finalLinks.put(text, diveLink(httpHref));
                    }
                }
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Takes a String representing a URL of a Game Thread.
     * It tries to connect to the URL, and scrapes for any livestream links and adds them to a LinkedHashSet.
     *
     * @param link the URL that should be connected to and scraped for streams.
     * @return eachLink a Collection of strings storing each livestream link for the associated Game Thread.
     */
    private Collection<String> diveLink(String link){
        Collection<String> eachLink = new LinkedHashSet<>();
        try {
            Document doc = Jsoup.connect(link).get();

            Elements streamsOnly = doc.select("a[href].s90z9tc-27");

            for(Element h : streamsOnly){
                String httpHref = h.attr("abs:href");
                if(!(httpHref.contains("https://www.reddit.com") || httpHref.contains("https://discord") || httpHref.contains("https://time.is"))){
                    eachLink.add(httpHref);
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return eachLink;
    }

    /**
     *
     * @return finalLinks a Map -- stream names, and a Collection of Strings that are URLs to streams.
     */
    public Map<String, Collection<String>> getFinalLinks(){
        return finalLinks;
    }
}
