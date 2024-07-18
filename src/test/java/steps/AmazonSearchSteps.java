package steps;

import java.util.List;
import java.util.Map;

import base.PicoTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;

public class AmazonSearchSteps {
	
	private AmazonHomePage amazonHomePage;
	
	public AmazonSearchSteps(PicoTestContext picoTestContext) {
		amazonHomePage = picoTestContext.getPageObjectManager().getAmazonPageObject();
	}
	
	@Given("User should navigate to Amazon")
	public void userShouldNavigateToAmazon() {
		amazonHomePage.navigateURL();
	}
	
	@When("User search with multiple products in Amazon called")
	public void user_search_with_multiple_products_called(DataTable dataTable) {
		List<Map<String, String>> searchs = dataTable.asMaps();
		for (Map<String, String> search : searchs) {
			amazonHomePage.enterProductName(search.get("ProdName"));
			amazonHomePage.selectProductCatagory(search.get("ProdCat"));
			amazonHomePage.clickSearchButton();
		}
	}

	@Then("Validate the Amazon search result")
	public void validate_the_search_result() {
		String sResult = amazonHomePage.getsearchResult(); // 530,000
		System.out.println("Result is : " + sResult);

	}

}
