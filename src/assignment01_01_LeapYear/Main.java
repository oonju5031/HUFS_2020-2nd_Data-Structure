package assignment01_01_LeapYear;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int getNumberOfDays(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return 366;
				} else {
					return 365;
				}
			} else {
				return 366;
			}
		} else {
			return 365;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		System.out.println(getNumberOfDays(year));
	}
	
}
