package br.com.cadastroAluno.cadastroAluno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastroAluno.cadastroAluno.model.Aluno;
import br.com.cadastroAluno.cadastroAluno.service.alunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    private alunoService service;

    @PostMapping("/create")
    public ResponseEntity<Aluno>createAluno(@RequestBody Aluno aluno){
        Aluno newAluno = service.createAluno(aluno);
        return new ResponseEntity<>(newAluno, HttpStatus.CREATED);
    }

    @GetMapping("/selectAll")
    public ResponseEntity<List<Aluno>> getAllAluno(){
        List<Aluno> allAluno = service.getAllAluno();
        return new ResponseEntity<>(allAluno, HttpStatus.OK);
    }

    @GetMapping("/select/{matricula}")
    public ResponseEntity<?> getAlunoById(@PathVariable Long matricula){
        Optional<Aluno> optionalAluno = service.getAlunoById(matricula);

        if(optionalAluno.isPresent()){
            return new ResponseEntity<>(optionalAluno.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
    }

    @DeleteMapping("/delete/{matricula}")
    public void deleteAluno(@PathVariable Long matricula){
        service.deleteAluno(matricula);
    }

    @PutMapping("/edit/{matricula}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long matricula, @RequestBody Aluno aluno){
        try{
            Aluno updatedAluno = service.updateAluno(matricula, aluno);
            return new ResponseEntity<>(updatedAluno, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
