package com.reservations.service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.reservations.model.Reservations;
import com.reservations.repository.ReservationsRepository;

@Service
public class ReservationsService {
	
	private ReservationsRepository repository;
	
	public ReservationsService(ReservationsRepository repository) {
		this.repository = repository;
	}
	
	public List<Reservations> getAllReservations() {
		return repository.findAll();
	}
	
	public Reservations getReservationById(int id) {
		return repository.findById(Integer.valueOf(id)).orElseThrow(() -> new NoSuchElementException("Reservation not found for this id: "+ id));
	}
	
	
	public Reservations saveReservation(Reservations reservations) {
		return repository.save(reservations);
	}

	public Reservations updateReservation(int id, Reservations newReservation) {
		Reservations existingReservation = repository.findById(Integer.valueOf(id)).orElseThrow(() -> new NoSuchElementException("Reservation not found for this id: "+ id));
		
		existingReservation.setName(newReservation.getName());
		existingReservation.setTime(newReservation.getTime());
		
		return repository.save(existingReservation);
	}
	
	public Boolean deleteReservation(int id) {
		
		repository.deleteById(id);
		
		return Boolean.TRUE;
	}

}
