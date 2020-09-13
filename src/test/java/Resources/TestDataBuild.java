package Resources;

import java.util.ArrayList;

import Pojo.PojoObject;
import Pojo.location;


public class TestDataBuild {

	public PojoObject AddPlaceBuild(String name, String language, String address)
	{
PojoObject obj=new PojoObject();
		
		location l= new location();
		l.setLat(-38.383494);
	    l.setLng(33.383494);	    
	    obj.setLocation(l);
	    
		obj.setAccuracy(50);
		obj.setName(name);
		obj.setPhone_number("983 893 3937");
		obj.setAddress(address);
		obj.setLanguage(language);
		obj.setWebsite("www.google.com");
			
		ArrayList<String> mytypes = new ArrayList<String>( );
			mytypes.add("shoe park");
			mytypes.add("shop");
		obj.setTypes(mytypes);
		return obj;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n" + 
				"    \"place_id\":\""+placeId+"\"\r\n" + 
				"}";
		
	}
}
