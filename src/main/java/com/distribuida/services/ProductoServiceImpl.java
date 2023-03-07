package com.distribuida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.ProductoDAO;
import com.distribuida.entities.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub		
		return productoDAO.findAll();
	}

	@Override
	public Producto findOne(int id) {
		// TODO Auto-generated method stub
		return productoDAO.findOne(id);
	}

	@Override
	public void add(String nombre, String descripcion, double precio, int stock) {
		// TODO Auto-generated method stub
		Producto producto = new Producto(nombre, descripcion, precio, stock);
		productoDAO.add(producto);
	}

	@Override
	public void up(int id_producto, String nombre, String descripcion, double precio, int stock) {
		// TODO Auto-generated method stub
		Producto producto = new Producto(id_producto, nombre, descripcion, precio, stock);
		productoDAO.up(producto);
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		productoDAO.del(id);
	}

	@Override
	public List<Producto> findAll(String parametroDeBusqueda) {
		// TODO Auto-generated method stub
		return productoDAO.findAll(parametroDeBusqueda);
	}

}
