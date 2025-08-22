package br.com.senac.api.controllers;

import br.com.senac.api.controllers.dtos.CarroRequestDTO;
import br.com.senac.api.entidades.Carro;
import br.com.senac.api.servise.CarroS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carro")
public class CarroC {

    @Autowired
    private CarroS carroS;

    @GetMapping("/listar")
    public ResponseEntity<List<Carro>> listaTodos() {
        return ResponseEntity.ok(carroS.listaTodos());
    }

    @PostMapping("/criar")
    public ResponseEntity<Carro> criar(@RequestBody CarroRequestDTO carro) {
        try {
            return ResponseEntity.ok(carroS.criar(carro));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable Long id, @RequestBody CarroRequestDTO carro) {
        try {
            return ResponseEntity.ok(carroS.atualizar(id, carro));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
