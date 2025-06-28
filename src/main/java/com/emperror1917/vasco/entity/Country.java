package com.emperror1917.vasco.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "countries")
@Data
public class Country {

    @Id
    @Column(name = "iso_code", length = 2)
    private String isoCode;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
} 