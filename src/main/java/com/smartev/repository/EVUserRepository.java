package com.smartev.repository;

import com.smartev.model.EVUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EVUserRepository extends JpaRepository<EVUser, Long> {
    EVUser findByEmail(String email);
    List<EVUser> findByNameContainingIgnoreCase(String name);
}
