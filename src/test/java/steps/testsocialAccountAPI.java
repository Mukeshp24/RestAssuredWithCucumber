package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

public class testsocialAccountAPI {
	String url="";
	ActiontestsocialAPI act = new ActiontestsocialAPI();
	@Given("^send GET request \"([^\"]*)\"$")
	public void send_GET_request(String url) throws Throwable {
		this.url =url;
		
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
}
