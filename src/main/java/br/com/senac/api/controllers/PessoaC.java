package br.com.senac.api.controllers;

import br.com.senac.api.controllers.dtos.PessoaRequestDTO;
import br.com.senac.api.entidades.Pessoa;
import br.com.senac.api.servise.PessoaS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaC {

    @Autowired
    private PessoaS pessoaS;

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>> listaTodos() {
        return ResponseEntity.ok(pessoaS.listarTodos());
    }

    @PostMapping("/criar")
    public ResponseEntity<Pessoa> criar(@RequestBody PessoaRequestDTO pessoa) {
        try {
            return ResponseEntity.ok(pessoaS.criar(pessoa));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody PessoaRequestDTO pessoa) {
        try {
            return ResponseEntity.ok(pessoaS.(id, pessoa));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}