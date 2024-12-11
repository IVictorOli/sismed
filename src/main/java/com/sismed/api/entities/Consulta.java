package com.sismed.api.entities;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDate dataconsulta;

    @Column(nullable = false)
    private String id_medico;

    @Column(nullable = false)
    private String id_paciente;
    
    @Column(nullable = false)
    private String status;

    public UUID getId() {
        return id;
		}
    	public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return dataconsulta;
		}
    	public void setDataConsulta(LocalDate dataconsulta) {
        this.dataconsulta = dataconsulta;
    }

    public String getMedico() {
        return id_medico;
		}
    	public void setMedico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getPaciente() {
        return id_paciente;
		}
    	public void setPaciente(String id_paciente) {
        this.id_paciente = id_paciente;
	}
    
    public String getStatus() {
        return status;
		}
    	public void setStatus(String status) {
        this.status = status;
    }
}
