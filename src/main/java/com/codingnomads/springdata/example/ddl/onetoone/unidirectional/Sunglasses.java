package com.codingnomads.springdata.example.ddl.onetoone.unidirectional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sunglasses")
@NoArgsConstructor
@Getter
@Setter
public class Sunglasses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String brand;

    @OneToOne
    private Driver driver;

}
