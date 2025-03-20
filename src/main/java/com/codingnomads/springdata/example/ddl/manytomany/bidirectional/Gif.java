package com.codingnomads.springdata.example.ddl.manytomany.bidirectional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Gif {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String url;

    @ManyToMany(mappedBy = "gifs",
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Comment> comments;

}
