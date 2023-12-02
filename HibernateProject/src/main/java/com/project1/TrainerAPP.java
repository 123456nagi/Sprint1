package com.project1;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TrainerAPP {

		public static void main(String []a) {
			EntityManagerFactory factory = null;
			
			try { //connecting to database using persistence unit
				factory  = Persistence.createEntityManagerFactory("project1");
				EntityManager em = factory.createEntityManager();
				
				System.out.println("-----WELCOME TO TRAINER DATABAES-----");
				
				Trainer t1 = new Trainer(1,"Ravi","KumarTG",40000,"ravi@gmail.com","Male");
				Trainer t2 = new Trainer(2,"Nida","Fathima",50000,"fathima@gmail.com","Female");
				Trainer t3 = new Trainer(3,"Ramesh","Kumar",35000,"ramesh@gmail.com","Male");
				Trainer t4 = new Trainer(4,"Akkara","Swathi",30000,"swathi@gmail.com","Female");
				
				TrainerDAO tDAO = new TrainerDAO(em);
				tDAO.createTrainer(t1);
				tDAO.createTrainer(t2);
				tDAO.createTrainer(t3);
				tDAO.createTrainer(t4);
				
				System.out.println("Data added successfully");
				
				System.out.println("---------------------------------------------");

				int  newid = 3;
				String newfirstName ="Anju" ;
				String newlastName = "Kumari" ;
				double newsalary = 50000;
				String newemail = "anju@gmail.com";
				String newgender  ="Female";
				
				tDAO.updateTrainer(newid, newfirstName, newlastName,newsalary, newemail, newgender);
				
				System.out.println("Data updated sucessfully");
				
				System.out.println("Student  details based on the id :");
				Optional<Trainer> tri = tDAO.getById(1);
				System.out.println(tri);
				 
				tDAO.getById(1);
				System.out.println("Details of all the students");	
				
				List<Trainer> alltr = tDAO.getAll();
				System.out.println(alltr);
				
				System.out.println("Removeing based on the id :");
				
				tDAO.removeById(2);
				
				System.out.println("2nd record is removed");

				
				
			}
			catch (HibernateException e) {
				 e.printStackTrace();
			}
			catch (Exception e) {
			 e.printStackTrace();
			}

		}

	}


