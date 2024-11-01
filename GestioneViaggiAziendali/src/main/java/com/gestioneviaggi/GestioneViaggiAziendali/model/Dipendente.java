package com.gestioneviaggi.GestioneViaggiAziendali.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String nome;

    @NotBlank
    private String cognome;

    @Email
    private String email;
    private String imagineProfiloUrl;

    public String getImagineProfiloUrl() {
        return imagineProfiloUrl;
    }

    public void setImagineProfiloUrl(String imagineProfiloUrl) {
        this.imagineProfiloUrl = imagineProfiloUrl;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotBlank String getCognome() {
        return cognome;
    }

    public void setCognome(@NotBlank String cognome) {
        this.cognome = cognome;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
