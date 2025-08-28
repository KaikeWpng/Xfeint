package br.com.senac.api.controllers;

import br.com.senac.api.controllers.dtos.PessoaRequestDTO;
import br.com.senac.api.controllers.dtos.ProdutoRequestDTO;
import br.com.senac.api.entidades.Pessoa;
import br.com.senac.api.entidades.Produto;
import br.com.senac.api.servise.ProdutoS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoC {

    @Autowired
    private ProdutoS produtoS;

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listaTodos() {
        return ResponseEntity.ok(produtoS.listarTodos());
    }

    @PostMapping("/criar")
    public ResponseEntity<Produto> criar(@RequestBody ProdutoRequestDTO pessoa) {
        try {
            return ResponseEntity.ok(produtoS.criar(pessoa));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody ProdutoRequestDTO produto) {
        try {
            return ResponseEntity.ok(produtoS.atualizar(id, produto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            produtoS.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}