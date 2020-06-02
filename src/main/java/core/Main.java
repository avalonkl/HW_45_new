package core;

import org.openqa.selenium.WebDriver;

public class Main {

	static String borwser = "firefox";
	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		final long start = System.currentTimeMillis();

		SignUp.validate(driver, "http://alex.academy/exe/signup/www/index.php");
		Common.quit();
		Confirmation.validate(driver, "http://alex.academy/exe/signup/www/confirmation.php");
		Common.quit();

		final long finish = System.currentTimeMillis();

		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}
