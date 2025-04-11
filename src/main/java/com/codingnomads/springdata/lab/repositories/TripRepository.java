package com.codingnomads.springdata.lab.repositories;

import com.codingnomads.springdata.lab.models.Route;
import com.codingnomads.springdata.lab.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Route> findByCodeStartingWith(String origin);

    List<Route> findByCodeEndingWith(String destination);

    Route findByCode(String code);

}
