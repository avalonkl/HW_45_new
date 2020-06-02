package core;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Common {

	static WebDriver driver;

	static By el_01 = By.id("id_quotes");
	static By el_02 = By.id("id_current_location");
	static By el_03 = By.id("id_weather_icon");
	static By el_04 = By.id("id_temperature");
	static By el_05 = By.id("id_f_title");
	static By el_06 = By.id("id_f_label_fn");
	static By el_07 = By.id("id_fname");
	static By el_08 = By.id("id_f_label_ln");
	static By el_09 = By.id("id_lname");
	static By el_10 = By.id("id_f_label_ea");
	static By el_11 = By.id("id_email");
	static By el_12 = By.id("id_f_label_pn");
	static By el_13 = By.id("id_phone");
	static By el_14 = By.id("id_rb_label_g");
	static By el_15 = By.id("id_rb_label_m");
	static By el_16 = By.id("id_gender_male");
	static By el_17 = By.id("id_rb_label_f");
	static By el_18 = By.id("id_gender_female");
	static By el_19 = By.id("id_f_label_s");
	static By el_20 = By.id("id_state");
	static By el_21 = By.xpath("//*[@id='id_state']/option[6]");
	static By el_22 = By.id("id_cb_label_t");
	static By el_23 = By.id("id_terms");
	static By el_24 = By.id("id_img_facebook");
	static By el_25 = By.id("id_img_twitter");
	static By el_26 = By.id("id_img_flickr");
	static By el_27 = By.id("id_img_youtube");
	static By el_28 = By.id("id_reset_button");
	static By el_29 = By.id("id_submit_button");
	static By el_30 = By.id("timestamp");
	static By el_31 = By.id("copyright");
	static By el_32 = By.id("os_browser");
	static By el_33 = By.id("ErrorLine");
	static By el_34 = By.id("fname_error");
	static By el_35 = By.id("lname_error");
	static By el_36 = By.id("email_error");
	static By el_37 = By.id("phone_error");
	static By el_38 = By.xpath("//*[@id='fname_error']/img");
	static By el_39 = By.xpath("//*[@id='lname_error']/img");
	static By el_40 = By.xpath("//*[@id='email_error']/img");
	static By el_41 = By.xpath("//*[@id='phone_error']/img");
	static By el_42 = By.id("id_gender");
	static By el_43 = By.id("id_back_button");

	static void getWebDriver(String browser) throws IOException {
		Logger.getLogger("").setLevel(Level.OFF);

		String driverPath = "";

		switch (browser.toLowerCase()) {

		case "chrome": {
			if (getOS().toUpperCase().contains("MAC") || getOS().toUpperCase().contains("LINUX"))
				driverPath = "/usr/local/bin/chromedriver";
			else if (getOS().toUpperCase().contains("WINDOWS"))
				driverPath = "c:\\windows\\chromedriver.exe";
			else
				throw new IllegalArgumentException("Browser dosn't exist for this OS");
			System.setProperty("webdriver.chrome.driver", driverPath);
			System.setProperty("webdriver.chrome.silentOutput", "true"); // Chrome
			ChromeOptions option = new ChromeOptions(); // Chrome
			option.addArguments("disable-infobars"); // Chrome
			option.addArguments("--disable-notifications"); // Chrome

			driver = new ChromeDriver();
			break;
		}

		case "edge": {
			if (getOS().toUpperCase().contains("MAC"))
				driverPath = "/usr/local/bin/msedgedriver.sh";
			else if (getOS().toUpperCase().contains("WINDOWS"))
				driverPath = "c:\\windows\\msedgedriver.exe";
			else
				throw new IllegalArgumentException("Browser dosn't exist for this OS");
			System.setProperty("webdriver.edge.driver", driverPath);

			driver = new EdgeDriver();
			break;
		}

		case "firefox": {
			if (getOS().toUpperCase().contains("MAC") || getOS().toUpperCase().contains("LINUX"))
				driverPath = "/usr/local/bin/geckodriver.sh";
			else if (getOS().toUpperCase().contains("WINDOWS"))
				driverPath = "c:\\windows\\geckodriver.exe";
			else
				throw new IllegalArgumentException("Browser dosn't exist for this OS");
			System.setProperty("webdriver.gecko.driver", driverPath);

			driver = new FirefoxDriver();
			break;
		}

		case "safari": {
			if (!getOS().toUpperCase().contains("MAC"))
				throw new IllegalArgumentException("Browser dosn't exist for this OS");

			driver = new SafariDriver();
			break;
		}

		default:
			throw new WebDriverException("Unknown WebDriver");

		}
	}

	static void open(String browser, String url) throws IOException {
		getWebDriver(browser);
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.get(url);
	}

	static boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElements(by).size() == 1;
	}

	static String getOS() {
		return System.getProperty("os.name").toUpperCase();
	}

	static String getBrowser() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName();
		return browserName.substring(0, 1).toUpperCase() + browserName.substring(1);
	}

	static String getFileName() {
		String file = driver.getCurrentUrl().toString().trim();
		return file.substring(file.lastIndexOf('/') + 1);
	}

	static void quit() throws IOException {
		driver.quit();
	}
	
	static void pageValidation(String test_case, By by) { 
		System.out.println(test_case + (isElementPresent(by) ? " - exists" : " -not exist") + "; Page [" + getFileName() + "]");
	}

}
