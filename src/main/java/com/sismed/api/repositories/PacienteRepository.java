package com.sismed.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sismed.api.entities.Paciente;

	public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
	}