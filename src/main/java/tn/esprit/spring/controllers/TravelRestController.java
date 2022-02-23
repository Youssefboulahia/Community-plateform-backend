package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Travel;
import tn.esprit.spring.service.ITravelService;



@RestController 
@RequestMapping("/travel") 
public class TravelRestController {

	@Autowired
  ITravelService travelservice;
	// http://localhost:8089/SpringMVC/travel/retrieve-all-travels 
	
	@GetMapping("/retrieve-all-travels") 
	@ResponseBody 
	public List<Travel> getTravels() { 
		return travelservice.retrieveAllTravels();
	  
	}
	
	//http://localhost:8089/SpringMVC/travel/retrieve-travel/2
	@GetMapping("/retrieve-travel/{travel-id}")
	@ResponseBody
	public Travel retrieveTravel(@PathVariable("travel-id") Long idTravel) {
	return travelservice.retrieveTravelById(idTravel);
	}
	
	
	//http://localhost:8089/SpringMVC/travel/add-travel
	@PostMapping("/add-travel")
	@ResponseBody
	public Travel AddTravel(@RequestBody Travel t)
	{
			Travel travel= travelservice.addTravel(t);
			return travel;
	
     }
	
	
	
	
	//http://localhost:8089/SpringMVC/travel/remove-travel/{travel-id}
	@DeleteMapping("/remove-travel/{travel-id}")
	@ResponseBody
	public void removeTravel(@PathVariable("travel-id") Long idTravel) {
	travelservice.deleteTravel(idTravel);	}
	
	
	
	//http://localhost:8089/SpringMVC/travel/modify-travel
		@PutMapping("/modify-travel")
		@ResponseBody
		public Travel ModifyTravel(@RequestBody Travel t)
		{
			return travelservice.updateTravel(t);
		}

		//http://localhost:8089/SpringMVC/travel/modify-travel-byID/2
		@PutMapping("/modify-travel-byID/{travel-id}")
		@ResponseBody
		public Travel ModifyTravelById(@PathVariable("travel-id") Long idTravel,@RequestBody Travel t) {
		return travelservice.updateTravelById(t, idTravel);
		}
		
}