package amazon.StepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import amazon.Pages.Login_Page;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Login_Page_StepDefs extends Login_Page {

	public Login_Page_StepDefs(WebDriver driver) {
		super(driver);
	}

	private WebDriver driver;
	private Login_Page loginpage;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Amazon_Test/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("^User enters \"([^\"]*)\"$")
	public void user_enters(String arg1) throws Throwable {
		driver.get("https://www.amazon.com/");
	}

	@Given("^User should be on Home_Page$")
	public void user_should_be_on_Home_Page() throws Throwable {
		loginpage.verify_Logo();
	}

	@When("^User Search 'Amazonbasics' on the homepage search box$")
	public void user_Search_Amazonbasics_on_the_homepage_search_box() throws Throwable {
		loginpage.searchAmazonbasics();
	}

	@Then("^Verify that results for \"([^\"]*)\" is displayed on the top of the page \\(below the menu bar\\)$")
	public void verify_that_results_for_is_displayed_on_the_top_of_the_page_below_the_menu_bar(String arg1)
			throws Throwable {
		assertEquals("Amazonbasics", "loginpage.Verify_searchAmazonbasics()");
	}

	@When("^User clicks on checkbox Amazon Brands From Our Brands$")
	public void user_clicks_on_checkbox_Amazon_Brands_From_Our_Brands() throws Throwable {
		loginpage.userClickOnAmazonbasics();
	}

	@Then("^User should be again on Result Page$")
	public void user_should_be_again_on_Result_Page() throws Throwable {
		assertEquals("Results", "loginpage.verify_ResultPage()");
	}

	@When("^user clicks on Amazon Brand from Our Brand$")
	public void user_clicks_on_Amazon_Brand_from_Our_Brand() throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
	}

	@Then("^user should be on resultPage again$")
	public void user_should_be_on_resultPage_again() throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		assertTrue(loginpage.verify_Checkbox());
	}

	@When("^User searches for \"([^\"]*)\"$")
	public void user_searches_for(String adaptor) throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		loginpage.searchProduct();
	}

	@Then("^Verify and Check out the product \"([^\"]*)\" without clicking$")
	public void verify_and_Check_out_the_product_without_clicking(String arg1) throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		loginpage.searchProduct();
		loginpage.verifyProduct();
		assertEquals("loginpage.verifyProduct()", "Amazon Basics 20W One-Port USB");
	}

	@Then("^Click on the product & verify that the product page is displayed$")
	public void click_on_the_product_verify_that_the_product_page_is_displayed() throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		loginpage.searchProduct();
		loginpage.click_Adaptor();
	}

	@Then("^Verify that price on \"([^\"]*)\" and displayed price are matching\\.$")
	public void verify_that_price_on_and_displayed_price_are_matching(String arg1) throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		loginpage.searchProduct();
		loginpage.click_Adaptor();
		assertEquals("loginpage.get_Price()", "loginpage.verifyPrice()");
	}

	

	@Given("^User select random quantity from ‘Qty’ dropdown$")
	public void user_select_random_quantity_from_Qty_dropdown() throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		loginpage.searchProduct();
		loginpage.click_Adaptor();
		loginpage.selectRandomQty();
	}

	@When("^Click on 'Add to cart\" button\\.$")
	public void click_on_Add_to_cart_button() throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		loginpage.searchProduct();
		loginpage.click_Adaptor();
		loginpage.selectRandomQty();
		loginpage.addToCartButton();

	}

	@Then("^Verify randomly selected item quantity added in cart$")
	public void verify_randomly_selected_item_quantity_added_in_cart() throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		loginpage.searchProduct();
		loginpage.click_Adaptor();
		loginpage.selectRandomQty();
		loginpage.addToCartButton();
		assertEquals("loginpage.selectRandomQty()", "loginpage.verify_Cart()");
	}

	@Then("^Verify cart shows count as 'randomly added quantity\\.$")
	public void verify_cart_shows_count_as_randomly_added_quantity() throws Throwable {
		loginpage.searchAmazonbasics();
		loginpage.userClickOnAmazonbasics();
		loginpage.clickOnFromOurBrand();
		loginpage.searchProduct();
		loginpage.click_Adaptor();
		loginpage.selectRandomQty();
		loginpage.addToCartButton();
		assertEquals("loginpage.selectRandomQty()", "loginpage.verify_Cart()");
	}

}
