Feature: Amazon Login Page Module


Background:
 Given User enters "https://www.amazon.com/"
 Given User should be on Home_Page
     
  
  Scenario: Verify Amazonbasics is displayed in Search menu
  
    When User Search 'Amazonbasics' on the homepage search box
    Then Verify that results for "Amazonbasics" is displayed on the top of the page (below the menu bar)
    
      
  Scenario: Verify user shhould be on Result Page
  
  When User Search 'Amazonbasics' on the homepage search box
  When User clicks on checkbox Amazon Brands From Our Brands
  Then User should be again on Result Page
  
  Scenario: Verify user should be on result page of Amazon Brand
  When user clicks on Amazon Brand from Our Brand
  Then user should be on resultPage again
  
  Scenario: Verify serched product is diplayed and cross verify the price
  When User searches for "20W One-Port USB-C Wall Charger with Power Delivery PD for Tablets & Phones (iPhone 15/14/13/12/11/X, iPad, Samsung, and more), non-PPS, 1.81 x 1.73 x 1.09 inches, White"
  Then Verify and Check out the product "price" without clicking
  Then Click on the product & verify that the product page is displayed
  Then Verify that price on "price" and displayed price are matching.
  
  Scenario: Verify Qty and cart
  Given User select random quantity from ‘Qty’ dropdown
  When Click on 'Add to cart" button.
  Then Verify randomly selected item quantity added in cart
  Then Verify cart shows count as 'randomly added quantity.
