package com.bancoppel.services;

import java.util.List;

import com.bancoppel.entitys.Crud;

public interface IControlService {
	
	public List<Crud> findAll();
	public Crud save(Crud crud);
}
