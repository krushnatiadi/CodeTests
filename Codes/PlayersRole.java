package files;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

//Test that Validates there is atleast one WK
public class PlayersRole {
	

		
		@Test(dataProvider="PlayersDatas")
		//(dataProvider="BooksData") 
		public void PlayersRole(String name, String role) {
			RestAssured.baseURI="Not Available";
			String response = given().log().all().header("Content-Type","application/json").body(payload.PlayersRole(name, role)).when().post("/Library/Players.php").then().log().all().assertThat().statusCode(200)
					.extract().response().asString();
			JsonPath js= ReUsableMethods.rawToJson(response);
			String pName= js.get("name");
			System.out.println(pName);
			String pRole = js.get("role");
			System.out.println(pRole);
		}
		
			
		
		  @DataProvider(name="PlayersDatas")
		  public Object[][] getData(){
		  
		  return new Object[][] {{"Dinesh Karthik","Wicket-keeper"}};
		  
		  }
		 

		

			
		}





