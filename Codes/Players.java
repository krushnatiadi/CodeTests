package files;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//Test that validates the Team has only 4 foreign Playes
public class Players {
	
	@Test(dataProvider="PlayersData")
	//(dataProvider="BooksData") 
	public void Players(String name, String country) {
		RestAssured.baseURI="Not Available";
		String response = given().log().all().header("Content-Type","application/json").body(payload.Players(name, country)).when().post("/Library/Players.php").then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
		JsonPath js= ReUsableMethods.rawToJson(response);
		String pName= js.get("name");
		System.out.println(pName);
		String pCountry = js.get("country");
		System.out.println(pCountry);
	}
	
		
	
	  @DataProvider(name="PlayersData")
	  public Object[][] getData(){
	  
	  return new Object[][] {{"Faf Du Plessis","South Africa"},{"Glenn Maxwell","Australia"},{"Wanindu Hasaranga","Srilanka"}, {"Josh Hazlewood", "Australia"}};
	  
	  }
	 

	

		
	}


