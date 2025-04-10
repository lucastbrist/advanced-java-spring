package com.codingnomads.springdata.example.mybatis.resultsandresult;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Camel {

    private Long id;

    private String name;

    private int humpAmount;

    public Camel(String name, int humpAmount) {
        this.name = name;
        this.humpAmount = humpAmount;
    }
}
