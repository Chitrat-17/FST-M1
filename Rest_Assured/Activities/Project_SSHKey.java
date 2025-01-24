package api_tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Project_SSHKey {
	RequestSpecification  requestSpec;
	String sshKey ;
	int id;
	
	@BeforeClass
	public void setUp() {
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "token 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")
				.setBaseUri("https://api.github.com")
				.build();
	}
	
  @Test(priority = 1)
  public void postSSHKey() {
	  String reqBody = """	

{
    "title": "TestAPIKey",
    "key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICaYxqICIr9mM6+osdDTwHAbPoNZcHVn8ujVGzzMlbuP"
}
""";

	  Response response = given().spec(requestSpec)
			  .body(reqBody)
			  .when()
			  .post("/user/keys");
	  System.out.println("------- post-------");
	  response.prettyPrint();
	  response.then().statusCode(201);	  
	  id = response.getBody().path("id");
	 System.out.println("id : "+id);
  }
  
  @Test(priority = 2)
  public void getSSHKey() {
	  
	  Response response = given().spec(requestSpec)
			  .pathParam("keyId", id)
			  .when()
			  .get("/user/keys/{keyId}");

	  System.out.println("------- get-------");
	  response.then().statusCode(200)
	  .log().all();
	  
  }
  
  @Test(priority = 3)
  public void deleteSSHKey() {
	  Response response = given().spec(requestSpec)
			  .pathParam("keyId", id)
			  .when()
			  .delete("/user/keys/{keyId}");
	  System.out.println("------- delete-------");
	  response.then().statusCode(204)
	  .log().all();
	  
  }
}
