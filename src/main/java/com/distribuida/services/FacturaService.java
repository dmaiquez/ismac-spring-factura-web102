package com.distribuida.services;

import java.util.Date;
import java.util.List;

import com.distribuida.entities.Cliente;
import com.distribuida.entities.Factura;

public interface FacturaService {

	public List<Factura> findAll();
	
	public Factura findOne(int id);
	
	public void add(Date fecha, double total_neto, double iva, double total, int id_cliente);	
	
	public void up(int id_factura, Date fecha, double total_neto, double iva, double total, int id_cliente);

	public void del(int id);

	
	//
	public List<Factura> findAll(String busqueda);
	
}
