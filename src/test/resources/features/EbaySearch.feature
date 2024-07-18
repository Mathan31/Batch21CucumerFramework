@Complete
Feature: Ebay Product Search

  Background: Invoking browser and navigating to Ebay

    Given User should navigate to Ebay Home page

	@Smoke
  Scenario Outline: Ebay product search with multiple values are hard coding from feature file using scenario outline
 
  When Enter the multiple product name as <ProductName> and multiple product catagory as <ProductCatagory>
  And click on search button
  Then Validate the search result
  #And Close browser
  
  Examples:
  | ProductName | ProductCatagory           |
  | Java        | Books                     |
  | Samsung     | Cell Phones & Accessories |
 
  @Regression
  Scenario: Ebay product search values are hard coding from feature file using data table map
    When Enter the product name and Select the catagory from the below data table as map
      | ProdutName | ProductCatagory           |
      | Cricket    | Books                     |
      | Lenovo     | Cell Phones & Accessories |
    And click on search button
    Then Validate the search result
    #And Close browser
