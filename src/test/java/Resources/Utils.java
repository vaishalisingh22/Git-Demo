package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	public RequestSpecification requestSpec() throws IOException
	{
		if (req==null)
		{
				PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		
	
		req= new RequestSpecBuilder().setBaseUri(getGlobalValues("baseURI"))
				.addQueryParam("key","qaclick123").setContentType(ContentType.JSON)
				.build().filter(RequestLoggingFilter.logRequestTo(log))
				.filter(ResponseLoggingFilter.logResponseTo(log));
		return req;
		}
		return req;
	}
	
	public static String getGlobalValues(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\API_Framework\\src\\test\\java\\Resources\\Global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public static String jsonPath(Response finalResponse, String key)
	{
		String resp=finalResponse.asString();
		JsonPath js=new JsonPath(resp);
		return js.get(key).toString();
	}
}
