package core;

import org.openqa.selenium.WebDriver;

public class ConfirmationPF {

	public static void validate(WebDriver driver, String url) throws Exception {

		CommonPF.open(Main.borwser, url);

		CommonPF.pageValidation("42.05 Element [Title]", CommonPF.el_05);
		CommonPF.pageValidation("43.06 Element [First Name (label)]", CommonPF.el_06);
		CommonPF.pageValidation("44.07 Element [First Name (field)]", CommonPF.el_07);
		CommonPF.pageValidation("45.08 Element [Last Name (label)]", CommonPF.el_08);
		CommonPF.pageValidation("46.09 Element [Last Name (field)]", CommonPF.el_09);

		CommonPF.pageValidation("47.10 Element [Email (label)]", CommonPF.el_10);
		CommonPF.pageValidation("48.11 Element [Email (filed)]", CommonPF.el_11);
		CommonPF.pageValidation("49.12 Element [Phone (label)]", CommonPF.el_12);
		CommonPF.pageValidation("50.13 Element [Phone (field)]", CommonPF.el_13);
		CommonPF.pageValidation("51.14 Element [Genre (label)]", CommonPF.el_14);

		CommonPF.pageValidation("52.42 Element [Genre (field)]", CommonPF.el_42);
		CommonPF.pageValidation("53.43 Element [Back (button)]", CommonPF.el_43);
	}
}