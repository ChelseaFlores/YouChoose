package application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import application.controller.MainController;

public class ZipCode {
	
	String zipcode = MainController.zipString;
	
	public ZipCode( String zipcode )
	{
		this.zipcode = zipcode;
	}
	
	public ArrayList<String> returnLatLong() {
    	ArrayList<String> zipResults = new ArrayList<String>();

        try {
  
            String first = "https://maps.googleapis.com/maps/api/geocode/json?address=";
            String charset = "UTF-8";
            String part2 = "&key=AIzaSyAoMUXRwioECDzaC9Ml7p3Yc4kbZ9gfjK4";
            URL yahoo = new URL(first + URLEncoder.encode(zipcode, charset) + part2);
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;
            

            String newLine;
            while ((inputLine = in.readLine()) != null) { 
               // System.out.println(inputLine);
                int i = 0;
                newLine = inputLine.replaceAll("\\s+","");
                //System.out.println(newLine);
                String[] token = newLine.split("\\:");
                if(token.length == 2 && token[0].equals("\"location\"")) {
                    inputLine = in.readLine();
                    newLine = inputLine.replaceAll("\\s+","");
                    token = newLine.split("\\:");
                    token[1]=token[1].replaceAll("\\,","");
                    zipResults.add(token[1]);
                    inputLine = in.readLine();
                    newLine = inputLine.replaceAll("\\s+","");
                    token = newLine.split("\\:");
                    zipResults.add(token[1]);
                    //System.out.println(zipResults);
                    return zipResults;
                    
                }      
            }
            in.close();

            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return zipResults;
	}

}
