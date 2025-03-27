/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import com.codingnomads.springdata.example.dml.derivedquerymethods.codewarriorexample.EmailAddress;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private int beds;
    private int baths;

}
