package com.emperror1917.vasco.repository;

import com.emperror1917.vasco.entity.Photo;
import com.emperror1917.vasco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByUser(User user);
    Optional<Photo> findByUrl(String url);
    boolean existsByUrl(String url);
}
