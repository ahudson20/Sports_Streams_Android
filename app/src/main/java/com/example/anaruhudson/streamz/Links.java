package com.example.anaruhudson.streamz;

import java.io.*;
import java.util.*;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author anaruhudson
 */
public class Links {
    private String url;
    private Map<String, Collection<String>> finalLinks = new HashMap<>();

    /**
     * Constructor for Links class, sets URL to the value passed,
     * and calls setLinksToDive.
     * @param url a String of the URL to be accessed and have links scraped from.
     */
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

            // Need better way of getting links to dive, otherwise will have to manually update reddit CSS selectors
            // Elements h2Only = doc.select("h2.s56cc5r-0");
            // Most recent css selector: .s1okktje-0
            Elements h2Only = doc.select("h2");

            for(Element e : h2Only){
                String text = e.text();
                if (text.matches("(.*)(\\s)(?i)v(\\s)(.*)") || text.matches("(.*)(\\s)(?i)vs(\\s)(.*)") || text.matches("(.*)(\\s)(?i)vs.(\\s)(.*)") || text.matches("(.*)(\\s)(?i)v.(\\s)(.*)") || text.matches("(.*)(\\s)(?i)at(\\s)(.*)") || text.matches("(.*)(\\s)(?i)@(\\s)(.*)")) {
                    text = text.replaceAll("(?i)game thread:", "").replaceAll("(?i)archive thread:", "").replaceAll("(?i)event thread thread:", "").replaceAll("(\\[)([A-Za-z0-9:\\s])*(\\])", "").replaceAll("(\\()([A-Za-z0-9:\\s])*(\\))", "").trim();
                    finalLinks.put(text, diveLink(e.parent().attr("abs:href")));
                }
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Takes a String representing a URL of a Game Thread.
     * It tries to connect to the URL, and scrapes for any live-stream links and adds them to a LinkedHashSet.
     *
     * @param link the URL that should be connected to and scraped for streams.
     * @return eachLink a Collection of strings storing each live-stream link for the associated Game Thread.
     */
    private Collection<String> diveLink(String link){
        Collection<String> eachLink = new LinkedHashSet<>();
        try {
            Document doc = Jsoup.connect(link).get();

            //Elements streamsOnly = doc.select("a[href].s14dydj4-27");
            Elements allLinks = doc.select("a[href]");

            Elements a = new Elements();

            for(Element e : allLinks){
                if(e.parent().parent().parent().parent().parent().className().contains("Comment")){
                    a.add(e);
                }
            }

            for(Element e : a){
                String httpHref = e.attr("abs:href");
                if(!(   httpHref.contains("https://www.reddit.com") ||
                        httpHref.contains("https://discord") ||
                        httpHref.contains("https://time.is") ||
                        httpHref.matches("(((https)||(http))://image.prntscr.com(.*))") ||
                        httpHref.matches("((https)||(http)://i.imgur.com(.*))") ||
                        httpHref.matches("(http://www.timebie.com)(.*)") ||
                        httpHref.matches("((https://)||(http://))(.*)reddit(.*)(.com)(.*)"))){
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
