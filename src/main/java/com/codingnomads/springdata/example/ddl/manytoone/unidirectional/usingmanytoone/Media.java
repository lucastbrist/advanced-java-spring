package com.codingnomads.springdata.example.ddl.manytoone.unidirectional.usingmanytoone;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String type;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Comment comment;
}
