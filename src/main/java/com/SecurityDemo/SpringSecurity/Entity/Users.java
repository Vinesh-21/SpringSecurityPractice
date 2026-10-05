package com.SecurityDemo.SpringSecurity.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private String role;

    // Later:
    // private Set<String> siteIds;
}