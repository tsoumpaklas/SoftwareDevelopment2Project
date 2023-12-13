package data;

public class Address {
	private String country;
	private String city;
	private String street;
	private int streetNumber;

	
	public String getCountry(){
		return country;
	}

	public String getCity(){
		return city;
	}

	public String getStreet(){
		return street;
	}

	public Integer getStreetNumber(){
		return streetNumber;
	}


	
	public void setCountry(String country){
		this.country = country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public void setStreetNumber(int streetNumber){
		this.streetNumber = streetNumber;
	}

}

