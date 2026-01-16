package com.demetriusdemiurge.vasco.repository;

import com.demetriusdemiurge.vasco.entity.User;
import com.demetriusdemiurge.vasco.entity.UserMarkedCountry;
import com.demetriusdemiurge.vasco.entity.UserMarkedCountryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMarkedCountryRepository extends JpaRepository<UserMarkedCountry, UserMarkedCountryId> {
    List<UserMarkedCountry> findByUserId(Long userId);
    List<UserMarkedCountry> findByCountry_IsoCode(String isoCode);
    List<UserMarkedCountry> findByUserIdAndMarked(Long userId, boolean marked);
    int countByUserAndMarkedTrue(User user);
}
