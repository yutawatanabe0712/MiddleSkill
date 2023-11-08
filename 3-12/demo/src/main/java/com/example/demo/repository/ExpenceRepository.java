package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExpenceEntity;

@Repository
public interface ExpenceRepository extends JpaRepository<ExpenceEntity, Integer> {
}