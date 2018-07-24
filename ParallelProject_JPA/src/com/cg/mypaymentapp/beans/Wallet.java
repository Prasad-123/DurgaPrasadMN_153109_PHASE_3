package com.cg.mypaymentapp.beans;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="wallet_jpa")
public class Wallet 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysgen")
	@SequenceGenerator(sequenceName="my_sequence",name="mysgen")
	private int id;
	private BigDecimal balance;

	public Wallet(BigDecimal amount) 
	{
		this.balance=amount;
	}

	public Wallet() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getBalance() 
	{
		return balance;
	}

	public void setBalance(BigDecimal balance) 
	{
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet other = (Wallet) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return ", balance="+balance;
	}

}
