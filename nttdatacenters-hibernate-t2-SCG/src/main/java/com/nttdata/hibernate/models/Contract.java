package com.nttdata.hibernate.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity Contract
 * 
 * @author Samuel Calderón Gonález
 *
 */
@Entity
@Table(name = "contrato")
public class Contract extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String validationDate;
	private String expirationDate;
	private double mensualPrice;
	private Customer customer;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "fechaVigencia")
	public String getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(String validationDate) {
		this.validationDate = validationDate;
	}

	@Column(name = "fechaCaducidad")
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "precioMensual")
	public double getMensualPrice() {
		return mensualPrice;
	}

	public void setMensualPrice(double mensualPrice) {
		this.mensualPrice = mensualPrice;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clienteId")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", validationDate=" + validationDate + ", expirationDate=" + expirationDate
				+ ", mensualPrice=" + mensualPrice + ", Customer=" + customer + "]";
	}

}
