package com.forts.service;

import com.forts.model.Fort;
import com.forts.repository.FortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FortService {

    @Autowired
    private FortRepository fortRepository;

    public List<Fort> getAllForts() {
        return fortRepository.findAll();
    }

    public Fort getFortById(Long id) {
        return fortRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fort not found"));
    }

    public List<Fort> searchForts(String query) {
        return fortRepository.findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(query, query);
    }
}
