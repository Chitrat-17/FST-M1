package activities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class Activity3 {
	
	RequestSpecification reqSpec = new RequestSpecBuilder()
			.setContentType(ContentType.JSON)
			.setBaseUri("https://petstore.swagger.io/v2/pet")
			.build();
	
	ResponseSpecification resSpec = new ResponseSpecBuilder()
			.expectContentType(ContentType.JSON)
			.expectStatusCode(200)
			.expectBody("status", equalTo("alive"))
			.build();
	
	@DataProvider(name = "petlist")
	public Object[][] petinfo() {
		Object[][] testData = new Object[][] {
		    { 77232, "Riley", "alive" }, 
		    { 77233, "Hansel", "alive" } 
		};
		return testData;
	}
	

	@Test(priority = 1, dataProvider ="petlist")
	public void petCreation(int petId, String petName, String petStatus) {
		
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		Response response = given().spec(reqSpec)
				.body(reqBody)
				.when().post();
		
		response.prettyPrint();
		response.then().spec(resSpec);
		
	}

		
	@Test(priority = 2, dataProvider="petlist")
	public void getPet(int petId, String petName, String petStatus) {
	given().spec(reqSpec)
			.pathParam("petId", petId)
			.log().all()
			.when().get("/{petId}")
			.then().spec(resSpec)
			.body("name", equalTo(petName))
			.log().all();
	
					
	}
		
	@Test(priority = 3, dataProvider="petlist")
	public void deletePet(int petId, String petName, String petStatus) {
		given().spec(reqSpec)
		.pathParam("petId", petId)
		.log().all()
		.when().delete("/{petId}")
		.then()
		.body("code", equalTo(200))
		.body("message", equalTo(""+petId));
	}
		
}