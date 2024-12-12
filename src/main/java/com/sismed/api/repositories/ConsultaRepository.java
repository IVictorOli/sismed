package com.sismed.api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sismed.api.entities.Consulta;
	
	@Repository
	public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
		@Query("SELECT c FROM Consulta c WHERE " +
	            "(:id_medico IS NULL OR c.medico.id = :id_medico) AND " +
	            "(:id_paciente IS NULL OR c.paciente.id = :id_paciente)")
	    List<Consulta> findByFilters(
	            @Param("id_medico") UUID id_medico,
	            @Param("id_paciente") UUID id_paciente
	    );
	}