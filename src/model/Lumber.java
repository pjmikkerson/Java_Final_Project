package model;

/**
 * Peter Keeler - PmKeeler CIS171 25949/Wed 12:50 Apr 26, 2024
 */
public class Lumber {
	public static int getLinealLumber(int widthInches, int lengthInches) {
		return (widthInches / 12) * 4 + (lengthInches / 12) * 4;
	}

	public static int getStudCount(int side1, int side2) {
		if (side1 == 0 && side2 == 0) {
			return 0;
		}
		final int CORNER_STUDS = 4;
		int side1Studs = ((int) Math.ceil((double) side1 / 16) * 2) + 2;
		int side2Studs = ((int) Math.ceil((double) side2 / 16) * 2) + 2;

		return side1Studs + side2Studs + CORNER_STUDS;
	}
}
