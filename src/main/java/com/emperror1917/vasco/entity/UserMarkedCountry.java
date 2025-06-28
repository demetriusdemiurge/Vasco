package com.emperror1917.vasco.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_marked_countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMarkedCountry {
    @EmbeddedId
    private UserMarkedCountryId id = new UserMarkedCountryId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("countryIsoCode")
    @JoinColumn(name = "country_iso_code")
    private Country country;

    @Column(name = "marked", nullable = false)
    private boolean marked = false;

}