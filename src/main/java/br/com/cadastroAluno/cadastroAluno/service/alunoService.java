package br.com.cadastroAluno.cadastroAluno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastroAluno.cadastroAluno.model.Aluno;
import br.com.cadastroAluno.cadastroAluno.repository.alunoRepository;

@Service
public class alunoService {
    @Autowired
    private alunoRepository repository;
    
    public Aluno createAluno(Aluno aluno){
        return repository.save(aluno);
    }

    public List<Aluno> getAllAluno(){
        return repository.findAll();
    }

    public Optional<Aluno> getAlunoById(Long matricula){
        return repository.findById(matricula);
    }
    public void deleteAluno(Long matricula){
        if (!repository.existsById(matricula)){
            throw new RuntimeException("Aluno com id: "+matricula+" não encontrado");
        }
        repository.deleteById(matricula);
    }

    public Aluno updateAluno(Long matricula, Aluno aluno){
        Optional<Aluno> oldAluno = repository.findById(matricula);
        if (oldAluno.isPresent()){
            Aluno newAluno = oldAluno.get();

            newAluno.setNome_aluno(aluno.getNome_aluno());
            newAluno.setCpf_aluno(aluno.getCpf_aluno());
            newAluno.setDta_nasc(aluno.getDta_nasc());
            newAluno.setEmail_aluno(aluno.getEmail_aluno());
            newAluno.setTelefone_aluno(aluno.getTelefone_aluno());
            
            return repository.save(newAluno);
        } else {
            throw new RuntimeException("Aluno com id: "+matricula+" não encontrado");
        }
 }
}