package org.serratec.aula03.controller;

import org.serratec.aula03.domain.ClienteVip;
import org.serratec.aula03.repository.ClienteVipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente-vip")
public class ClienteVipController {

    @Autowired
    private ClienteVipRepository repository;

    @GetMapping
    public ResponseEntity<List<ClienteVip>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteVip> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteVip> salvar(@RequestBody ClienteVip clienteVip) {
        return ResponseEntity.status(201).body(repository.save(clienteVip));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteVip> atualizar(@PathVariable Long id, @RequestBody ClienteVip clienteVip) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        clienteVip.setId(id);
        return ResponseEntity.ok(repository.save(clienteVip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}