package com.codingnomads.springdata.example.ddl.manytoone.unidirectional.usingonetomany;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Post> posts;
}
