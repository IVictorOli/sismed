package com.sismed.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sismed.api.entities.Medico;

	public interface MedicoRepository extends JpaRepository<Medico, UUID> {
		@Query("SELECT COUNT(c) FROM Consulta c WHERE c.medico.id = :medicoId")
		long countConsultasByMedico(UUID medicoId);
	}