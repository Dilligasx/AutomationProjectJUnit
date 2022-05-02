package test;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import page.Techfios101Page;
import util.BrowserFactory;

public class Tests {

	static WebDriver driver;
	Techfios101Page techfiosPage;
	BrowserFactory browserFactory = new BrowserFactory();

	@Test
	public void clickOnToggleAllCheckboxAndValidate(){
		driver = BrowserFactory.init();

		techfiosPage = PageFactory.initElements(driver, Techfios101Page.class);

		techfiosPage.clickCheckBox();
		techfiosPage.validateCheckBox();
		techfiosPage.validateotherCheckBoxes();

		driver.quit();
	}
	
	@Test
	public void allListItemsShouldBeRemovedWithToggleAllButton() {
		driver = BrowserFactory.init();

		techfiosPage = PageFactory.initElements(driver, Techfios101Page.class);

		techfiosPage.clickCheckBox();
		techfiosPage.verifyListItemsAreChecked();
		techfiosPage.clickRemoveButton();
		techfiosPage.verifyListItemsAreRemoved();
		
		driver.quit();
	}

	@Test
	  public void removeSingleItemAndValidate() throws Exception {
		driver = BrowserFactory.init();

		techfiosPage = PageFactory.initElements(driver, Techfios101Page.class);

		techfiosPage.addItemToAddList();
		techfiosPage.validateAddedItemAndRemove();
		techfiosPage.validateItemHasBeenRemoved();
		driver.quit();
	}

	
}
