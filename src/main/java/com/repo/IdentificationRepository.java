package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Identification;

public interface IdentificationRepository extends JpaRepository<Identification, Integer> {

}