package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	
WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//element
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement ADD_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]") WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]") WebElement SAVE_BUTTON_ELEMENT;
	
	
	public void verifyAddCustomerPage(String addCustomer) {
		verifyElemnt(ADD_CUSTOMER_HEADER_ELEMENT, addCustomer, "Add Customer page not found.");
	}
	
	String insertedName;
	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandomNum(99999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}

	public void insertCompany(String company) {
		selectFromDropdown(COMPANY_ELEMENT, company);
	}
	

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNum(9999) + email);
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandomNum(9999));
	}
	
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	
	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	
	public void insertCountry(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
	
	
	//tbody/tr[1]/td[3]/a
	//tbody/tr[2]/td[3]/a
	//tbody/tr[3]/td[3]/a
	//tbody/tr[i]/td[3]/a
	//tbody/tr[1]/td[7]/a[2]
	//tbody/tr[2]/td[7]/a[2]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[7]/a[2]";
	
	public void validateInsertedNameAndDelete() throws InterruptedException {
		
		for(int i = 1; i <= 10; i++) {
			//driver.findElement(By.xpath("//tbody/tr[i]/td[3]/a"));
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(actualName);
//			Assert.assertEquals(actualName, insertedName, "Inserted name doesn't exist.");
			if(actualName.contains(insertedName)) {
				System.out.println("Inserted name exist.");
				Thread.sleep(1000);
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
			break;
		}
		
		
		
	}
	

}
