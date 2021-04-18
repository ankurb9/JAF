package org.web.browser.test;

import java.util.List;
import java.util.Scanner;

import org.enums.collection.LType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import jaf.driver.utilities.JAFBase;
import jaf.driver.utilities.WDUtils;

public class DataEntryJob extends JAFBase{

	@Test
	public void dataEntry() throws InterruptedException {
		try {

			
			  WDUtils.getwElement(LType.name, "username").sendKeys("prad1584");
			  WDUtils.getwElement(LType.name, "password").sendKeys("pradnya2020");
			  WDUtils.getwElement(LType.name, "Submit").click();
			  WDUtils.getwElement(LType.xpath, "//*[text()='Data Entry Tasks']").click();
			 

			Scanner sc=new Scanner(System.in);
			System.err.println("Click Enter to continue:----");
			String a= sc.nextLine();

			List<WebElement> fieldSet = WDUtils.getwElements(LType.xpath, "//fieldset");
			List<WebElement> fields = WDUtils.getwElements(LType.xpath, "//fieldset/table/tbody/tr");

			for(int i=1;i<=fieldSet.size();i++) {
				for(int j=1;j<=(fields.size()/fieldSet.size()) ; j++) {


					String first = WDUtils.getwElement(LType.xpath, "//fieldset[@class='stepfrm"+i+"']/table/tbody/tr["+j+"]/td[1]").getText().replace(j+" ", "");
					//System.err.println(first);
					WDUtils.getwElement(LType.xpath, "//fieldset[@class='stepfrm"+i+"']/div[5]/table/tbody/tr["+j+"]/td[2]/input").sendKeys(first);

					String sec = WDUtils.getwElement(LType.xpath, "//fieldset[@class='stepfrm"+i+"']/table/tbody/tr["+j+"]/td[2]").getText();
					WDUtils.getwElement(LType.xpath, "//fieldset[@class='stepfrm"+i+"']/div[5]/table/tbody/tr["+j+"]/td[3]/input").sendKeys(sec);

				}

				if(i==fieldSet.size())
					WDUtils.getwElement(LType.xpath, "//*[@value='Submit']").click();
				else
					WDUtils.getwElement(LType.xpath, "//*[@value='Next']").click();
				Thread.sleep(1000);
			}

			WDUtils.getwElement(LType.linkText, "Continue").click();
			System.err.println("Completed");
		}catch(Exception e){
			e.printStackTrace();

		}

	}

}
