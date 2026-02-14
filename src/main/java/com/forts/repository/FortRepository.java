package com.forts.repository;

import com.forts.model.Fort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FortRepository extends JpaRepository<Fort, Long> {
    
    // Custom query method for search
    List<Fort> findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(String name, String location);
}
