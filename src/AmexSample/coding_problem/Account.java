/**
 * 
 */
package com.capitalone;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

 class Account implements Comparator<Account>, Comparable<Account>{
	private String name;

    private Date accountOpenDate;

    private Double accountCurrentBalance;

    private Double accountCreditLimit;

    private int ageInMonthsAtTimeOfOffer;

    private Double accountScore;
    
    private double score;
    
    private double age;

	private List<String> scoreList;
    
   public Account(String name, Date accountOpenDate, Double accountCurrentBalance, Double accountCreditLimit)
            throws ParseException {
        this.name = name;
        this.accountOpenDate = accountOpenDate;
        this.accountCurrentBalance = accountCurrentBalance;
        this.accountCreditLimit = accountCreditLimit;
        setAge(age);
        setScore(score);
    }

    public String getName() {
        return name;
    }

    public Date getAccountOpenDate() {
        return accountOpenDate;
    }

    public Double getAccountCurrentBalance() {
        return accountCurrentBalance;
    }

    public Double getAccountCreditLimit() {
        return accountCreditLimit;
    }

    public int getAgeInMonthsAtTimeOfOffer() {
        return ageInMonthsAtTimeOfOffer;
    }

    public Double getAccountScore() {
        return accountScore;
    }

    public void setAge(double age) throws ParseException {
      this.age = age;
    }

    public void setScore(double score) {
      this.score = score;
    }

	public List<String> getScoreList() {
		return scoreList;
	}

	public void setScoreList(List<String> scoreList) {
		this.scoreList = scoreList;
	}

	@Override
	public int compareTo(Account arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(arg0.getName());
	}

	@Override
	public int compare(Account arg0, Account arg1) {
		// TODO Auto-generated method stub
		return arg0.getAccountScore().intValue() -  arg1.getAccountScore().intValue();
	}
}
