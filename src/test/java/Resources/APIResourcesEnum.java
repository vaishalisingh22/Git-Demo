package Resources;

public enum APIResourcesEnum {
   
	
	AddPlaceAPI("/maps/api/place/add/json"),GetPlaceAPI("/maps/api/place/get/json"),DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	APIResourcesEnum(String resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}
	public String getResource()
	{
		return resource;
	}
}
