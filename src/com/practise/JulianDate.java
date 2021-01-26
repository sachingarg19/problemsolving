package com.practise;

public class JulianDate {

	public static int JSach= 15 + 31*(10+12*1);
	public static double HALFSECOND = 0.5;

	public static double toJulian(int[] ymd) {
		int year=ymd[0];
		int month=ymd[1]; // jan=1, feb=2,...
		int day=ymd[2];
		int julianYear = year;
		if (year < 0) julianYear++;
		int julianMonth = month;
		if (month > 2) {
			julianMonth++;
		}
		else {
			julianYear--;
			julianMonth += 13;
		}

		double julian = (java.lang.Math.floor(365.25 * julianYear)
				+ java.lang.Math.floor(30.6001*julianMonth) + day + 1);
		if (day + 31 * (month + 12 * year) >= JSach) {
			// change over to Gregorian calendar
			int ja = (int)(0.01 * julianYear);
			julian += 2 - ja + (0.25 * ja);
		}
		return java.lang.Math.floor(julian);
	}

	public static int[] fromJulian(double injulian) {
		int jalpha,ja,jb,jc,jd,je,year,month,day;
		double julian = injulian + HALFSECOND / 86400.0;
		ja = (int) julian;
		if (ja>= JSach) {
			jalpha = (int) (((ja - 1867216) - 0.25) / 36524.25);
			ja = ja + 1 + jalpha - jalpha / 4;
		}

		jb = ja + 1524;
		jc = (int) (6680.0 + ((jb - 2439870) - 122.1) / 365.25);
		jd = 365 * jc + jc / 4;
		je = (int) ((jb - jd) / 30.6001);
		day = jb - jd - (int) (30.6001 * je);
		month = je - 1;
		if (month > 12) month = month - 12;
		year = jc - 4715;
		if (month > 2) year--;
		if (year <= 0) year--;

		return new int[] {year, month, day};
	}

	public static void main(String args[]) {
		
		System.out.println("Julian date : "
				+ toJulian( new int[] {2011, 12, 31 } ));
		
		int results[] = fromJulian(toJulian(new int[] {2011, 12, 31 }));
		System.out.println
		("... back to calendar : " + results[0] + " "
				+ results[1] + " " + results[2]);

		double date1 = toJulian(new int[]{2011,1,1});
		double date2 = toJulian(new int[]{2011,1,31});
		System.out.println("Between 2011-01-01 and 2011-01-31 : "
				+ (date2 - date1) + " days");
	}
}