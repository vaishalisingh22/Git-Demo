package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		stepDefinitions obj= new stepDefinitions();
		if (stepDefinitions.place_id==null)          //static variable can be called with class name
		{
				
		obj.add_place_payload("vaishali","English","delhi");
		obj.user_calls_with_http_request("AddPlaceAPI", "POST");
		obj.verify_place_id_created_to_using("vaishali","GetPlaceAPI");
	}                                                                    
	}
	
}
