package com.superheros.ingrid.repository;

import com.superheros.ingrid.entity.SuperPowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperPowerRepository extends JpaRepository<SuperPowerEntity, Integer> {

}