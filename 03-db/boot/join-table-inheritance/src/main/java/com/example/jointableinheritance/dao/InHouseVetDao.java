package com.example.jointableinheritance.dao;

import com.example.jointableinheritance.entity.InHouse_Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InHouseVetDao extends JpaRepository<InHouse_Vet, Integer> {
}
