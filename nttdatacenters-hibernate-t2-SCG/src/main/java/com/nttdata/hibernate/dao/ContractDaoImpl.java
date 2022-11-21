package com.nttdata.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.idao.IContractDao;
import com.nttdata.hibernate.models.Contract;

/**
 * ContractDaoImpl Class
 * 
 * @author Samuel Calderón González
 *
 */
public class ContractDaoImpl implements IContractDao {
	private Session session;

	/**
	 * Contructor
	 * 
	 * @param session
	 */
	public ContractDaoImpl(Session session) {
		super();
		this.session = session;
	}

	/**
	 * Returns all contracts
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> getAllContracts() {
		sessionCheck();
		return (List<Contract>) session.createQuery("FROM Contract").list();
	}

	/**
	 * Returns a specific contract
	 */
	@Override
	public Contract getContract(int id) {
		sessionCheck();
		return session.get(Contract.class, id);
	}

	/**
	 * Inserts a contract
	 */
	@Override
	public void insertContract(Contract contract) {
		sessionCheck();
		session.save(contract);
		session.getTransaction().commit();
		System.out.println("Contract inserted succesfully");
	}

	/**
	 * updates a contract
	 */
	@Override
	public void updateContract(Contract contract) {
		sessionCheck();
		session.saveOrUpdate(contract);
		session.getTransaction().commit();
		System.out.println("Contract updated succesfully");
	}

	/**
	 * deletes a contract
	 */
	@Override
	public void deleteContract(Contract contract) {
		sessionCheck();
		session.remove(contract);
		session.getTransaction().commit();
		System.out.println("Contract deleted succesfully");
	}

	/**
	 * Search a specific contract by customer id. Returns null if there isn't any
	 */
	@Override
	public Contract searchByCustomerId(int customerId) {
		sessionCheck();
		for (Contract c : getAllContracts()) {
			if (c.getCustomer().getId() == customerId) {
				return c;
			}
		}
		return null;

	}

	/**
	 * Starts session if it hasn't been started already.
	 */
	private void sessionCheck() {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
	}

}
