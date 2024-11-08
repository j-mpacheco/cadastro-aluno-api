package br.com.cadastroAluno.cadastroAluno.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cadastroAluno.cadastroAluno.model.Aluno;

public interface alunoRepository extends JpaRepository<Aluno, Long> {
    
}
