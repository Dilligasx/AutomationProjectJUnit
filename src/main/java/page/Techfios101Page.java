package page;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.hssf.record.WriteAccessRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
public class Techfios101Page {

	WebDriver driver;
	public Techfios101Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "allbox")
	WebElement TOGGLE_ALL_CHECKBOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='todo[]']")
	WebElement VARIABLE_CHECKBOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@type='text'][@name='data']")
	WebElement ADD_LIST_ITEM_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@type='submit'][@name='submit'][@value='Add']")
	WebElement ADD_LIST_ITEM_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "// li[1]/text()]")
	WebElement ADDED_ITEM_ELEMENT;
	@FindBy(how = How.XPATH, using = "//li[contains(text(), 'arshiaTest')]//input[@type='checkbox']")
	WebElement ARSHIA_TEST_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@type='submit'][@name='submit'][@value='Remove']")
	WebElement REMOVE_BUTTON_ELEMENT;
	

	
	public void clickCheckBox() {
		TOGGLE_ALL_CHECKBOX_ELEMENT.click();

	}

	public void clickRemoveButton() {
		REMOVE_BUTTON_ELEMENT.click();
	}

	public void validateCheckBox() {
		if (TOGGLE_ALL_CHECKBOX_ELEMENT.isSelected()) {
			System.out.println("The check box is selected!");
		} else if (!TOGGLE_ALL_CHECKBOX_ELEMENT.isSelected()) {
			System.out.println("The check box is not selected!");
		}
	}

	public void validateotherCheckBoxes() {

		List<WebElement> listItems = driver.findElements(By.xpath("//li/input[@type='checkbox']"));

		for (int i = 0; i <= listItems.size(); i++) {
			try {
				listItems.get(i).isSelected();
				if (i == listItems.size()) {
					System.out.println("All items were checked");
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Number " + i + " was the last item on the list");
			}
		}
	}

	public void addItemToAddList() {

		ADD_LIST_ITEM_ELEMENT.sendKeys("arshiaTest");
		ADD_LIST_ITEM_BUTTON_ELEMENT.click();
	}

	public void validateAddedItemAndRemove() {
//		String itemName = ADDED_ITEM_ELEMENT.getText();
//		String itemText = "arshiaTest";
		if (ARSHIA_TEST_BUTTON_ELEMENT.isDisplayed()) {
			ARSHIA_TEST_BUTTON_ELEMENT.click();
			REMOVE_BUTTON_ELEMENT.click();
		} else if (!ARSHIA_TEST_BUTTON_ELEMENT.isDisplayed()) {
			System.out.println("The item was not added to the list!");
		}

	}

	public void validateItemHasBeenRemoved() throws Exception {

		try {
			driver.findElements(By.xpath("ARSHIA_TEST_BUTTON_ELEMENT"));
		} catch (NoSuchElementException e) {
			System.out.println("The item was removed");
		}
	}

	public void verifyListItemsAreChecked() {
		List<WebElement> listItems = driver.findElements(By.xpath("//li/input[@type='checkbox']"));
		for (int i = 0; i <= listItems.size(); i++) {
			try {
				listItems.get(i).isSelected();
				if (i == listItems.size()) {
					System.out.println("All items were checked");
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Number " + i + " was the last item on the list");
			}
		}
	}

	public void verifyListItemsAreRemoved() {

		List<WebElement> listItems = driver.findElements(By.xpath("//li/input[@type='checkbox']"));
		if (listItems.size() == 0) {
			System.out.println("The items were successfully removed.");
		} else if (listItems.size() > 0) {
			System.out.println("The items were not successfully removed");
		}
	}
		

}
