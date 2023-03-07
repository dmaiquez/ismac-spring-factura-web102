package com.distribuida.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.Factura;

@Service
public class FacturaServiceImpl implements FacturaService{

	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private FacturaDAO facturaDAO;

	
	
	@Override
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
	 
		return facturaDAO.findAll();
	}

	@Override
	public Factura findOne(int id) {
		// TODO Auto-generated method stub		
		
		return facturaDAO.findOne(id);
	}

	@Override
	public void add(Date fecha, double total_neto, double iva, double total, int id_cliente) {
		// TODO Auto-generated method stub
		
		Cliente cliente = clienteDAO.findOne(id_cliente);
						 	
		Factura factura1 = new Factura(cliente);
		factura1.setFecha(fecha);
		factura1.setTotalNeto(total_neto);
		factura1.setIva(iva);
		factura1.setTotal(total);
		
		facturaDAO.add(factura1);						
	}

	@Override
	public void up(int id_factura, Date fecha, double total_neto, double iva, double total, int id_cliente) {
		// TODO Auto-generated method stub
		Cliente cliente = clienteDAO.findOne(id_cliente);		
		Factura factura = facturaDAO.findOne(id_factura);
		
		factura.setFecha(fecha);
		factura.setTotalNeto(total_neto);
		factura.setIva(iva);
		factura.setTotal(total);
		factura.setCliente(cliente);
		
		facturaDAO.add(factura);
		
	}
		
	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		facturaDAO.del(id);
	}

	
	//*****
	@Override
	public List<Factura> findAll(String busqueda) {
			// TODO Auto-generated method stub
		return facturaDAO.findAll(busqueda);
	}
	
	
	
	
}
