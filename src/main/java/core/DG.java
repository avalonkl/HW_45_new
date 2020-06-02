package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DG {

	public static void main(String[] args) throws Exception {
		String cvsLine = "";
		String[] a = null;
		BufferedReader br = new BufferedReader(new FileReader("input.csv"));
		while ((cvsLine = br.readLine()) != null) {
			a = cvsLine.split(",");
			System.out.println("@FindBy(" + a[1] + "=" + a[2] + ") @CacheLookup static WebElement " + a[0] + ";");
		}
		br.close();
	}

}
