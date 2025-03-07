package com.codingnomads.springdata.example.ddl.onetoone.bidirectional;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SteeringWheels")
@NoArgsConstructor
@Getter
@Setter
public class SteeringWheel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(name = "torque")
    private int torque;

    @OneToOne
    private Car car;
}