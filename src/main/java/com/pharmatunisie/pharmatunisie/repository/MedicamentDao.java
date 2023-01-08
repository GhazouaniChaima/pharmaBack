package com.pharmatunisie.pharmatunisie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pharmatunisie.pharmatunisie.entity.MedicamentEntity;

@Repository
public interface MedicamentDao extends JpaRepository<MedicamentEntity, Integer>{

}
