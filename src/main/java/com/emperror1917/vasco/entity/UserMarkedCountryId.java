package com.emperror1917.vasco.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMarkedCountryId implements Serializable {
    private Long userId;
    private String countryIsoCode;
}