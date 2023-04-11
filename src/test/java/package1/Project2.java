package package1;

import static org.hamcrest.Matchers.lessThan;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Project2 {

	Response response;

	@BeforeMethod
	public void baseUri() {
		response = RestAssured.given().when().get("https://api.publicapis.org/entries");
	}

	@Test
	public void categoryAnimalsLinkGithub() {
		ApiResponsePojo2 responsePojo = response.as(ApiResponsePojo2.class);
		ApiResponsePojo2Details[] entries = responsePojo.getEntries();
		System.out.println("Total Entries= " + entries.length);
		ArrayList<ApiResponsePojo2Details> entry2 = new ArrayList<ApiResponsePojo2Details>();

		for (ApiResponsePojo2Details i : entries) {
			if ((i.getCategory().equalsIgnoreCase("Animals")) && (i.getLink().contains("github")))
				entry2.add(i);
		}
		System.out.println("Number of entries= " + entry2.size());
		int n = entry2.size();
		for (int i = 0; i < n; i++) {
			System.out.println("Entry " + i + entry2.get(i).getApi() + " " + entry2.get(i).getAuth() + " "
					+ entry2.get(i).getCategory() + " " + entry2.get(i).getCors() + " " + entry2.get(i).getDescription()
					+ " " + entry2.get(i).getLink());
		}
	}
	
	@Test
	public void distinctCors() {
		ApiResponsePojo2 responsePojo = response.as(ApiResponsePojo2.class);
		ApiResponsePojo2Details[] entries = responsePojo.getEntries();
		HashSet<String> cors = new HashSet<String>();
		for (ApiResponsePojo2Details i : entries) {
			cors.add(i.getCors());
		}
		Iterator<String> it = cors.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Number of APIs with distinct cors: "+cors.size());	
	}
	
	@Test
	public void typesOfAuth() {
		List<String> authApiKey= response.jsonPath().getList("entries.findAll { it.Auth == 'apiKey' }");
		System.out.println("Number of APIs with apiKey= "+ authApiKey.size());
		
		List<String> noAuth= response.jsonPath().getList("entries.findAll { it.Auth == '' }");
		System.out.println("Number of APIs with no auth= "+ noAuth.size());
		
		List<String> oAuth= response.jsonPath().getList("entries.findAll { it.Auth == 'OAuth' }");
		System.out.println("Number of APIs with oAuth= "+ oAuth.size());
		
	}
	
	@Test
	public void statusCode() {
		response.then().statusCode(200);
	}
	
	@Test
	public void responseTime() {
		response.then().time(lessThan(5000L));
	}
}
