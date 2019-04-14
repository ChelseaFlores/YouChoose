package application.model;

public class Restaurant {

	private String name;
	private String address;
	private String price;
	private String rating;
	private String isOpen;
	private String state;
	private String country;	
	
	
	public Restaurant( String name, String address, String price, String rating, String isOpen, String state, String country) {
		this.name = name;
		this.address = address;
		this.price = price;
		this.rating = rating;
		this.isOpen = isOpen;
		this.state = state;
		this.country = country;
	}

	public String toString() {
		String ret = this.name + "\n";
		
		if(this.address != null)
			ret += "\t" + "Address: " + this.address + ", " + this.state + ", " + this.country + "\n";
		if(this.price != null)
			ret += "\t" + "Price Level: " + this.price + "\n";
		if(this.rating != null)
			ret += "\t" + "Rating: " + this.rating + "/5 \n";
		if(this.isOpen != null) {
			if( this.isOpen.equals("false"))
				ret += "\t" + "Currently Closed" + "\n";
			else if(this.isOpen.equals("true"))
				ret += "\t" + "Currently Opened" + "\n";
			else 
				ret += "\t" + "STASIS" + "\n";
		}
		
		ret += "\n";	
		return ret;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

}
