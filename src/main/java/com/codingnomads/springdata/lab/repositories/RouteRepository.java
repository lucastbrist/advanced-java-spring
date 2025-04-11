package com.codingnomads.springdata.lab.repositories;

import com.codingnomads.springdata.lab.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByCodeStartingWith(String origin);

    List<Route> findByCodeEndingWith(String destination);

    Route findByCode(String code);

}
