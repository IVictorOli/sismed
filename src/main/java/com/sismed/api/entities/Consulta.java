package com.sismed.api.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Consulta {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private LocalDate data_consulta;

    @Column(nullable = false)
    private String id_medico;

    @Column(nullable = false)
    private String id_paciente;
    
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
