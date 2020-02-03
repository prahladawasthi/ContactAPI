package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Communication;

public interface CommunicationRepository extends JpaRepository<Communication, Integer> {


}
