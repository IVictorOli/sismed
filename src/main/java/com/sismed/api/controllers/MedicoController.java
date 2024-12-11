package com.sismed.api.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.sismed.api.entities.Medico;
import com.sismed.api.repositories.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
        Medico novoMedico = medicoRepository.save(medico);
        return ResponseEntity.ok(novoMedico);
    }

    @GetMapping
    public List<Medico> listarMedicos() {
    	return medicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarMedicoPorId(@PathVariable UUID id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizarMedico(@PathVariable UUID id, @RequestBody Medico medico) {
    	if (!medicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        medico.setId(id);
        Medico medicoAtualizado = medicoRepository.save(medico);
        return ResponseEntity.ok(medicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMedico(@PathVariable UUID id) {
        if (!medicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
