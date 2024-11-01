package com.gestioneviaggi.GestioneViaggiAziendali.controller;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Dipendente;
import com.gestioneviaggi.GestioneViaggiAziendali.service.DipendenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        return dipendenteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dipendente> createDipendente(@Valid @RequestBody Dipendente dipendente) {
        return new ResponseEntity<>(dipendenteService.save(dipendente), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
