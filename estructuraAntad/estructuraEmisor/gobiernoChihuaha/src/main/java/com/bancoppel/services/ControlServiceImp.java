package com.bancoppel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bancoppel.entitys.Crud;
import com.bancoppel.repositoryDao.IControlRepositoryDao;

@Service
public class ControlServiceImp implements IControlService {

	@Autowired
	private IControlRepositoryDao iControlRepositoryDao;
	
	@Override
	@Transactional(readOnly= true)
	public List<Crud> findAll() {
		return iControlRepositoryDao.findAll();
	}

	@Override
	public Crud save(Crud crud) {
		return iControlRepositoryDao.save(crud);
	}

	

}
