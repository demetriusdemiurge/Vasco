package com.emperror1917.vasco.repository;

import com.emperror1917.vasco.entity.Country;
import com.emperror1917.vasco.entity.TravelDiary;
import com.emperror1917.vasco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelDiaryRepository extends JpaRepository<TravelDiary, Long> {
    Optional<TravelDiary> findByTitle(String title);
    boolean existsByTitle(String title);
    List<TravelDiary> findAllByUser(User user);
    List<TravelDiary> findAllByCountry(Country country);
}
