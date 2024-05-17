package driver;
import java.util.Scanner;
import model.*;

/**
 * Peter Keeler - PmKeeler CIS171 25949/Wed 12:50 Feb 21, 2024
 */
public class ShedMaterialCalculatorMidterm {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String answer;
		do {
			System.out.println("Enter the dimensions for your desired shed.\n"
					+ "This program provides an estimate for framing materials.");

			System.out.print("Wall height(Ft\'In\"):");
			String heightStr = in.next();
			System.out.print("Shed length(Ft\'In\"):");
			String lengthStr = in.next();
			System.out.print("Shed Width(Ft\'In\"):");
			String widthStr = in.next();

			int height = Measurement.getInch(heightStr);
			int length = Measurement.getInch(lengthStr);
			int width = Measurement.getInch(widthStr);

			int studCount = Lumber.getStudCount(length, width);
			int sheetsOfPlywood = Plywood.estimatePlywood(length, width, height);

			System.out.println("Sheets of Plywood:" + sheetsOfPlywood);
			System.out.println("Stud Count:" + studCount);

			int linealInches = Lumber.getLinealLumber(width, length);
			String linealLumber = Measurement.getFeetAndInches(linealInches);
			System.out.println("You will need:" + linealLumber + " of lineal lumber.");

			System.out.print("Would you like to calculate again? ");
			answer = in.next().toLowerCase();

		} while (answer.equals("yes"));
		in.close();
	}

}
