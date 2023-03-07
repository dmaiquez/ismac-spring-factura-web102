package com.distribuida.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Entity
@Table(name="DetalleFacturas")
public class FacturaDetalle implements Serializable{

	//id_detalle_factura	cantidad	subtotal	id_factura	id_producto
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_factura")
	private int idFacturaDetalle;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="subtotal")
	private Double subtotal;	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_producto")
	private Producto producto;	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_factura")
	private Factura factura;
	
	
	public FacturaDetalle() {
		
	}	
	
	


	public FacturaDetalle(int cantidad, Double subtotal, Producto producto, Factura factura) {		
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.producto = producto;
		this.factura = factura;
	}

	
	public FacturaDetalle(int idFacturaDetalle, int cantidad, Double subtotal, Producto producto, Factura factura) {	
		this.idFacturaDetalle = idFacturaDetalle;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.producto = producto;
		this.factura = factura;
	}






//	public FacturaDetalle(Producto producto) {
//		this.producto = producto;
//	}

	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}	
	
	public int getIdFacturaDetalle() {
		return idFacturaDetalle;
	}

	public void setIdFacturaDetalle(int idFacturaDetalle) {
		this.idFacturaDetalle = idFacturaDetalle;
	}

		
	public Producto getProducto() {
		return producto;
	}

	@Autowired
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	public Factura getFactura() {
		return factura;
	}

	@Autowired
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [idFacturaDetalle=" + idFacturaDetalle + ", cantidad=" + cantidad + ", subtotal="
				+ subtotal + ", producto=" + producto + ", factura=" + factura + "]";
	}
		
		
}
