package core;

public class SignUpPF {

	public static void validate(String url) throws Exception {
		
		CommonPF.open(MainPF.browser, url);
		
		CommonPF.pageValidation("01.01 Element [Quotes (dynamic)]", CommonPF.el_01);
		CommonPF.pageValidation("02.02 Element [Current Location]", CommonPF.el_02);
		CommonPF.pageValidation("03.03 Element [Weather Icon]", CommonPF.el_03);
		CommonPF.pageValidation("04.04 Element [Quotes (dynamic)]", CommonPF.el_04);
		CommonPF.pageValidation("05.05 Element [Title]", CommonPF.el_05);

		CommonPF.pageValidation("06.06 Element [First Name (label)]", CommonPF.el_06);
		CommonPF.pageValidation("07.07 Element [First Name (field)]", CommonPF.el_07);
		CommonPF.pageValidation("08.08 Element [Last Name (label)]", CommonPF.el_08);
		CommonPF.pageValidation("09.09 Element [Last Name (field)]", CommonPF.el_09);
		CommonPF.pageValidation("10.10 Element [Email (label)]", CommonPF.el_10);

		CommonPF.pageValidation("11.11 Element [Email (filed)]", CommonPF.el_11);
		CommonPF.pageValidation("12.12 Element [Phone (label)]", CommonPF.el_12);
		CommonPF.pageValidation("13.13 Element [Phone (field)]", CommonPF.el_13);
		CommonPF.pageValidation("14.14 Element [Genre (label)]", CommonPF.el_14);
		CommonPF.pageValidation("15.15 Element [Male (label)]", CommonPF.el_15);

		CommonPF.pageValidation("16.16 Element [Male (radio button)]", CommonPF.el_16);
		CommonPF.pageValidation("17.17 Element [Female (label)]", CommonPF.el_17);
		CommonPF.pageValidation("18.18 Element [Female (radio button)]", CommonPF.el_18);
		CommonPF.pageValidation("19.19 Element [State (label)]", CommonPF.el_19);
		CommonPF.pageValidation("20.20 Element [State (drop-down)]", CommonPF.el_20);

		CommonPF.pageValidation("21.21 Element [State California (item)]", CommonPF.el_21);
		CommonPF.pageValidation("22.22 Element [Terms (label)]", CommonPF.el_22);
		CommonPF.pageValidation("23.23 Element [Terms (checkbox)]", CommonPF.el_23);
		CommonPF.pageValidation("24.24 Element [Image (facebook)]", CommonPF.el_24);
		CommonPF.pageValidation("25.25 Element [Image (twitter)]", CommonPF.el_25);

		CommonPF.pageValidation("26.26 Element [Image (flickr)]", CommonPF.el_26);
		CommonPF.pageValidation("27.27 Element [Image (youtube)]", CommonPF.el_27);
		CommonPF.pageValidation("28.28 Element [Reset (button)]", CommonPF.el_28);
		CommonPF.pageValidation("29.29 Element [Submit (button)]", CommonPF.el_29);
		CommonPF.pageValidation("30.30 Element [Timestamp (dynamic)]", CommonPF.el_30);

		CommonPF.pageValidation("31.31 Element [Copyright (dynamic)]", CommonPF.el_31);
		CommonPF.pageValidation("32.32 Element [OS & Browser (dynamic)]", CommonPF.el_32);
		CommonPF.pageValidation("33.33 Element [Error Line]", CommonPF.el_33);
		CommonPF.pageValidation("34.34 Element [First Name Error]", CommonPF.el_34);
		CommonPF.pageValidation("35.35 Element [Last Name Error]", CommonPF.el_35);

		CommonPF.pageValidation("36.36 Element [Email Error]", CommonPF.el_36);
		CommonPF.pageValidation("37.37 Element [Phone Error]", CommonPF.el_37);
		CommonPF.pageValidation("38.38 Element [First Name Error (img)]", CommonPF.el_38);
		CommonPF.pageValidation("39.39 Element [Last Name Error (img)]", CommonPF.el_39);
		CommonPF.pageValidation("40.40 Element [Email Error (img)]", CommonPF.el_40);
		CommonPF.pageValidation("41.41 Element [Phone Error (img)]", CommonPF.el_41);
		
		CommonPF.quit();
	}
}