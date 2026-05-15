package org.serratec.aula03.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente_vip")
public class ClienteVip extends Cliente {

    @Column(name = "consultor_responsavel")
    private String consultorResponsavel;

    public ClienteVip() {}

    public ClienteVip(Long id, String nome, String cpf, String email, 
                      java.time.LocalDate dataNascimento, String consultorResponsavel) {
        super(id, nome, cpf, email, dataNascimento);
        this.consultorResponsavel = consultorResponsavel;
    }

    public String getConsultorResponsavel() {
        return consultorResponsavel;
    }

    public void setConsultorResponsavel(String consultorResponsavel) {
        this.consultorResponsavel = consultorResponsavel;
    }
}