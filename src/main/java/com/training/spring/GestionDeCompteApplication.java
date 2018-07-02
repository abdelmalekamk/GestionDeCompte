package com.training.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.spring.GestionDeCompteApplication;
import com.training.spring.dao.ContactRepository;
import com.training.spring.entities.Contact;

@SpringBootApplication
public class GestionDeCompteApplication implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository ;
	public static void main(String[] args) {
		SpringApplication.run(GestionDeCompteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("saif", "saif", df.parse("10/06/1994"), "folan@benfolan.com", (long) 21365487, "photo.jpeg"));
		contactRepository.save(new Contact("adem", "adma", df.parse("10/06/1994"), "folan@benfolan.com", (long) 21365487, "photo.jpeg"));
		contactRepository.save(new Contact("fiko", "hola", df.parse("10/06/1994"), "folan@benfolan.com", (long) 21365487, "photo.jpeg"));
		contactRepository.save(new Contact("fdddo", "ssf", df.parse("10/06/1994"), "folan@benfolan.com", (long) 21365487, "photo.jpeg"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getPrenom());
		});
	}
}
