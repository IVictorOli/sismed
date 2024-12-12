package com.sismed.api.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sismed.api.entities.Paciente;
import com.sismed.api.repositories.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
    	paciente.setId(UUID.randomUUID());
        Paciente novoPaciente = pacienteRepository.save(paciente);
        return ResponseEntity.ok(novoPaciente);
    }
    	
        @GetMapping
        public ResponseEntity<List<Paciente>> listarPacientes(
        		@RequestParam(required = false) String nome,
        		@RequestParam(required = false) String cpf,
        		@RequestParam(required = false) LocalDate dataNascimento,
        		@RequestParam(required = false) String contato,
        		@RequestParam(required = false) String email
        		) {
            List<Paciente> pacientes;
            if (nome != null) {
            	pacientes = pacienteRepository.findByNome(nome); }
  		  else if (cpf != null) {
  			pacientes = pacienteRepository.findByCpf(cpf); }
  		  else if (dataNascimento != null) {
  			pacientes = pacienteRepository.findByDataNascimento(dataNascimento); }
  		  else if (contato != null) {
  			pacientes = pacienteRepository.findByContato(contato); }
  		  else if (email != null) {
  			pacientes = pacienteRepository.findByEmail(email); }
  		  else {
  			pacientes = pacienteRepository.findAll();
            }
            
            return ResponseEntity.ok(pacientes);
        }
    	

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable UUID id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable UUID id, @RequestBody Paciente paciente) {
        if (!pacienteRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
        }
        paciente.setId(id);
        Paciente pacienteAtualizado = pacienteRepository.save(paciente);
        return ResponseEntity.ok(pacienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPaciente(@PathVariable UUID id) {
        if (!pacienteRepository.existsById(id) || pacienteRepository.countConsultasByPaciente(id) > 0) {
        return ResponseEntity.notFound().build();
        }
        pacienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
