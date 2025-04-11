package com.codingnomads.springdata.example.mybatis.oneandmany.models;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(exclude = "songs")
public class Album {

    private Long id;

    private String name;

    private String year;

    private List<Song> songs;
}
