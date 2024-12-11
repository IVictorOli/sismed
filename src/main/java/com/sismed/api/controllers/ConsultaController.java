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

import com.sismed.api.entities.Consulta;
import com.sismed.api.repositories.ConsultaRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
		private ConsultaRepository consultaRepository;

	@PostMapping
		public ResponseEntity<Consulta> agendarConsulta(@RequestBody Consulta consulta) {
			consulta.setId(UUID.randomUUID());
			Consulta novaConsulta = consultaRepository.save(consulta);
			return ResponseEntity.ok(novaConsulta);
	}

	@GetMapping
		public List<Consulta> listarConsultas() {
			return consultaRepository.findAll();
	}

	@GetMapping("/{id}")
		public ResponseEntity<Consulta> buscarConsultaPorId(@PathVariable UUID id) {
			Optional<Consulta> consulta = consultaRepository.findById(id);
			return consulta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
		public ResponseEntity<Consulta> atualizarConsulta(@PathVariable UUID id, @RequestBody Consulta consulta) {
			if (!consultaRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			consulta.setId(id);
			Consulta consultaAtualizada = consultaRepository.save(consulta);
			return ResponseEntity.ok(consultaAtualizada);
    }

	@DeleteMapping("/{id}")
		public ResponseEntity<Void> cancelarConsulta(@PathVariable UUID id) {
			if (!consultaRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			consultaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
	}
}
