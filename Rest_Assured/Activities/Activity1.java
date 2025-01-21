package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {


  @Test(priority = 1)
  public void post() {
	  String BASE_URI = "https://petstore.swagger.io/v2/pet";
	  
	  String reqBody = """
	  		{
  "id": 77232,
  "name": "Riley",
  "status": "alive"
}
	  		""";
	  Response response = given().contentType(ContentType.JSON)
			  .body(reqBody)
			  .when().post(BASE_URI);
	  
	  response.prettyPrint();
	  response.then().statusCode(200);
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
	  
  }
  
  @Test(priority = 2)
  public void get() {
	  String BASE_URI = "https://petstore.swagger.io/v2/pet/{petId}";
	  Response response = given().contentType(ContentType.JSON).pathParam("petId", 77232)
			  .when().get(BASE_URI);
	  response.prettyPrint();
	  response.then().statusCode(200);
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
  }
  
  @Test(priority = 3)
  public void delete() {
	  String BASE_URI = "https://petstore.swagger.io/v2/pet/{petId}";
	  Response response = given().contentType(ContentType.JSON).pathParam("petId", 77232)
			  .when().delete(BASE_URI);
	  response.prettyPrint();
	  response.then().body("message", equalTo("77232"));
	 
  }
}
