package com.bancoppel.repositoryDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancoppel.entitys.Crud;




@Repository
public interface IControlRepositoryDao extends JpaRepository<Crud, Integer> {
	


}
