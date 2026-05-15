package org.serratec.aula03.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(max = 60, message = "O nome pode ter no máximo 60 caracteres")
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "Email inválido")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "O cargo não pode ser vazio")
    @Size(max = 50, message = "O cargo pode ter no máximo 50 caracteres")
    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;

    @NotNull(message = "O salário não pode ser nulo")
    @DecimalMin(value = "1320.00", message = "O salário não pode ser menor que o mínimo")
    @Column(name = "salario", nullable = false)
    private Double salario;

    @NotNull(message = "A data de admissão não pode ser nula")
    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    public Funcionario() {}

    public Funcionario(Long id, String nome, String email, String cargo, Double salario, LocalDate dataAdmissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }

    public LocalDate getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(LocalDate dataAdmissao) { this.dataAdmissao = dataAdmissao; }
}