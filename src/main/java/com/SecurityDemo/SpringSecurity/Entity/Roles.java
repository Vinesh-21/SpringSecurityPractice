package com.SecurityDemo.SpringSecurity.Entity;

import com.SecurityDemo.SpringSecurity.Enums.Permissions;
import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document("roles")
public class Roles {


    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    @Nullable
    private String roleDescription;

    private Set<Permissions> permission;


    private boolean systemRole; // Built-in Roles Cannot be deleted indicator
}
