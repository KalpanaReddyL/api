package org.scott.power.api.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scott.power.api.model.PowerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Dao class for db and in memory related operations
 * @author kalpana
 */
@Repository
public class PowerDetailsDao {
	//for db operations
	@Autowired
	private HibernateTemplate template;
	//for in memory operations
	@Autowired(required=false)
	private Map<Integer, PowerDetails> accountNumberMap;
	public PowerDetailsDao(){
		accountNumberMap = new HashMap<>();
		accountNumberMap.put(12345, loadPowerDetails(12345, 901, 101, 12, 13));
		accountNumberMap.put(12346, loadPowerDetails(12346, 902, 102, 13, 14));
	}
	public void setPowerDetailsMap(Map<Integer, PowerDetails> accountNumberMap){
		this.accountNumberMap = accountNumberMap;
	}
	public Map<Integer, PowerDetails> getPowerDetailsMap(){
		return accountNumberMap;
	}
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// Get all power accounts from the database
	public List<PowerDetails> getAllPowerAccounts() {
		List<PowerDetails> accounts = getTemplate().loadAll(PowerDetails.class);

		for (PowerDetails c : accounts)
			System.out.println(c.toString());

		return accounts;
	}

	// Get PowerDetails by account number from the database
	public PowerDetails getPowerDetails(int id) {
		PowerDetails powerDetails = (PowerDetails) getTemplate().get(PowerDetails.class, new Integer(id));
		System.out.println(powerDetails.toString());
		return powerDetails;
	}
	
	/**
	 * Add a new power details in the db  
	 * @param powerDetails
	 */
	public void createPowerDetails(PowerDetails powerDetails) {
		 getTemplate().persist(powerDetails);
	}
	
	/**
	 * Update theexisting powerdetails in the db
	 * @param powerDetails
	 * @return updated power details
	 */
	public PowerDetails updatePowerDetails(PowerDetails powerDetails) {
		 getTemplate().save(powerDetails);
		return powerDetails;
	}
	
	/**
	 * Delete a power details based on the account number in the db
	 * @param id
	 */
	public void deletePowerDetails(int id) {
		PowerDetails powerDetails = new PowerDetails();
		powerDetails.setAccountNumber(id);
		getTemplate().delete(powerDetails);
		System.out.println(powerDetails.toString());
	}
	/**
	 * Utility method to load initial level values for in memory operations
	 * @param id
	 * @param gasId
	 * @param elecId
	 * @param gasRead
	 * @param elecRead
	 * @return
	 */
	public PowerDetails loadPowerDetails(int id, int gasId, int elecId, int gasRead, int elecRead){
		PowerDetails powerDetails = new PowerDetails();
		powerDetails.setAccountNumber(id);
		powerDetails.setGasId(gasId);
		powerDetails.setElectricityId(elecId);
		powerDetails.setSmartReadElectricityReading(elecRead);
		powerDetails.setSmartReadGasReading(gasRead);
		return powerDetails;
	}
}
