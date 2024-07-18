package steps;

import java.util.List;
import java.util.Map;

import base.PicoTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EbayHomePage;

public class EbaySearchSteps {
	
	private EbayHomePage ebayHomePage;
	
	public EbaySearchSteps(PicoTestContext picoTestContext) {
		ebayHomePage = picoTestContext.getPageObjectManager().getEbayPageObject();
	}
	
	@Given("User should navigate to Ebay Home page")
	public void navigate_to_ebay_page() {
		ebayHomePage.navigateToEbay();
	}


	@When("^Enter the multiple product name as ([^1-9]*) and multiple product catagory as ([^1-9]*)$")
	public void enter_the_muultiple_product_name_as_java_and_multiple_product_catagory_as_books(String prodName, String prodCatagory) {
		ebayHomePage.enterSearchText(prodName);
		ebayHomePage.selectProdCatagory(prodCatagory);

	}
	
	@When("Enter the product name and Select the catagory from the below data table as map")
	public void enter_the_product_name_and_select_the_catagory_from_the_below_data_table_as_map(DataTable dataTable) {
	    List<Map<String, String>> asMaps = dataTable.asMaps();
	    for (Map<String, String> map : asMaps) {
	    	String prodName = map.get("ProdutName");
	    	String prodCat = map.get("ProductCatagory");
	    	ebayHomePage.enterSearchText(prodName);
	    	ebayHomePage.selectProdCatagory(prodCat);		
		}
	}

	@When("click on search button")
	public void click_on_search_button() {
		ebayHomePage.clickOnSearchButton();
	}

	@Then("Validate the search result")
	public void user_should_able_to_see_the_search_results() {
		String resultText = ebayHomePage.getSearchResult();
		System.out.println("Result Text is : "+resultText);
	}

}
