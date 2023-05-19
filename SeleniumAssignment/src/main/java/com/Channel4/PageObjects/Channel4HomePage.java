package com.Channel4.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Channel4.BaseClass.BaseClass;

public class Channel4HomePage extends BaseClass {

	@FindBy(xpath = "//span[text()='Accept & Continue']")
	WebElement PopupAccept;

	@FindBy(xpath = "//a[@id='home-link']")
	WebElement HomeIcon;

	@FindBy(xpath = "//a[@aria-label='Search, click to expand']")
	WebElement SearchOption;

	@FindBy(xpath = "//input[@type='search']")
	WebElement SearchBox;

	@FindBy(xpath = "//ul/li[@tabindex='-1'][1]")
	WebElement ClickOnOption;

	@FindBy(xpath = "//span[contains(text(),'Sign in to play')]")
	WebElement PlayButton;

	@FindBy(xpath = "(//button)[3]")
	WebElement CloseButton;

	@FindBy(xpath = "(//div[@class='text-button__inner'])[1]")
	WebElement ButtonBackground;
	

	public Channel4HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}

	public void AcceptContinue() {

		try {
			action.JSClick(getDriver(), PopupAccept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean ClickHomeIcon() {
		return action.clickIn(HomeIcon, "Clicking On Home Icon");
	}

	public boolean ClickSearchOption()

	{
		action.explicitWait(getDriver(), SearchOption, Duration.ofSeconds(10));
		return action.clickIn(SearchOption, "Clicking on Search option");
	}

	public boolean SendvalueToSearchBox() {
		
		return action.type(SearchBox,"Made in Chelsea");
	}

	public boolean ClickOnFirstOption() {
		return action.clickIn(ClickOnOption,"Clicking On First Listed Value");
	}

	public boolean ClickPlayButton() {
		return action.clickIn(PlayButton,"clicking on play button");
	}

	public boolean ClickingCloseButton() {
		return action.clickIn(CloseButton,"clicking on close Button");
	}

	public String ButtonBackground() {
		return ButtonBackground.getCssValue("background-color");
	}

}
