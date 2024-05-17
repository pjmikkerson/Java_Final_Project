package model;

/**  
* Peter Keeler - PmKeeler
* CIS171 25949/Wed 12:50
* Apr 26, 2024  
*/
public class Measurement {

	public static int getInch(String length) {
		int feet = 0;
		int inches = 0;

		int feetIndex = length.indexOf("\'");
		int inchesIndex = length.indexOf("\"");

		if (feetIndex != -1) {
			feet = Integer.parseInt(length.substring(0, feetIndex));

		}

		if (inchesIndex != -1) {
			inches = Integer.parseInt(length.substring(feetIndex + 1, inchesIndex));
		}
		if (inchesIndex == -1 && feetIndex == -1) {
			throw new IllegalArgumentException("Invalid input: Enter a measurement in feet or inches");
		}

		return inches += feet * 12;
	}

	public static String getFeetAndInches(int inches) {
		return inches / 12 + "\'" + inches % 12 + "\"";
	}
	
	


}
