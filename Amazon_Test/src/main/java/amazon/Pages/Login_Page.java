package amazon.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {

	private WebDriver driver;

	private By logo = By.xpath("//*[@id='nav-logo-sprites']");
	private By searchBox = By.xpath("//*[@id='twotabsearchtextbox']");
	private By amazonbasics = By.xpath("//div[contains(text(), 'amazonbasics')]");
	private By amazonbasics1 = By.xpath("//div[@class='left-pane-results-container']/div[1]");
	private By resultPage = By.xpath("//*[contains(text(), 'Results')]");
	private By amazonBrand = By.xpath("//span[contains(text(), 'Amazon Brands')]");
	private By clearLink = By.xpath("//*[@class='a-link-normal s-navigation-item s-navigation-clear-link']");
	private By adaptor = By.xpath("//*[contains(text(), 'Amazon Basics 20W One-Port USB')]");
	private By price = By.xpath("//span[contains(text(), '9.19')]");
    private By resultPrice =By.xpath("//span[@id='taxInclusiveMessage']/..");
    private By addToCartBtn= By.xpath("//*[@id='add-to-cart-button']");
    private By qtyBtn= By.xpath("//span[contains(text(), 'Quantity:')]");
    private By Cart_Logo= By.xpath("//div[@id='nav-cart-count-container']//span[contains(text(), '4')]");
    
	// Constructor
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods

	public boolean verify_Logo() {
		WebElement Logo = driver.findElement(logo);
		return Logo.isDisplayed();
	}

	public void searchAmazonbasics() {
		WebElement search = driver.findElement(searchBox);
		search.click();
		search.sendKeys("amazonbasics");
	}

	public void verify_Search_amazonbasics() {
		WebElement search = driver.findElement(searchBox);
		search.click();
		search.sendKeys("amazonbasics");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(amazonbasics));

		((WebElement) searchBox).sendKeys(Keys.DOWN);
		WebElement actualSearched = driver.findElement(amazonbasics1);
		String actually_searched_string = actualSearched.getText();
		System.out.println(actually_searched_string);

		/*
		 * //if(actualSearched.equals(amazonbasics)) assertEquals("amzaonbaics",
		 * actualSearched.equals(amazonbasics));
		 */
	}

	public void userClickOnAmazonbasics() {

		WebElement drpdwn = driver.findElement(amazonbasics1);
		drpdwn.sendKeys(Keys.ENTER);
	}

	public void verify_ResultPage() {
		WebElement result = driver.findElement(resultPage);
		System.out.println(result.getText());

	}

	public void clickOnFromOurBrand() {

		WebElement element = driver.findElement(amazonBrand);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(amazonBrand));
		element.click();
	}

	public boolean verify_Checkbox() {
		return driver.findElement(clearLink).isDisplayed();

	}

	public void searchProduct() {
		WebElement search = driver.findElement(searchBox);
		search.click();
		search.sendKeys(
				"20W One-Port USB-C Wall Charger with Power Delivery PD for Tablets & Phones (iPhone 15/14/13/12/11/X, iPad, Samsung, and more), non-PPS, 1.81 x 1.73 x 1.09 inches, White");
		search.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void verifyProduct() {
		WebElement ele = driver.findElement(adaptor);
		ele.getText();
	}

	public void click_Adaptor() {
		WebElement ele = driver.findElement(adaptor);
		ele.click();
	}

	public void get_Price() {
		WebElement actualprice = driver.findElement((By) price);
		actualprice.getText();
	}

	public void verifyPrice() {
		
		WebElement price= driver.findElement(resultPrice);
		price.getText();
	}
	
	public void selectRandomQty() {
		WebElement drpdwn= driver.findElement(qtyBtn);
		drpdwn.click();
		
		Select s = new Select(drpdwn);
		s.deselectByValue("4");
		
	}
	
	public void addToCartButton() {
		 WebElement addToCartbtn= driver.findElement(addToCartBtn);
		 addToCartbtn.click();
		}
	
	public void verify_Cart() {
		
		WebElement Logo= driver.findElement(Cart_Logo);
		Logo.getText();
		
	}
}
