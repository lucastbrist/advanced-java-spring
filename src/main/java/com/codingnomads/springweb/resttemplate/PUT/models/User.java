package com.codingnomads.springweb.resttemplate.PUT.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long id;
    private String email;
    private String first_name;
    private String last_name;
    private long updatedAt;
    private long createdAt;
}
