package org.scott.power.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

/**
 * Model class holding the entity details
 * @author kalpana
 */
@Entity
@Component
@Table(name="Power_Details")
@XmlRootElement
public class PowerDetails {

	@Id
	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;
	@Column(name="GAS_ID")
	private int gasId;
	@Column(name="ELEC_ID")
	private int electricityId;
	@Column(name="ELEC_SMART_READ")
	private int smartReadElectricityReading;
	@Column(name="GAS_SMART_READ")
	private int smartReadGasReading;
	/**
	 * @return the accountNumber
	 */
	
	public PowerDetails(){
		
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the gasId
	 */
	public int getGasId() {
		return gasId;
	}
	/**
	 * @param gasId the gasId to set
	 */
	public void setGasId(int gasId) {
		this.gasId = gasId;
	}
	/**
	 * @return the electricityId
	 */
	public int getElectricityId() {
		return electricityId;
	}
	/**
	 * @param electricityId the electricityId to set
	 */
	public void setElectricityId(int electricityId) {
		this.electricityId = electricityId;
	}
	/**
	 * @return the smartReadElectricityReading
	 */
	public int getSmartReadElectricityReading() {
		return smartReadElectricityReading;
	}
	/**
	 * @param smartReadElectricityReading the smartReadElectricityReading to set
	 */
	public void setSmartReadElectricityReading(int smartReadElectricityReading) {
		this.smartReadElectricityReading = smartReadElectricityReading;
	}
	/**
	 * @return the smartReadGasReading
	 */
	public int getSmartReadGasReading() {
		return smartReadGasReading;
	}
	/**
	 * @param smartReadGasReading the smartReadGasReading to set
	 */
	public void setSmartReadGasReading(int smartReadGasReading) {
		this.smartReadGasReading = smartReadGasReading;
	}
	
	
}
