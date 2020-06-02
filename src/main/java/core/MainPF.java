package core;

public class MainPF {

	static String borwser = "firefox";

	public static void main(String[] args) throws Exception {
		
		final long start = System.currentTimeMillis();
		
		SignUpPF.validate("http://alex.academy/exe/signup/www/index.php");
		ConfirmationPF.validate("http://alex.academy/exe/signup/www/confirmation.php");
		
		final long finish = System.currentTimeMillis();
		
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}