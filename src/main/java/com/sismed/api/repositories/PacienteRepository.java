package com.sismed.api.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sismed.api.entities.Paciente;

	@Repository
	public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
		@Query("SELECT COUNT(c) FROM Consulta c WHERE c.paciente.id = :pacienteId")
	    long countConsultasByPaciente(UUID pacienteId);
		List<Paciente> findByNome(String nome);
		List<Paciente> findByCpf(String cpf);
		List<Paciente> findByDataNascimento(LocalDate dataNascimento);
		List<Paciente> findByContato(String contato);
		List<Paciente> findByEmail(String email);
	}