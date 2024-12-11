package com.sismed.api.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private LocalDate data_consulta;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
    
    @Column(nullable = false)
    private String status;
    
//#############################################################################//

    public UUID getId() {
        return id;
		}
    	public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return data_consulta;
		}
    	public void setDataConsulta(LocalDate data_consulta) {
        this.data_consulta = data_consulta;
    }

    public Medico getMedico() {
        return medico;
		}
    	public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
		}
    	public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
	}
    
    public String getStatus() {
        return status;
		}
    	public void setStatus(String status) {
        this.status = status;
    }
}
