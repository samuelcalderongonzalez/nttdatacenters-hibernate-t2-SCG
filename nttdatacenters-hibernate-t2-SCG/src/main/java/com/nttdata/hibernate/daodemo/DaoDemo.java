package com.nttdata.hibernate.daodemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nttdata.hibernate.dao.ContractDaoImpl;
import com.nttdata.hibernate.dao.CustomerDaoImpl;
import com.nttdata.hibernate.idao.IContractDao;
import com.nttdata.hibernate.idao.ICustomerDao;
import com.nttdata.hibernate.models.Contract;
import com.nttdata.hibernate.models.Customer;

/**
 * Class DaoDemo. A testing class for all methods of ICustomerDao.java
 * 
 * @author Samuel Calderón González
 *
 */
public class DaoDemo {
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Create session
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		Session session = sf.openSession();

		ICustomerDao customer = new CustomerDaoImpl(session);
		IContractDao contract = new ContractDaoImpl(session);
		
		//Adding customers and contracts to use as examples
		Customer customer1 = new Customer();
		customer1.setName("Juan");
		customer1.setSurname1("Rodríguez");
		customer1.setSurname2("Martínez");
		customer1.setNif("999999999");
		
		Customer customer2 = new Customer();
		customer2.setName("Pablo");
		customer2.setSurname1("Pérez");
		customer2.setSurname2("Calderón");
		customer2.setNif("777777777");
		
		Contract contract1 = new Contract();
		contract1.setCustomer(customer1);
		contract1.setExpirationDate("2022-12-12");
		contract1.setValidationDate("2023-12-12");
		contract1.setMensualPrice(22.5);
		
		Contract contract2 = new Contract();
		contract2.setCustomer(customer2);
		contract2.setExpirationDate("2022-10-17");
		contract2.setValidationDate("2023-10-17");
		contract2.setMensualPrice(30.7);
		
		
		customer.insertCustomer(customer1);
		customer.insertCustomer(customer2);
		
		//Test insert
		contract.insertContract(contract1);
		contract.insertContract(contract2);
		
		//Test getContract
		System.out.println(contract.getContract(contract2.getId()));
		
		//Test getAllContracts
		System.out.println(contract.getAllContracts());
		
		//Test searchByCustomerId method
		System.out.println(contract.searchByCustomerId(customer1.getId()));
		
		contract2.setMensualPrice(50);
		//Test Update
		contract.updateContract(contract2);
		
		//Test Delete
		contract.deleteContract(contract2);
		
		session.close();

	}

}
