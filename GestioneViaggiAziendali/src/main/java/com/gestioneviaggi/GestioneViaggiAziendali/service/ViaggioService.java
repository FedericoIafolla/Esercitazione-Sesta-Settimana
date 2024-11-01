package com.gestioneviaggi.GestioneViaggiAziendali.service;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Viaggio;
import com.gestioneviaggi.GestioneViaggiAziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Viaggio> findAll() {
        return viaggioRepository.findAll();
    }

    public Optional<Viaggio> findById(Long id) {
        return viaggioRepository.findById(id);
    }

    public Viaggio save(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public void deleteById(Long id) {
        viaggioRepository.deleteById(id);
    }

    public Viaggio updateStato (Long id, Viaggio.StatoViaggio nuovoStato) {
        Viaggio viaggio = viaggioRepository.findById(id).orElseThrow();
        viaggio.setStato(nuovoStato);
        return viaggioRepository.save(viaggio);
    }
}
