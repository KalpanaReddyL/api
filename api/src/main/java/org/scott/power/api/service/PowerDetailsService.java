package org.scott.power.api.service;

import java.util.ArrayList;
import java.util.List;

import org.scott.power.api.model.PowerDetails;
import org.scott.power.api.repository.PowerDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for fetching entities and invoking db or in memory operations
 * @author kalpana
 */
@Service("powerDetailsService")
public class PowerDetailsService {

	@Autowired
	private PowerDetailsDao powerDetailsDao;
	public PowerDetailsService(){
	}
	
	/*
	 * Code for in memory operations
	 */
	
	/**
	 * Get all the power accounts using in memory logic
	 * @return list of all the power accounts
	 */
	public List<PowerDetails> getAllPowerAccountsFromStub() {
		return new ArrayList<PowerDetails>( powerDetailsDao.getPowerDetailsMap().values());
	}

	/**
	 * Get the power details of the account specified
	 * @param id acaount number whose power details are to be fetched
	 * @return the obtained power details
	 */
	public PowerDetails getPowerDetailsFromStub(int id) {
		return powerDetailsDao.getPowerDetailsMap().get(id);
	}
	
	/**
	 * Create a new power detail based on the input which is inputed
	 * @param powerDetails a new power detail to be added to in memory
	 */
	public void createPowerDetailsThroughStub(PowerDetails powerDetails) {
		powerDetailsDao.getPowerDetailsMap().put(powerDetails.getAccountNumber(), powerDetails);
	}
	/**
	 * Update the existing PowerDetails with new power detail using in memory
	 * @param powerDetails new power details to be updated with
	 */
	public void updatePowerDetailsThroughStub(PowerDetails powerDetails) {
		powerDetailsDao.getPowerDetailsMap().put(powerDetails.getAccountNumber(), powerDetails);
	}
	/**
	 * Delete power details based on account number. This is again for in memory implementation
	 * @param id account number whose details are to be deleted
	 */
	public void deletePowerDetailsThroughStub(int id) {
		powerDetailsDao.getPowerDetailsMap().remove(id);
	}
	
	/*
	 * Code which use database for testing purpose
	 */
	
	/**
	 * Code to fetch all power accounts from db
	 * @return list of power details
	 */
	public List<PowerDetails> getAllPowerAccounts() {
		return powerDetailsDao.getAllPowerAccounts();
	}

	/**
	 * Get power details for a specific account number from db
	 * @param id account number
	 * @return Power details for the specific account number
	 */
	public PowerDetails getPowerDetails(int id) {
		return powerDetailsDao.getPowerDetails(id);
	}
	/**
	 * Create new Power details in db
	 * @param powerDetails
	 */
	public void createPowerDetails(PowerDetails powerDetails) {
		 powerDetailsDao.createPowerDetails(powerDetails);
	}
	/**
	 * Update existin power details with new one
	 * @param powerDetails
	 * @return updated power detail
	 */
	public PowerDetails updatePowerDetails(PowerDetails powerDetails) {
		return powerDetailsDao.updatePowerDetails(powerDetails);
	}
	/**
	 * Delete power detail for a specific account number
	 * @param id account number
	 */
	public void deletePowerDetails(int id) {
		powerDetailsDao.deletePowerDetails(id);
	}
}