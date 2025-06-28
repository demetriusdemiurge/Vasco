package com.emperror1917.vasco.repository;

import com.emperror1917.vasco.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
    Optional<Country> findByIsoCode(String code);
    boolean existsByIsoCode(String isoCode);
    boolean existsByName(String isoCode);
}
