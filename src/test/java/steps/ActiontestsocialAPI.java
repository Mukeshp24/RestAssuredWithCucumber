package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ActiontestsocialAPI {
public void send_Get_request(String url){
	Response response = given().
	when().
	
	get(url).
	
	then().extract().response();
	Assert.assertEquals(200, response.getStatusCode());
	
	
}

public void then_responce_code_should_be(String url){
	
	given().
	when().
	get(url).
	 then().
	  assertThat().statusCode(200);
}
public void veryfy_total_pages_are(String url){
	given().
	when().
	get(url).
	 then().
	  assertThat().

       body("total_pages",equalTo(4));
}
}
