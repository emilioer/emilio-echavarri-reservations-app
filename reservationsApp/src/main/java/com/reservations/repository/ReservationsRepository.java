package com.reservations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservations.model.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations, Integer> {

}
