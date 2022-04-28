package com.example.jointableinheritance.dao;

import com.example.jointableinheritance.entity.External_Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalVetDao extends JpaRepository<External_Vet, Integer> {
}
