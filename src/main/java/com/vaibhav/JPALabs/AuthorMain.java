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
		Author aut1 = new Author(101,"Vaibhav","Dilip","Sawant",987643535);
		Author aut2 = new Author(102,"Sagar","Arun","Nitore",9805634);
		Author aut3 = new Author(103,"Siddhesh",null,"Sawant",894656698);
		Author aut4 = new Author(103,"Siddhesh",null,"Sawant",234634234);
		Author aut5 = new Author(103,"Siddhesh",null,"Sawant",853512334);
		// Inserting record  ---> After insertion we cannot again insert that record
		em.persist(aut1);  //insert
		em.persist(aut2);
		em.persist(aut3);
		em.persist(aut4);
		em.persist(aut5);
		
//		em.remove(emp2);
		
		// Displaying record
		Author aut = em.find(Author.class, 104);   //Select
		System.out.println(aut.toString());
		
		// Updating record
//		emp1.setFirstName("Vaib");
//		em.merge(emp1);    //Update
		
		tr.commit();
		System.out.println("End");
}
}
