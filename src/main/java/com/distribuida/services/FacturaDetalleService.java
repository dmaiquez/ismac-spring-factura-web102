package com.distribuida.services;

import java.util.Date;
import java.util.List;

import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;
import com.distribuida.entities.Producto;



public interface FacturaDetalleService {

	
	//id_detalle_factura	cantidad	subtotal	id_factura	id_producto	
	
	public List<FacturaDetalle> findAll();
	
	public FacturaDetalle findOne(int id);
	
	public void add(int cantidad, int id_factura, int id_producto);	
	
	public void up(int id_detalle_factura, int cantidad, int id_factura, int id_producto);

	public void del(int id);
	
	
	public List<FacturaDetalle> findAll(String parametro);
	
	
}
