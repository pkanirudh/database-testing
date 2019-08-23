package com.example.demo.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Catalog;

@Repository
public interface CatalogRepository extends CassandraRepository<Catalog, Integer> {

}
