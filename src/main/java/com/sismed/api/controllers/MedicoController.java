package com.sismed.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.sismed.api.entities.Medico;
import com.sismed.api.repositories.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController 
{
	@Autowired
	private MedicoRepository medicoRepository;

	@PostMapping
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
        medico.setId(UUID.randomUUID());
        Medico novoMedico = medicoRepository.save(medico);
        return ResponseEntity.ok(novoMedico);
    	}

    @GetMapping
    public ResponseEntity<List<Medico>> listarMedicos(
    		@RequestParam(required = false) String nome,
    		@RequestParam(required = false) String especialidade,
    		@RequestParam(required = false) String crm,
    		@RequestParam(required = false) String email
    		) {
        List<Medico> medicos;
        		if (email != null) {
        			medicos = medicoRepository.findByEmail(email); }
        		  else if (nome != null) {
        			medicos = medicoRepository.findByNome(nome); }
        		  else if (especialidade != null) {
        			medicos = medicoRepository.findByEspecialidade(especialidade); }
        		  else {
        			medicos = medicoRepository.findAll();}
        	return ResponseEntity.ok(medicos);
 			}

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarMedicoPorId(@PathVariable UUID id) {
    			Optional<Medico> medico = medicoRepository.findById(id);
    		return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    		}


    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizarMedico(@PathVariable UUID id, @RequestBody Medico medico) {
    		if (!medicoRepository.existsById(id)) {
    		return ResponseEntity.notFound().build();}
    	medico.setId(id);
        Medico medicoAtualizado = medicoRepository.save(medico);
        return ResponseEntity.ok(medicoAtualizado);
    	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMedico(@PathVariable UUID id) {
    	if (!medicoRepository.existsById(id) || medicoRepository.countConsultasByMedico(id) > 0) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).build();}
        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    	}
}
