package tek.capstone.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{
	
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "search")
	public WebElement allDepartmentDropdown;
	
	@FindBy(id = "searchInput")
	public WebElement searchInputField;
	
	@FindBy(id = "searchBtn")
	public WebElement searchBttn;
	
	@FindBy(xpath = "//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement itemkasaoutdoorsmartplug;
	
	@FindBy(xpath = "//select[starts-with(@class,'product')]")
	public WebElement qtyDropdown;
	
	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBttn;
	
	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cartItemQty;
	
	@FindBy(id = "cartBtn")
	public WebElement cartBttn;
	
	@FindBy(id = "proceedBtn")
	public WebElement proceedToCheckoutBttn;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBttn;
	
	@FindBy(xpath = "//div[text()='Order Placed Successfully']")
	public WebElement orderPlacedSuccessfullyMssg;
	
	@FindBy(xpath = "//img[starts-with(@alt,'Apex Legends')]")
	public WebElement apexLegendsItem;
	
	//Cancel order
	@FindBy(id = "orderLink")
	public WebElement OrderLink;
	
	@FindBy(xpath = "//div[@class='order']//descendant::p[7]")
	public List<WebElement> listOfOrders;
	
	@FindBy(xpath = "//button[text()='Cancel The Order']")
	public List<WebElement> cancelOrderBttn;
	
	@FindBy(id = "reasonInput")
	public WebElement reasonForCancelation;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelSubmitBttn;
	
	@FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
	public WebElement orderCancelledSuccessMssg;
	
	// return order
	@FindBy (xpath="//p[@class='order__header-btn' and text()='Show Details']")
	public WebElement ItemsShowDetails;
	@FindBy(xpath= "//div[@class='order']")
	public WebElement firstOrderOnTheList;
	@FindBy(xpath = "//button[@id='returnBtn']")
	public WebElement returnItemsBttn;
//	@FindBy(id = "reasonInput")
//	public WebElement orderReturnReason;
	@FindBy(xpath = "dropOffInput")
	public WebElement DropOffBttn;
	@FindBy(id = "orderSubmitBtn")
	public WebElement returnOrderBttn;
	@FindBy(xpath = "//p[text()='Return was successfull']")
	public WebElement RetrunSucsesMassg;
	
	// review 
	@FindBy(id = "reviewBtn") public WebElement reviewBttn;
	@FindBy(id = "headlineInput") public WebElement reviewHeadlinInpute;
	@FindBy(id="descriptionInput") public WebElement reivewDescriptionInput;
	@FindBy(id = "reviewSubmitBtn") public WebElement reviewSubmitBttn;
	@FindBy(xpath="//div[text()='Your review was added successfully']") public WebElement reviewAddedSuccessMsg;
	
	
	

}
