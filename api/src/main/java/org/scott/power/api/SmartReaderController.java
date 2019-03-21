package org.scott.power.api;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.scott.power.api.model.PowerDetails;
import org.scott.power.api.service.PowerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the Rest controller for hanlding requests with "reads" uri
 * It handles requests related to power details readings.
 * It has all the operations like get put post delete 
 * @author kalpana
 *
 */
@RestController
@RequestMapping("reads")
public class SmartReaderController {
	@Autowired
	PowerDetailsService powerDetailsService;
	@RequestMapping(value="/welcome",method = RequestMethod.GET, produces= MediaType.TEXT_PLAIN)
	public String test() {
		return "Please enter the url for testing rest services - http://localhost:8080/api/smart/reads/{accounNumber}";
	}
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     * @param accountNumber account number for which we want to fetch power read details
     * @return PowerDetails that will be returned as a application/json response.
     */
	@RequestMapping(value = "/{accountNumber}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON)
    public PowerDetails getPowerDetails(@PathVariable int accountNumber) {
        return powerDetailsService.getPowerDetailsFromStub(accountNumber);
    }
	
	@RequestMapping(value = "/getAllAccounts", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON)
    public List<PowerDetails> getAllPowerDetails() {
        return powerDetailsService.getAllPowerAccountsFromStub();
    }
	/**
	 * Method handling HTTP POST requests for adding new power details
	 * with input sent in application/json format
	 * @param powerDetails input which is in json format
	 */
	@RequestMapping(value = "/createPowerDetails", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON)
    public void createPowerDetails(@RequestBody PowerDetails powerDetails) {
        powerDetailsService.createPowerDetailsThroughStub(powerDetails);
    }
	/**
	 * Method handling HTTP PUT requests for updating the power details
	 * @param powerDetails json input is expected
	 */
	@RequestMapping(value = "/updatePowerDetails", method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON)
    public void updatePowerDetails(@RequestBody PowerDetails powerDetails) {
       powerDetailsService.updatePowerDetailsThroughStub(powerDetails);
    }
	/**
	 * Method handling HTTP DELETE requests based on account number 
	 * It expects a account number which is to be deleted
	 * @param accountNumber
	 */
	@RequestMapping(value = "/deletePowerDetails/{accountNumber}", method = RequestMethod.DELETE)
    public void deletePowerDetails(@PathVariable int accountNumber) {
         powerDetailsService.deletePowerDetailsThroughStub(accountNumber);
    }
}
