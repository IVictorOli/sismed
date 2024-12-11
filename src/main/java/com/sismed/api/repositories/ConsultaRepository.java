package com.sismed.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sismed.api.entities.Consulta;

	public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
	}