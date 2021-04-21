package com.reservations.cmdrunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.reservations.model.Reservations;
import com.reservations.service.ReservationsService;

@Component
public class InsertDataCmdRunner implements CommandLineRunner {

	@Autowired
	private ReservationsService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.saveReservation(new Reservations(100, "Reservation No. 100", "2020-07-08T16:58:23.08798"));
		service.saveReservation(new Reservations(101, "Reservation No. 101", "2020-07-08T16:58:23.08798"));
		service.saveReservation(new Reservations(102, "Reservation No. 102", "2020-07-08T16:58:23.08798"));
		service.saveReservation(new Reservations(103, "Reservation No. 103", "2020-07-08T16:58:23.08798"));
		service.saveReservation(new Reservations(104, "Reservation No. 104", "2020-07-08T16:58:23.08798"));
	}

}
