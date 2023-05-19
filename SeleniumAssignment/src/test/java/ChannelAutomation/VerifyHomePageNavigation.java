package ChannelAutomation;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Channel4.BaseClass.BaseClass;
import com.Channel4.Utils.Log;

public class VerifyHomePageNavigation extends BaseClass{
	
	
	@Test
	public void VerifyUserNavigationForHomapage() throws Exception
	{
	
		Log.startTestCase("VerifyHomePageNavigation");
		Log.info("Going to Click on Accept&Continue button");
		Hp.AcceptContinue();
		Log.info("Going to Click on Home Icon");
	    Hp.ClickHomeIcon();
	    Log.info("Going to Click SeachOPtion");
	    Hp.ClickSearchOption();
	    Log.info("Entering Values In SeachBox");
	    Hp.SendvalueToSearchBox();
	    Log.info("Clicking on the first listed Value");
	    Hp.ClickOnFirstOption();
	    Log.info("Clicking on the Play button");
	    Hp.ClickPlayButton();
	    Log.info("Clicking on the CLose Button");
	    Hp.ClickingCloseButton();
	    Log.info("Checking the Background color of sign in button");
	    String Color=Hp.ButtonBackground();
	    System.out.println(Color);
	    
	   // Assert.assertEquals("Colour","Color");
	    
	    
	}

}
