package com.moddb.app.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.moddb.app.model.User;

public interface UserRepository extends Neo4jRepository<User, Long>{

	@Query("MATCH (u:User)<-[r:RATED]-(m:Kudo) RETURN u,r,m")
	Collection<User> getAllUsers();
	
}
