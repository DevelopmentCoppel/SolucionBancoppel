package com.coppel.repositoryDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coppel.entity.Crud;


@Repository
public interface IControlRepositoryDao extends JpaRepository<Crud, Integer> {
	


}
