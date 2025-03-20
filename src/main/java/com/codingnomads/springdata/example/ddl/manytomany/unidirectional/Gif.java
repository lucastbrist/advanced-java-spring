package com.codingnomads.springdata.example.ddl.manytomany.unidirectional;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

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

    // relate Comment and Post using @OneToMany
    @OneToMany(cascade = CascadeType.ALL)
    // force use of join column
    @JoinColumn(
            name = "comment_id",
            nullable = false)
    private Set<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Comment> comment;
}
