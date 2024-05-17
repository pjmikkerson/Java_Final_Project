package model;

/**  
* Peter Keeler - PmKeeler
* CIS171 25949/Wed 12:50
* Apr 26, 2024  
*/
public class Siding {
	public static double estimateSiding(int length, int width, int height) {
		final double SQUARE = 10.0;
	    final double INCHES_PER_SQUARE_FOOT = 144.0;
	    
	    
		
	    int totalInches = (width * height * 2) + (length * height * 2);
		double totalFt = totalInches/INCHES_PER_SQUARE_FOOT;
		
		double squares = Math.ceil(totalFt / SQUARE);
	    
	    return squares;
		
	}

}
