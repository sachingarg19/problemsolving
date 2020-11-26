package com.capitalone;

import java.math.BigDecimal;

public class TransactionInfo {

	String id;
	String accountId;
	String postDate;
	String merchangeName;
	String categorry;
	String type;
	BigDecimal amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getMerchangeName() {
		return merchangeName;
	}

	public void setMerchangeName(String merchangeName) {
		this.merchangeName = merchangeName;
	}

	public String getCategorry() {
		return categorry;
	}

	public void setCategorry(String categorry) {
		this.categorry = categorry;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
