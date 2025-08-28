package br.com.senac.api.controllers;

import br.com.senac.api.controllers.dtos.ClientesRequestDTO;
import br.com.senac.api.controllers.dtos.PessoaRequestDTO;
import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.entidades.Pessoa;
import br.com.senac.api.servise.ClientesS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesC {

    @Autowired
    private ClientesS clientesS;

    @PostMapping("/criar")
    public ResponseEntity<Void> cadastrarCliente(@RequestBody ClientesRequestDTO cliente) {
        System.out.println(cliente.toString());
        clientesS.criar(cliente);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> listarTodos() {
        return ResponseEntity.ok(clientesS.listarTodos());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Clientes> atualizar(@PathVariable Long id, @RequestBody ClientesRequestDTO clientes) {
        try {
            return ResponseEntity.ok(clientesS.atualizar(id, clientes));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            clientesS.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
