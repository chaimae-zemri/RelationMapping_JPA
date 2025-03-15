package org.example.jpasearch;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length=25)
    private String nom;
    private String prenom;
    @Column(length = 50)
    private String filiere;
    private double note;
    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id")
    private Universite universite;
    @ManyToMany(mappedBy = "students")
    private Set<Cours> courses = new HashSet<>();


    public Student() {
    }


    public Student(String nom, String prenom, String filiere, double note) {
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.note = note;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public Set<Cours> getCourses() {
        return courses;
    }

    public void setCourses(Set<Cours> courses) {
        this.courses = courses;
    }
}
