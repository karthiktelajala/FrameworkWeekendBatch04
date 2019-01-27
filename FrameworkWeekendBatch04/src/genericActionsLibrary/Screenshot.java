package genericActionsLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshot 
{
	public static void captureScreeshot(WebDriver driver, String screenshotName)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver; 
			File imgSrc1 = ts.getScreenshotAs(OutputType.FILE);
			Files.copy(imgSrc1, new File("./Screenshots/"+screenshotName+".jpeg"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
