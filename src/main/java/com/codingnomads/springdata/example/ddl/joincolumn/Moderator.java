package com.codingnomads.springdata.example.ddl.joincolumn;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Moderator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "privilege")
    private int privilege;

    @OneToMany
    @JoinColumn(name = "moderator_id", referencedColumnName = "id")
    private List<Moderation> moderations;

}