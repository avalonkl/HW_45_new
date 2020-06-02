package core;

import org.openqa.selenium.WebDriver;

public class MainPF {

	static String borwser = "firefox";
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		final long start = System.currentTimeMillis();
		
		SignUpPF.validate(driver, "http://alex.academy/exe/signup/www/index.php");
		CommonPF.quit();
		ConfirmationPF.validate(driver, "http://alex.academy/exe/signup/www/confirmation.php");
		CommonPF.quit();
		
		final long finish = System.currentTimeMillis();
		
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}