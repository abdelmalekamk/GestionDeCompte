package com.training.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
