package com.we4lead.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    private String id;  // Pas de cascade ici, c'est l'ID

    @Column(unique = true)
    private String email;

    private String nom;
    private String prenom;
    private String telephone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String photoPath;

    @Enumerated(EnumType.STRING)
    private Situation situation;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "niveau_etude")
    private String niveauEtude;

    private String specialite;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "medecin_universite",
            joinColumns = @JoinColumn(name = "medecin_id"),
            inverseJoinColumns = @JoinColumn(name = "universite_id")
    )
    private Set<Universite> universites = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "universite_id")
    private Universite universite;

    // Relations avec les autres entités
    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Demande> demandesRecues = new HashSet<>();

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Demande> demandesEnvoyees = new HashSet<>();

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Rdv> rdvsMedecin = new HashSet<>();

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Rdv> rdvsEtudiant = new HashSet<>();

    // Constructeurs
    public User() {}

    public User(String id, String email, String nom, String prenom, String telephone, Role role) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.role = role;
    }

    // ====== Getters & Setters existants ======
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public String getPhotoPath() { return photoPath; }
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }

    public Set<Universite> getUniversites() { return universites; }
    public void setUniversites(Set<Universite> universites) { this.universites = universites; }

    public Universite getUniversite() { return universite; }
    public void setUniversite(Universite universite) { this.universite = universite; }

    // ====== Getters & Setters pour les nouveaux champs ======
    public Situation getSituation() { return situation; }
    public void setSituation(Situation situation) { this.situation = situation; }

    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    public String getNiveauEtude() { return niveauEtude; }
    public void setNiveauEtude(String niveauEtude) { this.niveauEtude = niveauEtude; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    // ====== Getters & Setters pour les relations ======
    public Set<Demande> getDemandesRecues() { return demandesRecues; }
    public void setDemandesRecues(Set<Demande> demandesRecues) { this.demandesRecues = demandesRecues; }

    public Set<Demande> getDemandesEnvoyees() { return demandesEnvoyees; }
    public void setDemandesEnvoyees(Set<Demande> demandesEnvoyees) { this.demandesEnvoyees = demandesEnvoyees; }

    public Set<Rdv> getRdvsMedecin() { return rdvsMedecin; }
    public void setRdvsMedecin(Set<Rdv> rdvsMedecin) { this.rdvsMedecin = rdvsMedecin; }

    public Set<Rdv> getRdvsEtudiant() { return rdvsEtudiant; }
    public void setRdvsEtudiant(Set<Rdv> rdvsEtudiant) { this.rdvsEtudiant = rdvsEtudiant; }
}