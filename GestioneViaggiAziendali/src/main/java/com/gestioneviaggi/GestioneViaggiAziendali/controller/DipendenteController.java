package com.gestioneviaggi.GestioneViaggiAziendali.controller;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Dipendente;
import com.gestioneviaggi.GestioneViaggiAziendali.service.DipendenteService;
import com.gestioneviaggi.GestioneViaggiAziendali.service.FileUploadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private FileUploadService fileUploadService;

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

    @PostMapping("/{id}/upload-profile-image")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = fileUploadService.uploadFile(file, id);
            Dipendente dipendente = dipendenteService.findById(id).orElseThrow();
            dipendente.setImagineProfiloUrl(imageUrl);
            dipendenteService.save(dipendente);

            return ResponseEntity.ok("Immagine caricata con successo: " + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Errore durante il caricamento dell'immagine");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Dipendente non trovato");
        }
    }
}
