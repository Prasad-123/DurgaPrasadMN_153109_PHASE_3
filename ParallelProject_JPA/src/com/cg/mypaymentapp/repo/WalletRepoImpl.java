package com.cg.mypaymentapp.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.util.JPAUtil;

public class WalletRepoImpl implements WalletRepo{
	static Logger myLogger = Logger.getLogger(WalletRepoImpl.class);
	List<Transactions> transactions = new ArrayList<Transactions>();
	private EntityManager entityManager;

	public WalletRepoImpl()
	{
		entityManager = JPAUtil.getEntityManager();
	}

	public boolean save(Customer customer) 
	{
		myLogger.info("putting in hashmap");
		try 
		{
			entityManager.persist(customer);
		} 

		catch(Exception e)
		{
			throw new InvalidInputException("account already exist");
		}

		return true;
	}

	public Customer findOne(String mobileNo)
	{
		Customer cus = entityManager.find(Customer.class, mobileNo);
		return cus;
	}

	public void update(Wallet wallet,Transactions transaction)
	{
		entityManager.merge(wallet);
		entityManager.persist(transaction);
	}

	public List<Transactions> transactionList(Customer customer)
	{
		String qstr ="select trans from Transactions trans where trans.mobileNo=:m_no";
		TypedQuery<Transactions> query = entityManager.createQuery(qstr,Transactions.class);
		query.setParameter("m_no", customer.getMobileNo());
		List<Transactions> transactionList=null;
		transactionList = query.getResultList();
		return transactionList;

	}

	@Override
	public void startTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() 
	{
		System.out.println("yyy");
		try {
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static java.sql.Date getCurrentJavaSqlDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
}