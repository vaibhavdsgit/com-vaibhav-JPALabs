package com.vaibhav.JPALabs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vaibhav.JPALabs.entities.Author;

public class AuthorMain {

public static void main(String[] args) {
		
		System.out.println("Start");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abcd");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		Author aut1 = new Author(201,"Vaibhav","Dilip","Sawant",987643535);
		Author aut2 = new Author(202,"Sagar","Arun","Nitore",9805634);
		Author aut3 = new Author(203,"Siddhesh",null,"Sawant",894656698);
		Author aut4 = new Author(204,"Rahul",null,"Shinde",234634234);
		Author aut5 = new Author(205,"Harsh",null,"Rane",853512334);
		
		em.persist(aut1);  
		em.persist(aut2);
		em.persist(aut3);
		em.persist(aut4);
		em.persist(aut5);
		
		Author aut = em.find(Author.class, 204);   //Select
		System.out.println(aut.toString());
		
		tr.commit();
		System.out.println("End");
}
}
