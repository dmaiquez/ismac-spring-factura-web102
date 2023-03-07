package com.distribuida.services;

import java.util.Date;
import java.util.List;

import com.distribuida.entities.Producto;

public interface ProductoService {

	//id_producto	nombre	descripcion	precio	stock
	
	
	public List<Producto> findAll();	
	
	public Producto findOne(int id);
			
	public void add(String nombre, String descripcion, double precio, int stock);	
	
	public void up(int id_producto, String nombre, String descripcion, double precio, int stock);

	public void del(int id);
	
		
	public List<Producto> findAll(String parametroDeBusqueda);
	
	
}
