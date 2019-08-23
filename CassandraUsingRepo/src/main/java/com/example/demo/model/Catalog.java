package com.example.demo.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(value="catalog")
public class Catalog {
	
	@PrimaryKey
	private int id;
	private double amount;
	@Column(value="catalog_name")
	private String catalogName;
}
