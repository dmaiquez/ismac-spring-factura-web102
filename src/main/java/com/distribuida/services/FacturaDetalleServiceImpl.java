package com.distribuida.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.FacturaDetalleDAO;
import com.distribuida.dao.ProductoDAO;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;
import com.distribuida.entities.Producto;


@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {
	
	
	
	
	@Autowired
	private FacturaDetalleDAO facturaDetalleDAO;
	
	@Autowired
	private FacturaDAO facturaDAO;
	
	@Autowired
	private ProductoDAO productoDAO;
	
	
	@Override
	public List<FacturaDetalle> findAll() {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.findAll();
	}

	@Override
	public FacturaDetalle findOne(int id) {
		// TODO Auto-generated method stub		
		return facturaDetalleDAO.findOne(id);
	}

	@Override
	public void add(int cantidad, int id_factura, int id_producto) {
		// TODO Auto-generated method stub
		Producto producto = productoDAO.findOne(id_producto);
		Factura factura = facturaDAO.findOne(id_factura);
		
		
		FacturaDetalle facturaDetalle = new FacturaDetalle();		
		facturaDetalle.setCantidad(cantidad);
		facturaDetalle.setSubtotal(facturaDetalle.getCantidad()*producto.getPrecio());		
		producto.setStock(producto.getStock() - facturaDetalle.getCantidad());
		facturaDetalle.setFactura(factura);
		facturaDetalle.setProducto(producto);
		
		
		facturaDetalleDAO.add(facturaDetalle);		
		productoDAO.up(producto);
		
		
	}

	@Override
	public void up(int id_detalle_factura, int cantidad, int id_factura, int id_producto) {
		// TODO Auto-generated method stub
		Producto producto = productoDAO.findOne(id_producto);
		Factura factura = facturaDAO.findOne(id_factura);				
		FacturaDetalle facturaDetalle = facturaDetalleDAO.findOne(id_detalle_factura);
		
		facturaDetalle.setCantidad(cantidad);
		facturaDetalle.setSubtotal(facturaDetalle.getCantidad()*producto.getPrecio());		
		producto.setStock(producto.getStock() - facturaDetalle.getCantidad());
		facturaDetalle.setFactura(factura);
		facturaDetalle.setProducto(producto);
		
		
		facturaDetalleDAO.add(facturaDetalle);		
		productoDAO.up(producto);
		
		
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		facturaDetalleDAO.del(id);
	}

	
	
	@Override
	public List<FacturaDetalle> findAll(String parametro) {
		// TODO Auto-generated method stub
		
		return facturaDetalleDAO.findAll(parametro);
	}	
	
	
	
	
	
	
	
}
