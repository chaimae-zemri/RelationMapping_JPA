package org.example.jpasearch;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");
        EntityManager em = emf.createEntityManager();

        //teste de la relaton onetoone entre le student et ladresse:****************************************
        em.getTransaction().begin();
        Student student = new Student();
        student.setNom("ZEMRI");
        student.setPrenom("Chaimae");
        student.setFiliere("Genie Informatique");
        student.setNote(100);

        Adresse adresse = new Adresse();
        adresse.setRue("Massira");
        adresse.setVille("Marrakech");
        adresse.setPays("Maroc");

        adresse.setStudent(student);
        em.persist(adresse);

        student.setAdresse(adresse);
        em.persist(student);

        em.getTransaction().commit();



        //teste de la relation manytoone entre le student et luniveriste************************************
        em.getTransaction().begin();
        Universite universite = new Universite();
        universite.setName("UCA");

        student.setUniversite(universite);


        em.persist(student);
        em.persist(universite);
        em.getTransaction().commit();


        //teste de la relation manytomany entre le student et les cours**********************************
        em.getTransaction().begin();
        Student student2 = new Student("jean","jack","GE",87);
        em.persist(student2);

        Cours cours1 = new Cours();
        cours1.setName("base de donnees");
        Cours cours2 = new Cours();
        cours2.setName("operating system");
        em.persist(cours1);
        em.persist(cours2);

        Set list = new HashSet();
        list.add(cours1);
        list.add(cours2);
        student.setCourses(list); //ajout des cours a un student


        cours1.getStudents().add(student);
        cours2.getStudents().add(student);



        Set studentlist = new HashSet();
        studentlist.add(student);
        studentlist.add(student2);

        //ajout des  students au cours
        cours1.setStudents(studentlist);


        em.persist(student);
        em.persist(cours1);
        em.persist(cours2);
        em.getTransaction().commit();





    }
}
