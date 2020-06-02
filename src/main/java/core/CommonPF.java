package core;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPF {

	static WebDriver driver;

	@FindBy(id="id_quotes") @CacheLookup static WebElement el_01;
	@FindBy(id="id_current_location") @CacheLookup static WebElement el_02;
	@FindBy(id="id_weather_icon") @CacheLookup static WebElement el_03;
	@FindBy(id="id_temperature") @CacheLookup static WebElement el_04;
	@FindBy(id="id_f_title") @CacheLookup static WebElement el_05;
	@FindBy(id="id_f_label_fn") @CacheLookup static WebElement el_06;
	@FindBy(id="id_fname") @CacheLookup static WebElement el_07;
	@FindBy(id="id_f_label_ln") @CacheLookup static WebElement el_08;
	@FindBy(id="id_lname") @CacheLookup static WebElement el_09;
	@FindBy(id="id_f_label_ea") @CacheLookup static WebElement el_10;
	@FindBy(id="id_email") @CacheLookup static WebElement el_11;
	@FindBy(id="id_f_label_pn") @CacheLookup static WebElement el_12;
	@FindBy(id="id_phone") @CacheLookup static WebElement el_13;
	@FindBy(id="id_rb_label_g") @CacheLookup static WebElement el_14;
	@FindBy(id="id_rb_label_m") @CacheLookup static WebElement el_15;
	@FindBy(id="id_gender_male") @CacheLookup static WebElement el_16;
	@FindBy(id="id_rb_label_f") @CacheLookup static WebElement el_17;
	@FindBy(id="id_gender_female") @CacheLookup static WebElement el_18;
	@FindBy(id="id_f_label_s") @CacheLookup static WebElement el_19;
	@FindBy(id="id_state") @CacheLookup static WebElement el_20;
	@FindBy(xpath="//*[@id='id_state']/option[6]") @CacheLookup static WebElement el_21;
	@FindBy(id="id_cb_label_t") @CacheLookup static WebElement el_22;
	@FindBy(id="id_terms") @CacheLookup static WebElement el_23;
	@FindBy(id="id_img_facebook") @CacheLookup static WebElement el_24;
	@FindBy(id="id_img_twitter") @CacheLookup static WebElement el_25;
	@FindBy(id="id_img_flickr") @CacheLookup static WebElement el_26;
	@FindBy(id="id_img_youtube") @CacheLookup static WebElement el_27;
	@FindBy(id="id_reset_button") @CacheLookup static WebElement el_28;
	@FindBy(id="id_submit_button") @CacheLookup static WebElement el_29;
	@FindBy(id="timestamp") @CacheLookup static WebElement el_30;
	@FindBy(id="copyright") @CacheLookup static WebElement el_31;
	@FindBy(id="os_browser") @CacheLookup static WebElement el_32;
	@FindBy(id="ErrorLine") @CacheLookup static WebElement el_33;
	@FindBy(id="fname_error") @CacheLookup static WebElement el_34;
	@FindBy(id="lname_error") @CacheLookup static WebElement el_35;
	@FindBy(id="email_error") @CacheLookup static WebElement el_36;
	@FindBy(id="phone_error") @CacheLookup static WebElement el_37;
	@FindBy(xpath="//*[@id='fname_error']/img") @CacheLookup static WebElement el_38;
	@FindBy(xpath="//*[@id='lname_error']/img") @CacheLookup static WebElement el_39;
	@FindBy(xpath="//*[@id='email_error']/img") @CacheLookup static WebElement el_40;
	@FindBy(xpath="//*[@id='phone_error']/img") @CacheLookup static WebElement el_41;
	@FindBy(id="id_gender") @CacheLookup static WebElement el_42;
	@FindBy(id="id_back_button") @CacheLookup static WebElement el_43;

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
		PageFactory.initElements(driver, CommonPF.class);
		driver.get(url);
	}

	static boolean isElementPresent(WebElement element) {
		return element.getTagName() != null;
	}

	static String getOS() {
		return System.getProperty("os.name").toUpperCase();
	}

	static String getFileName() {
		String file = driver.getCurrentUrl().toString().trim();
		return file.substring(file.lastIndexOf('/') + 1);
	}

	static void quit() throws IOException {
		driver.quit();
	}
	
	static void pageValidation(String test_case, WebElement element) throws Exception {
		highlightElement(element);
		System.out.println(test_case + (isElementPresent(element) ? " - exists" : " -not exist") + "; Page [" + getFileName() + "]");
		unhighlightElement(element);
	}
	
	static void highlightElement(WebElement element) throws Exception{
		((RemoteWebDriver) driver).executeScript("arguments[0].setAttribute('style','border: solid 3px red');", element); 
		Thread.sleep(50);
	}
	
	static void unhighlightElement(WebElement element) throws Exception{ 
		((RemoteWebDriver) driver).executeScript("arguments[0].setAttribute('style','border: solid 0px red');", element);
	}

}
