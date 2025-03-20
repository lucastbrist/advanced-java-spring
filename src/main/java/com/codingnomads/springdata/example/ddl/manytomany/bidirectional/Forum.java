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
public class Forum {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false)
    private String contentDescription;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Post> posts;

}
