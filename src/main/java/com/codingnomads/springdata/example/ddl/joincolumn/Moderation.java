package com.codingnomads.springdata.example.ddl.joincolumn;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Moderation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "id"),
            @JoinColumn(name = "user_name", referencedColumnName = "name")
    })
    private User user;

}
