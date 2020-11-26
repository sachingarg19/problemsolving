/**
 * 
 */
package com.capitalone;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * @author Sachin Garg
 *
 */
public class OneTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			getAccountsInOrder(getAccountList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Account> getAccountList() throws ParseException{
		List<Account> listAccount = new ArrayList<Account>();
		listAccount.add(new Account("a", new Date("01/12/2012"),new BigDecimal(750).doubleValue(), new BigDecimal(1000).doubleValue()));
		listAccount.add(new Account("b", new Date("01/12/2011"),new BigDecimal(10000).doubleValue(), new BigDecimal(10000).doubleValue()));
		listAccount.add(new Account("c", new Date("09/12/2011"),new BigDecimal(1999).doubleValue(), new BigDecimal(4200).doubleValue()));
		return listAccount;

	}

	private static String DATE_STRING_FORMAT = "MM/dd/yyyy";

	private static final String OFFER_START_DATE = "07/12/2014";


	/**
	 * Takes a properly formatted string and converts to a java.util.date.
	 * 
	 * @param date the date to parse
	 * @return a date as java.util.Date
	 * @throws ParseException
	 */
	private static Date getDateFromString(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING_FORMAT, Locale.ENGLISH);
		return sdf.parse(date);
	}

	/**
	 * Primary implementation method.  Takes a list of accounts and returns the top 3 as a String array of names.
	 *
	 * @param accounts the list of accounts to evaluate.
	 * @return a String array of length X of the names of the top qualifying accounts.
	 * @throws ParseException 
	 */
	protected static String[] getAccountsInOrder(List<Account> listAccounts) throws ParseException {
		String[] scoreArr = new String[3];
		List<Account> accountList = new ArrayList<Account>();
		if(null != listAccounts){

		}
		if(listAccounts.isEmpty()){

		}

		for(Account account : listAccounts){
			double numberOfMonths = monthsBetween(new Date(OFFER_START_DATE),account.getAccountOpenDate());
			if(null != account){
				accountList.add(qualifier(numberOfMonths,account));
			} 			
		}
		double numberOfMonths = monthsBetween(new Date(OFFER_START_DATE),new Date("01/12/2012"));
		System.out.println("numberOfMonths: " + numberOfMonths);

		return scoreArr;
	}

	public static Account qualifier(double numberOfMonths, Account account) throws ParseException{
		List<Account> listAccount = new ArrayList<Account>();
		if(numberOfMonths > 24){
			if(account.getAccountCurrentBalance() >=0 && account.getAccountCurrentBalance() <= 10000){
				if(account.getAccountCreditLimit() >= 1000 && account.getAccountCreditLimit() <= 10000){
					double pertLimit =  (account.getAccountCreditLimit() - account.getAccountCurrentBalance())/account.getAccountCreditLimit();
					//System.out.println("Percentage Limit :: " + pertLimit);
					double score = numberOfMonths*pertLimit;
					if(score == 0.0){
						account.setAge(numberOfMonths);
						account.setScore(0);
					}else{
						account.setAge(numberOfMonths);
						account.setScore(score);
						listAccount.add(account);
					}
					System.out.println("Score :: " + score);
					//listAccount.add(account);	
					
				}
			}
		}

		for(Account acc : listAccount){
			System.out.println("List account : " + acc.getName());
		}
		
		return account;

	}

	private static double monthsBetween(final Date fromDate, final Date toDate) {
		int fromYear = fromDate.getYear();
		int fromMon = fromDate.getMonth();
		int fromDat = fromDate.getDate();

		int toYear = toDate.getYear();
		int toMon = toDate.getMonth();
		int toDat = toDate.getDate();

		Calendar date1 = new GregorianCalendar(fromYear, fromMon, fromDat);
		Calendar date2 = new GregorianCalendar(toYear, toMon, toDat);
		double monthsBetween = monthsBetween(date1, date2);
		return monthsBetween;
	}

	public static double monthsBetween(Calendar date1, Calendar date2){
		double monthsBetween = 0;
		//difference in month for years
		monthsBetween = (date1.get(Calendar.YEAR)-date2.get(Calendar.YEAR))*12;
		//difference in month for months
		monthsBetween += date1.get(Calendar.MONTH)-date2.get(Calendar.MONTH);
		//difference in month for days
		if(date1.get(Calendar.DAY_OF_MONTH)!=date1.getActualMaximum(Calendar.DAY_OF_MONTH)
				&& date1.get(Calendar.DAY_OF_MONTH)!=date1.getActualMaximum(Calendar.DAY_OF_MONTH) ){
			monthsBetween += ((date1.get(Calendar.DAY_OF_MONTH)-date2.get(Calendar.DAY_OF_MONTH))/31d);
		}
		return monthsBetween;
	}


}


