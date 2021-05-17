import java.io.*;
import java.util.*;

public class SolutionLibraryFine {

	public int calculateFine(String r_date, String d_date) {

		String[] date1 = r_date.split("[ ]");
		String[] date2 = d_date.split("[ ]");

		//System.out.println("D1: "+date1[0]+" M1: "+date1[1]+" Y1: "+date1[2]);
		//System.out.println("D2: "+date2[0]+" M2: "+date2[1]+" Y2: "+date2[2]);

		int d1 = Integer.parseInt(date1[0]);
		int m1 = Integer.parseInt(date1[1])-1;
		int y1 = Integer.parseInt(date1[2]);

		int d2 = Integer.parseInt(date2[0]);
		int m2 = Integer.parseInt(date2[1])-1;
		int y2 = Integer.parseInt(date2[2]);
		
		System.out.println(y1+" "+m1+" "+d1);
		System.out.println(y2+" "+m2+" "+d2);
		
		Calendar c1 = new GregorianCalendar(y1, m1, d1);
		Calendar c2 = new GregorianCalendar(y2, m2, d2);

		System.out.println(c1.get(Calendar.YEAR)+"\t\t\t"+c2.get(Calendar.YEAR));
		System.out.println(c1.get(Calendar.MONTH)+"\t\t\t"+c2.get(Calendar.MONTH));
		System.out.println(c1.get(Calendar.DATE)+"\t\t\t"+c2.get(Calendar.DATE));
		
		if (c1.get(Calendar.YEAR) > c2.get(Calendar.YEAR)) {
			return 10000;
		} else if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
			if (c1.get(Calendar.MONTH) > c2.get(Calendar.MONTH)) {
				int diff = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
				return 500 * diff;
			} else if (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)) {
				if (c1.get(Calendar.DATE) > c2.get(Calendar.DATE)) {
					int diff = c1.get(Calendar.DATE) - c2.get(Calendar.DATE);
					return 15 * diff;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		String returned_date = scan.nextLine();
		// scan.next();
		String due_date = scan.nextLine();
		scan.close();

		SolutionLibraryFine s = new SolutionLibraryFine();
		int fine = s.calculateFine(returned_date, due_date);
		System.out.println(fine);
		// System.out.println("Returned date:"+returned_date);
		// System.out.println("Due date:"+due_date);
	}
}
