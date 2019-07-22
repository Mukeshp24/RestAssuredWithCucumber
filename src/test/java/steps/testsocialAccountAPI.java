package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.List;

import com.model.ck.Datum;
import com.model.ck.Users;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class testsocialAccountAPI {
	String url = "";
	ActiontestsocialAPI act = new ActiontestsocialAPI();

	@Given("^send GET request \"([^\"]*)\"$")
	public void send_GET_request(String url) throws Throwable {
		this.url = url;

		act.send_Get_request(url);

	}

	@Then("^then responce code should be (\\d+)$")
	public void then_responce_code_should_be(int arg1) throws Throwable {

		act.then_responce_code_should_be(url);
	}

	@Then("^veryfy total pages are (\\d+)$")
	public void veryfy_total_pages_are(int arg1) throws Throwable {
		act.veryfy_total_pages_are(url);

	}
	
	@Given("^send post request \"([^\"]*)\" and responce code should be (\\d+)$")
	public void send_post_request_and_responce_code_should_be(String url, int rescode, DataTable data) throws Throwable {
	    List <List<String>> lsdata=data.raw();
	    
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
	
	@SuppressWarnings("deprecation")
	@Given("^send GET request \"([^\"]*)\" and get all user details in json body then validate it$")
	public void send_GET_request_and_get_all_user_details_in_json_body_then_validate_it(String url, DataTable data) throws Throwable {
		
		
		 List <List<String>> lsdata=data.raw();
		    
		 Response res= given()
				      .get(url)
					  .then()
					.assertThat().log().all().extract().response();
					 Users users = res.as(Users.class,ObjectMapperType.GSON);
					 
					 List< Datum> oblist  = users.getData();
					
				
				 
					 for(int i=0;i<oblist.size();i++){
					
					Assert.assertEquals((int)oblist.get(i).getId(),Integer.parseInt(lsdata.get(i).get(0)));
					
					Assert.assertEquals(oblist.get(i).getEmail(),lsdata.get(i).get(1) );
					Assert.assertEquals(oblist.get(i).getFirstName(),lsdata.get(i).get(2) );
					Assert.assertEquals(oblist.get(i).getLastName(),lsdata.get(i).get(3) );
					 
				 }
	}


}
