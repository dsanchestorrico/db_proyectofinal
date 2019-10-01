package com.moddb.app.model;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@SuppressWarnings("deprecation")
@NodeEntity
public class User {
	@GraphId
	private Long id;
	private String name;
	private Integer age;
	@Relationship(type= "RATED", direction = Relationship.INCOMING)
	List<Kudo> listKudos;
	
	public List<Kudo> getListKudos() {
		return listKudos;
	}

	public void setListKudos(List<Kudo> listKudos) {
		this.listKudos = listKudos;
	}

	public User() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
