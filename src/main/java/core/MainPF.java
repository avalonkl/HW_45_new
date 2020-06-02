package core;

public class MainPF {

//	static String borwser = "firefox";
//	java -cp ./target/HW_45_new-1.0.jar -Dbrowser="chrome" core.MainPF

	static String browser;
	
	public static void main(String[] args) throws Exception {
		
		browser = System.getProperty("browser");
		
		final long start = System.currentTimeMillis();
		
		SignUpPF.validate("http://alex.academy/exe/signup/www/index.php");
		ConfirmationPF.validate("http://alex.academy/exe/signup/www/confirmation.php");
		
		final long finish = System.currentTimeMillis();
		
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}