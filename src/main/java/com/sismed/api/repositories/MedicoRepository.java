package com.sismed.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sismed.api.entities.Medico;

	public interface MedicoRepository extends JpaRepository<Medico, UUID> {
	}