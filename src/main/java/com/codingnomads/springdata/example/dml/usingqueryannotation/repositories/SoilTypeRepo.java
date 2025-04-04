/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.usingqueryannotation.repositories;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query(value = "SELECT * FROM soil_types", nativeQuery = true)
    ArrayList<SoilType> findAll();

    @Query("SELECT st FROM SoilType st WHERE name = ?1")
    List<SoilType> getSoilTypeByName(String name);

    @Query("SELECT st FROM SoilType st WHERE id = ?1")
    SoilType getSoilTypeById(Long id);

    @Query("SELECT st FROM SoilType st WHERE st.ph = ?1")
    List<SoilType> getSoilTypeByPH(double ph);

    @Query("SELECT st FROM SoilType st WHERE st.dry = ?1")
    List<SoilType> getSoilTypeByDry(boolean dry);

    @Query("SELECT st FROM SoilType st WHERE NOT name = ?1")
    List<SoilType> getSoilTypeByNameNot(String name);

}

