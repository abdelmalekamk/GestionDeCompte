package com.training.spring.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.training.spring.entities.*;
import com.training.spring.dao.ContactRepository;

@RestController
public class ContactRestService {

	@Autowired 
	private ContactRepository contactRespository ;
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getContatcs(){
		return contactRespository.findAll();
	}
	 
	/*@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Optional<Contact> getContatcs(@PathVariable Long id){
		return contactRespository.findById(id);
	}*/
}
