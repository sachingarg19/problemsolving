package com.capitalone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OneTestOne {

	public static void main(String[] args) {

		try {
			String inputString = readFile("C:\\Users\\sachi\\Downloads\\JSon");	
			String category = new String("Dining");
			BigDecimal balance = getBalanceForCategory(inputString, "Home Improvement");
			System.out.println("Balance of category "+category+ " balance > "+balance);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static BigDecimal getBalanceForCategory(String inputJason,
			String category) {
		BigDecimal balance = new BigDecimal(0);

		JSONParser parser = new JSONParser();

		try {

			JSONObject jsonObject = (JSONObject) parser.parse(inputJason);
			JSONArray jsonArray = (JSONArray) jsonObject.get("transactions");
			//System.out.println(jsonArray.get(0));
			Iterator<JSONObject> iterator = jsonArray.iterator();
			while (iterator.hasNext()) {

				JSONObject jsonObj = (JSONObject) iterator.next();
				TransactionInfo transactionInfo = getTransactionObj(jsonObj);

				if (category != null
						&& transactionInfo.getCategorry().equalsIgnoreCase(
								category)) {
					if (transactionInfo.getType().equalsIgnoreCase("DEBIT"))
						balance = balance.add(transactionInfo.getAmount());
					else if (transactionInfo.getType().equalsIgnoreCase("CREDIT"))
						balance = balance.subtract(transactionInfo.getAmount());
					//System.out.println("Category >"+category+" Type > "+transactionInfo.getType()+" amount > "+transactionInfo.getAmount()+" balance >"+balance);
				} else if (category == null) {
					if (transactionInfo.getType().equalsIgnoreCase("DEBIT"))
						balance = balance.add(transactionInfo.getAmount());
					else if (transactionInfo.getType().equalsIgnoreCase("CREDIT"))
						balance = balance.subtract(transactionInfo.getAmount());
					//System.out.println("Category >"+category+" Type > "+transactionInfo.getType()+" amount > "+transactionInfo.getAmount()+" balance >"+balance);
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		//balance.setScale(2, RoundingMode.CEILING);
		//balance = balance.setScale(2, RoundingMode.CEILING);
		balance = balance.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		return balance;
	}

	private static TransactionInfo getTransactionObj(JSONObject jsonObj) {
		TransactionInfo transactionInfo = new TransactionInfo();
		transactionInfo.setId((String) jsonObj.get("id"));
		transactionInfo.setAccountId((String) jsonObj.get("accountid"));
		transactionInfo.setPostDate((String) jsonObj.get("postDate"));
		transactionInfo.setMerchangeName((String) jsonObj.get("merchantName"));
		transactionInfo.setCategorry((String) jsonObj.get("category"));
		transactionInfo.setType((String) jsonObj.get("type"));
		transactionInfo.setAmount(new BigDecimal(Double.parseDouble((String) jsonObj.get("amount"))));
		return transactionInfo;
	}

	private static String readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		try {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}

			return stringBuilder.toString();
		} finally {
			reader.close();
		}
	}

}
