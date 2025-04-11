/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab;

import com.codingnomads.springdata.lab.models.Area;
import com.codingnomads.springdata.lab.models.Route;
import com.codingnomads.springdata.lab.models.Trip;
import com.codingnomads.springdata.lab.repositories.AreaRepository;
import java.util.Arrays;
import java.util.List;

import com.codingnomads.springdata.lab.repositories.RouteRepository;
import com.codingnomads.springdata.lab.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;

    private final RouteRepository routeRepository;

    private final TripRepository tripRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {

        final List<Area> areas = Arrays.asList(
                Area.builder().code("G").build(),
                Area.builder().code("H").build(),
                Area.builder().code("Y").build(),
                Area.builder().code("Z").build(),
                Area.builder().code("A").build(),
                Area.builder().code("B").build(),
                Area.builder().code("L").build(),
                Area.builder().code("V").build(),
                Area.builder().code("T").build(),
                Area.builder().code("I").build(),
                Area.builder().code("F").build()
        );

        if (areaRepository.findAll().isEmpty()) {
            areaRepository.saveAll(areas);
        }

        final List<Route> routes = Arrays.asList(
                Route.builder().code("A-V").build(),
                Route.builder().code("L-B").build(),
                Route.builder().code("A-Z").build(),
                Route.builder().code("H-Y").build(),
                Route.builder().code("G-H").build()
        );

        if (routeRepository.findAll().isEmpty()) {
            routeRepository.saveAll(routes);
        }

        final List<Trip> trips = Arrays.asList(
                Trip.builder().code("A-B-V").build(),
                Trip.builder().code("L-T-B").build(),
                Trip.builder().code("A-Z-H").build(),
                Trip.builder().code("I-F-B").build(),
                Trip.builder().code("G-H-Y").build()
        );

        if (tripRepository.findAll().isEmpty()) {
            tripRepository.saveAll(trips);
        }

        System.out.println(routeRepository.findByCodeEndingWith("L"));
        System.out.println(routeRepository.findByCodeEndingWith("V"));
        System.out.println(tripRepository.findByCodeEndingWith("B"));
        System.out.println(areaRepository.findByCode("A"));

    }
}
