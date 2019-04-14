package application.model;

public class SearchOption{
	
	private String cuisineType;
	private String lat;
	private String lon;
	
	public SearchOption( String cuisineType, String lat, String lon ) {
		this.cuisineType = cuisineType;
		this.lat = lat;
		this.lon = lon;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
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
