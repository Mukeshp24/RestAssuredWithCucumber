package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.ck.Datum;
import model.ck.Users;

import static org.junit.Assert.*;

public class testsocialAccountAPI {
	String url = "";
	FileInputStream fis;

	@Given("^send GET request \"([^\"]*)\"$")
	public void send_GET_request(String url) throws Throwable {
		this.url = url;

		Response response = given().
				
				when().
				
				get(url).
				
				then().assertThat().statusCode(200).
				extract().response();

	}

	@Then("^then responce code should be (\\d+)$")
	public void then_responce_code_should_be(int statusCode) throws Throwable {

		given().
		when().
		    get(url).
		 then().
		    assertThat().statusCode(statusCode);
	   
	}

	@Then("^veryfy total pages are (\\d+)$")
	public void veryfy_total_pages_are(int totalPages) throws Throwable {
		given().
		when().
		    get(url).
		then().
		    assertThat().
	        body("total_pages",equalTo(totalPages));

	}
	
	@Given("^send post request \"([^\"]*)\" and responce code should be (\\d+)$")
	public void send_post_request_and_responce_code_should_be(String url, int rescode, DataTable data) throws Throwable {
	    List <List<String>> lsdata = data.raw();
	    
	    HashMap<String,String> bd = new HashMap<String, String>();
	    
	                   for(int i=0;i<lsdata.size();i++){
	                	   
	                           bd.put(lsdata.get(i).get(0), lsdata.get(i).get(1));
	                   }
	                  
	                given()
	                		.contentType(ContentType.JSON)
	                .body(bd)
	                
	               	.when()
	               	.post(url)
	               	
	               	 .then()
	               	  .assertThat().statusCode(rescode).log().all();
	               	  
	               	  
	                
	                   
	}
	
	
	@Given("^send GET request \"([^\"]*)\" and get all user details in json body then validate it$")
	public void send_GET_request_and_get_all_user_details_in_json_body_then_validate_it(String url, DataTable data) throws Throwable {
		
		
		 List <List<String>> lsdata=data.raw();
		    
		 Response res = given()
				            .get(url)
				      
					    .then()
					.assertThat().log().all().extract().response();
		 
					 Users users = res.as(Users.class,ObjectMapperType.GSON);
					 
					 List<Datum> oblist  = users.getData();
					
				
				 
					 for(int i=0;i<oblist.size();i++){
						
						  assertEquals((int)oblist.get(i).getId(),Integer.parseInt(lsdata.get(i).get(0)));
					
					      assertEquals(oblist.get(i).getEmail(),lsdata.get(i).get(1) );
					      assertEquals(oblist.get(i).getFirstName(),lsdata.get(i).get(2) );
					      assertEquals(oblist.get(i).getLastName(),lsdata.get(i).get(3) );
					   
				 }
	}
	@Given("^GET employees \"([^\"]*)\"$")
	public void get_employees(String url, DataTable data) throws Throwable {
		List <List<String>> lsdata=data.raw();
		
Response response = given()
				  .header("Content-Type", "application/json")
				  .when()
				  .get(url)
				  .then().assertThat().statusCode(200).extract().response();
				    JsonPath x=new JsonPath(response.asString());
				    int count=x.get("data.size()");
				    for(int i=0;i<count;i++)
					   {
				    	assertEquals(lsdata.get(i).get(0),x.get("data["+i+"].first_name") );
				
					   }
					 
	}
	@Given("^Get updated employees details json file \"([^\"]*)\"$")
	public void get_updated_employees_details_json_file(String JsonFilePath) throws Throwable {
		 fis = new FileInputStream(new File(JsonFilePath));
	}

	@Then("^send PUT request \"([^\"]*)\" and validate it$")
	public void send_PUT_request_and_validate_it(String url) throws Throwable {
	   Response response = given()
	  .body(IOUtils.toString(fis, "UTF-8"))
	  .when()
	  .put(url)
	  .then().statusCode(200).log().all().extract().response();
	   System.err.println(response.asString());
	   
	}



}
