package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Catalog;

@Service
public class CatalogService {

	@Autowired
	public CrudRepository<Catalog, Integer> repo;
	
	public Iterable<Catalog> findAll() {
		
		return this.repo.findAll();
		
	}
	
	
	public Catalog add(Catalog catalog) {
		
		return this.repo.save(catalog);
	} 
}
