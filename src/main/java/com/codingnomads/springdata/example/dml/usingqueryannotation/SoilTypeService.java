package com.codingnomads.springdata.example.dml.usingqueryannotation;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import com.codingnomads.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SoilTypeService {

    @Autowired
    SoilTypeRepo soilTypeRepo;

    @Transactional
    public void saveStuff() {

        if (soilTypeRepo.findAll().isEmpty()) {

            SoilType soilType =
                    SoilType.builder().dry(true).ph(7.6).name("tester").build();
            SoilType soilType2 =
                    SoilType.builder().dry(false).ph(7.2).name("tester2").build();

            soilTypeRepo.save(soilType);
            soilTypeRepo.save(soilType2);
        }
    }


    @Transactional
    public void getStuff() {

        System.out.println("SOIL TYPES:");
        List<SoilType> soilTypes = soilTypeRepo.findAll();

        for (SoilType st : soilTypes) {
            System.out.println(st.toString());
        }

    }
}
