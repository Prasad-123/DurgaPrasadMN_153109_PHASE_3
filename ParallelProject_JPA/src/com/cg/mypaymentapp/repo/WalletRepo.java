package com.cg.mypaymentapp.repo;

import java.util.List;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.beans.Wallet;

public interface WalletRepo
{

	public boolean save(Customer customer);

	public Customer findOne(String mobileNo);

	public void update(Wallet wallet,Transactions transaction);

	public List<Transactions> transactionList(Customer customer);

	public void startTransaction();

	public void commitTransaction();
}
