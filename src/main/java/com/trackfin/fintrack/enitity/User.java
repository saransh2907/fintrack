package com.trackfin.fintrack.enitity;

import jakarta.persistence.*;
import jdk.jfr.MetadataDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String contact;
    @Column(nullable = false)
    private String password;

}
