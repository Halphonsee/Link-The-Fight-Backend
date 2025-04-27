package com.SAD.linkthefight.repository;

import com.SAD.linkthefight.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(String name);
    Optional<Rol> findById(Long id);
}