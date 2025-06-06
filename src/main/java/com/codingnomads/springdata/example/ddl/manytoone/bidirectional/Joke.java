package com.codingnomads.springdata.example.ddl.manytoone.bidirectional;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Joke {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Post post;
}
