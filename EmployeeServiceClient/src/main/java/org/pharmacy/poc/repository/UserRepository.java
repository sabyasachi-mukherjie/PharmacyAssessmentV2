package org.pharmacy.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.pharmacy.poc.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
