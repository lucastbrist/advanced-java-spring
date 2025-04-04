/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;


    @PrePersist
    public void printGreeting() {
        System.out.println("Hello there!");
    }

    @PostPersist
    public void printFunFact() {
        System.out.println("Did you know that in 1977, when Star Wars Episode IV: A New Hope released, " +
                "it was just calked 'Star Wars?' When Empire Strikes Back released in 1980, " +
                "people were confused about the 'Episode V' numbering.");
    }

    @PostRemove
    public void printGoodbye() {
        System.out.println("Goodbye!");
    }

}
