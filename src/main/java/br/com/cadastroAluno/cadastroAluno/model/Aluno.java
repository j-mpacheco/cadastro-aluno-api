package br.com.cadastroAluno.cadastroAluno.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    Long matricula;
    Long id_turma;
    String nome_aluno, telefone_aluno, email_aluno, dta_nasc;
    @Column(unique = true, nullable = false)
    String cpf_aluno;
}