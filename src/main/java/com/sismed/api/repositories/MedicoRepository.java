package com.sismed.api.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sismed.api.entities.Medico;

	@Repository
	public interface MedicoRepository extends JpaRepository<Medico, UUID> {
		@Query("SELECT COUNT(c) FROM Consulta c WHERE c.medico.id = :medicoId")
		long countConsultasByMedico(UUID medicoId);
	    
	    List<Medico> findByCrm(String crm);
	    
	    List<Medico> findByEmail(String email);
	    
	    List<Medico> findByNome(String nome);
	    
	    List<Medico> findByEspecialidade(String especialidade);
	}