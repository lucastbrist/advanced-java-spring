/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.valueannotation;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Nomad {

    private String name;

    private Integer age;

    private String favoriteFood;

    private String petsName;

    public Nomad(@Value("${nomad.name}") String name, @Value("${nomad.age}") Integer age, @Value("${nomad.favoriteFood]") String favoriteFood, @Value("${nomad.petsName}") String petsName) {
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
        this.petsName = petsName;

    }

    @Value("Hello!!")
    private String greeting;

    @Value("${nomad.framework}")
    private String framework;

    @Value("${nomad.jdk}")
    private String jdk;

    @Value("${nomad.ide:IntelliJ IDEA}")
    private String ide;

    @Value("${nomad.workingDays}")
    private List<String> workingDays;

    @Value("#{${database.values}}")
    private Map<String, String> databaseValues;

    public String nomadIdentity() {
        return name.concat(" ").concat(age.toString());
    }

    public String getGreeting() {
        return greeting;
    }

    public String output() {
        return "Spring Developer is building awesome software using: "
                .concat(jdk)
                .concat(" , ")
                .concat(framework)
                .concat(" and ")
                .concat(ide);
    }

    public List<String> getWorkingDays() {
        return workingDays;
    }

    public Map<String, String> getDatabaseValues() {
        return databaseValues;
    }
}
