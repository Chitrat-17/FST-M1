package activities;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Activity2 {
	
  @Test(priority = 1)
  public void post() throws IOException {
	  String baseURI = "https://petstore.swagger.io/v2/user";
	  FileInputStream reqFile = new FileInputStream("C:/Users/CHITRA/eclipse-workspace/fst-m1-restassured/src/test/resources/reqFile.json");
	  
	  Response response = given().contentType(ContentType.JSON)
			  .body(reqFile)
			  .when().post(baseURI);
	  
	  reqFile.close();
	  response.prettyPrint();
	  response.then().statusCode(200);
	  response.then().body("message", equalTo("7717"));
	  
  }
  
  @Test(priority = 2)
  public void get() {
	  String baseURI = "https://petstore.swagger.io/v2/user/{username}";
	  
	  Response response = given().contentType(ContentType.JSON)
			  .pathParam("username", "harry17")
			  .when().get(baseURI);
	  response.prettyPrint();
	  response.then().statusCode(200);
	  response.then().body("id", equalTo(7717));
	  response.then().body("username", equalTo("harry17"));
	  response.then().body("firstName", equalTo("Harry"));
	  response.then().body("lastName", equalTo("Case"));
	  response.then().body("email", equalTo("harrycase@mail.com"));
	  response.then().body("password", equalTo("password123"));
	  response.then().body("phone", equalTo("9812763450"));
	  
	  String resBody = response.asPrettyString();
	  try {
		  File resFilePath = new File("C:/Users/CHITRA/eclipse-workspace/fst-m1-restassured/src/test/resources/resFile.json");
		  resFilePath.createNewFile();
		  FileWriter writer = new FileWriter(resFilePath.getPath());
		  writer.write(resBody);
		  writer.close();
		  
		  
	  }catch (IOException e) {
	        e.printStackTrace();
	    }
	  
	  
  }
  
  @Test(priority = 3)
  public void delete() {
	  String baseURI = "https://petstore.swagger.io/v2/user/{username}";
	  Response res = given().contentType(ContentType.JSON)
			  .pathParam("username", "harry17")
			  .when().delete(baseURI);
	  res.prettyPrint();
	  res.then().statusCode(200);
	  res.then().body("code", equalTo(200));
	  res.then().body("message", equalTo("harry17"));
	  
  }
  
}
