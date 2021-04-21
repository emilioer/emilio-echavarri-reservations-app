package com.reservations.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservations.model.Reservations;
//import com.reservations.repository.ReservationsRepository;
import com.reservations.service.ReservationsService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ReservationsController {
	
	@Autowired
	private ReservationsService service;

	@ApiOperation(value = "Retrieves all the list of reservations")
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public ResponseEntity<List<Reservations>> getReservations() {
		
		List<Reservations> reservations = new ArrayList<>();
		
		reservations = service.getAllReservations();

		return new ResponseEntity<>(reservations, HttpStatus.OK);
	}
	
	
	/* CRUD section */
	@ApiOperation(value = "Retrieve an existing reservation")
	@RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
	public ResponseEntity<Reservations> getReservation(@PathVariable(value = "id") int id) throws NoSuchElementException {
		
		return new ResponseEntity<>(service.getReservationById(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Creates a new reservations")
	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public ResponseEntity<Reservations> createReservation(@RequestBody Reservations reservation) {
		
		return new ResponseEntity<>(service.saveReservation(reservation), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update an existing reservation")
	@RequestMapping(value = "/reservation/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Reservations> updateReservation(@PathVariable(value = "id") int id, @RequestBody Reservations reservation) {
		
		return new ResponseEntity<>(service.updateReservation(id, reservation), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete an existing operation")
	@RequestMapping(value = "/reservation/{id}", method = RequestMethod.DELETE)
	public Map<String, Boolean> deleteReservation(@PathVariable(value = "id") int id) {
		
		Boolean deleted = service.deleteReservation(id);
        Map <String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);	
        
		return response; 
	}
}

