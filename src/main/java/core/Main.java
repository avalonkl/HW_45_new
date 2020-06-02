package core;

public class Main {

	static String borwser = "firefox";
//	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		final long start = System.currentTimeMillis();

		SignUp.validate("http://alex.academy/exe/signup/www/index.php");
		Confirmation.validate("http://alex.academy/exe/signup/www/confirmation.php");

		final long finish = System.currentTimeMillis();

		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}
