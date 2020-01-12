package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import utils.GenericMethods;

public class Application {
	
	@Test
	public void invalidLoginTest() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelDec14\\TestData.xlsx", "Sheet2");
		for(int i = 1;i<data.length;i++) {
			//Making changes to Application Class
			switch(data[i][3]) {
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowser();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navigateToAUT":
				Methods.navigateToApplication(data[i][6]);
				break;
			case "enterUserID":
				Methods.enterUserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				Methods.clickBtn(data[i][4],data[i][5]);
				break;
			case "verifyMsg":
				String actualMsg = Methods.verifyErrorMessage(data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApp":
				Methods.closeApplication();
				break;
			}
		}
	}

}
