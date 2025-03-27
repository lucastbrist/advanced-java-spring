/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {

    House findByAddress(String address);

    List<House> findByBedsGreaterThanEqual(int bedrooms);

    List<House> findByBathsGreaterThanEqual(int baths);

    List<House> findByBedsIsNullOrBathsIsNull();

    List<House> findByAddressIsNotNull();

    List<House> findByBedsAndBathsIs(int beds, int baths);

    Integer countByBeds(int beds);

    Integer countByBaths(int baths);

    List<House> findByAddressStartingWith(String prefix);

    List<House> findByAddressContaining(String infix);

}
