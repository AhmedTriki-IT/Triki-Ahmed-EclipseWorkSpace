package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job, Long> {
	@Query("select c from Job c where c.service like :service")
	public Page<Job> candidatByNom(@Param("service") String n ,Pageable pageable);
	}

