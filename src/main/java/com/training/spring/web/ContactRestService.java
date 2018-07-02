package com.training.spring.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	  
	/*@RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
	public Page<Contact> chercher(
			@RequestParam(name="mc" ,defaultValue="") String mc,
			@RequestParam(name="page" ,defaultValue="0") int page,
			@RequestParam(name="size" ,defaultValue="5") int size){
		return contactRespository.chercher("%"+mc+"%", PageRequest.of( page,size));
	}*/
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Optional<Contact> getContatc(@PathVariable Long id){
		return contactRespository.findById(id);
	}
	
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact c){
		return contactRespository.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean deleteContact (@PathVariable Long id){
		 contactRespository.deleteById(id);
		 return true ;
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact putContact(@PathVariable Long id,@RequestBody Contact c){
		c.setId(id);
		return contactRespository.save(c);
	}
}
