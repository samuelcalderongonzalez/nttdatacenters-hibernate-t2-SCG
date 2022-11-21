package com.nttdata.hibernate.idao;

import java.util.List;

import com.nttdata.hibernate.models.Contract;
/**
 * 
 * IContractDao Interface
 * 
 * @author Samuel Calderón González
 *
 */
public interface IContractDao {

	public List<Contract> getAllContracts();
	public Contract getContract(int id);
	public void insertContract(Contract contract);
	public void updateContract(Contract contract);
	public void deleteContract(Contract contract);
	public Contract searchByCustomerId(int customerId);

}
