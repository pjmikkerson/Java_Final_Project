package model;

/**  
* Peter Keeler - PmKeeler
* CIS171 25949/Wed 12:50
* Apr 26, 2024  
*/
public class Plywood {
	public static int estimatePlywood(int length, int width, int height) {
		int oneSheetsArea = 96 * 48;
		int sides = (width * height) * 2;
		int faces = (length * height) * 2;
		int totalArea = sides + faces;

		return (int) (Math.ceil((double) totalArea / oneSheetsArea));
	}

}
