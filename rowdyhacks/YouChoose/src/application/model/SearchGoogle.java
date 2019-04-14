package application.model;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.io.BufferedReader;

public class SearchGoogle {
	
	private String food;
	private String lat;
	private String lon;
	private ArrayList<Restaurant> rList;

	
	    public SearchGoogle(String food, String lat, String lon) {
	    	
			this.food = food;
			this.lat = lat;
			this.lon = lon;
			this.rList = new ArrayList<Restaurant>();
	    }

		public void find(String food, String lat, String lon) throws IOException {
	   
	        try {
	          
	            String first = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=";
	            String second = "&keyword=";
	            String third = "&rankby=distance&type=food&key=AIzaSyAoMUXRwioECDzaC9Ml7p3Yc4kbZ9gfjK4";
	            String charset = "UTF-8";
	            
	            URL yahoo = new URL(first + URLEncoder.encode(lat, charset) + "," + URLEncoder.encode(lon, charset) + second + URLEncoder.encode(food + " food", charset) + third);
	            URLConnection yc = yahoo.openConnection();
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(
	                    yc.getInputStream()));
	            String inputLine;	            
                
                String tName=null;
                String tVicinity=null;
                String tRating=null;
                String tOpen=null;
                String tPricing=null;
                String tState = null;
                String tCountry = null;
                
                
	            while ((inputLine = in.readLine()) != null) { 
	            	
	                String[] token = inputLine.split("\\:");

	                token[0] = token[0].replaceAll("\\s+","");
	                if(token.length == 2 && token[0].equals("\"name\"")) {
	                	tName = token[1].replaceAll("\"","");
	                	tName = tName.replaceAll(",","");
	                }
	                
	                if(token.length == 2 && token[0].equals("\"rating\"")) {
	                	tRating = token[1].replaceAll(",","");
	                }
	                if(token.length == 2 && token[0].equals("\"open_now\"")) {
	                	tOpen = token[1].replaceAll("\\s+", "");
	                }
	                if(token.length == 2 && token[0].equals("\"pricing\"")) {
	                	tPricing = token[1];
	                }
	                if(token.length == 2 && token[0].equals("\"compound_code\"")) {
	                	String tStateCountry[] = token[1].split("\\,");
	                	tState = tStateCountry[1];
	                	tCountry = tStateCountry[2].replaceAll("\"","");
	                	
	                
	                	//System.out.println(tState + "," + tState);
	                }
	                
	                if(token.length == 2 && token[0].equals("\"vicinity\"")) {
	                	tVicinity = token[1].replaceAll("\"","");
	               
	                	Restaurant temp = new Restaurant( tName, tVicinity, tPricing, tRating, tOpen, tState, tCountry);

	                	tName=null;
	                	tVicinity=null;
	                	tPricing=null;
	                	tRating=null;
	                	tOpen=null;
	                    tState = null;
	                    tCountry = null;
	                	rList.add(temp);
	                }
	                
	            }
	            in.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	    }
		
		public String ToString() {
			String use = "";
			for(Restaurant x: rList) {
				use += x.toString();
			}
			
			return use;
		}

	    public String getFood() {
			return food;
		}

		public void setFood(String food) {
			this.food = food;
		}

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getLon() {
			return lon;
		}

		public void setLon(String lon) {
			this.lon = lon;
		}
	    
	    
	}


