package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "AddProductReview_Title")
	WebElement ReviewTitleTXT;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement ReviewTextTXT;
	
	@FindBy(id = "addproductrating_4")
	WebElement RatingGoodBTN;
	
	@FindBy(name = "add-review")
	WebElement SubmitReviewBTN;
	
	@FindBy (css = "div.result")
	public WebElement ReviewaddedSuccessfully;
	
	public void AddProductReview(String AddReviewTitleText, String AddReviewText)
	{
		ElementTextFill(ReviewTextTXT, AddReviewTitleText);
		ElementTextFill(ReviewTextTXT, AddReviewText);
		ClickButton(RatingGoodBTN);
		ClickButton(SubmitReviewBTN);
	}

}
