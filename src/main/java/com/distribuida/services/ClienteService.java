package com.distribuida.services;

import java.util.Date;
import java.util.List;

import com.distribuida.entities.Cliente;

public interface ClienteService{

	//id_cliente	cedula	nombre	apellido	edad	fecha_nac	direccion	telefono	correo
	
	public List<Cliente> findAll();	
	
	public Cliente findOne(int id);
	
	public void add(Cliente cliente);
		
	public void add(String cedula, String nombre, String apellido, int edad, Date fecha_nac, String direccion, String telefono, String correo);	
	
	public void up(int id_cliente, String cedula, String nombre, String apellido, int edad, Date fecha_nac, String direccion, String telefono, String correo);

	public void del(int id);
	
	
	
	public List<Cliente> findAll(String parametroDeBusqueda);
	
	
}
