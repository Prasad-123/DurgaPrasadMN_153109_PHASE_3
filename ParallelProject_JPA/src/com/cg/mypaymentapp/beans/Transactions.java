package com.cg.mypaymentapp.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transaction_jpa")

public class Transactions implements Serializable
{

	private String transactionType;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysgen")
	@SequenceGenerator(sequenceName="my_sequence",name="mysgen")
	private int id;
	private String mobileNo;
	private Date transactionDate;
	private BigDecimal balance;

	@Override
	public String toString() {
		return "Transactions [transactionType=" + transactionType + ", id=" + id + ", mobileNo=" + mobileNo
				+ ", transactionDate=" + transactionDate + ", balance=" + balance + "]";
	}
	public Transactions( String mobileNo,String transactionType, Date transactionDate, BigDecimal balance) {
		super();
		this.transactionType = transactionType;
		this.mobileNo = mobileNo;
		this.transactionDate = transactionDate;
		this.balance = balance;
	}
	public Transactions() {
		super();
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
