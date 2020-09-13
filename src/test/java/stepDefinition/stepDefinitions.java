package stepDefinition;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import static io.restassured.RestAssured.given;

import Resources.APIResourcesEnum;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinitions extends Utils{

	Response finalResponse;
	RequestSpecification response;
	ResponseSpecification res;
	JsonPath js;
	static String place_id;
	
	TestDataBuild p= new TestDataBuild();
	
	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    	    
	   		
		response=given().spec(requestSpec()).body(p.AddPlaceBuild(name,language,address));
	}

	@When("User Calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		
		//res= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	APIResourcesEnum resourceAPI=APIResourcesEnum.valueOf(resource);
		
		if (method.equalsIgnoreCase("POST"))
		{		finalResponse =response.when().post(resourceAPI.getResource());
		System.out.println(resourceAPI.getResource());
		}
		else if (method.equalsIgnoreCase("GET"))
			{ finalResponse=response.when().get(resourceAPI.getResource());
			System.out.println(resourceAPI.getResource());
			}
		else if (method.equalsIgnoreCase("DELETE"))
			{finalResponse=response.when().delete(resourceAPI.getResource());
			System.out.println(resourceAPI.getResource());
			}
	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer status) {
	    // Write code here that turns the phrase above into concrete action
				assertEquals (200,finalResponse.getStatusCode());
		
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expected) {
	    // Write code here that turns the phrase above into concrete actions
	    
		assertEquals(expected,jsonPath(finalResponse,key));
		System.out.println(key);
		System.out.println(expected);
	}
		@Then("Verify place_id created to {string} using {string}")
		public void verify_place_id_created_to_using(String name, String resource) throws IOException {
			
		place_id=jsonPath(finalResponse, "place_id");
		response=given().spec(requestSpec()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualName =jsonPath(finalResponse, "name");
		Assert.assertEquals(name, actualName);
		System.out.println(actualName);
		
	}
		
		@Given("DeletePlace Payload")
		public void delete_place_payload() throws IOException {
			response=given().spec(requestSpec()).body(p.deletePlacePayload(place_id));
						System.out.println("This is Git Practice code");
						System.out.println("This is Git Practice code");
						System.out.println("This is Git Practice code");
						System.out.println("This is Git Practice code");
		}
		
		public void print()
		{
			System.out.println("This is Git Practice code for branching");
			System.out.println("This is Git Practice code for branching");
			System.out.println("This is Git Practice code for branching");
		}
		}

