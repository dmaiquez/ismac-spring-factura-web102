package com.distribuida.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity
@Table(name="Facturas")
public class Factura implements Serializable{
	
	// id_factura	fecha	total_neto	iva	total	id_cliente
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura")
	private int idFactura;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="total_neto")
	private Double totalNeto = 0.0;
	@Column(name="iva")
	private Double iva;
	@Column(name="total")
	private Double total;	
	
	//@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})

	//@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	//@JoinColumn(name="id_cliente")	
	//private Cliente cliente;
	
	
	//@ManyToOne
	//@ManyToOne(cascade=CascadeType.ALL)
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;		
	
	//private DatosEmpresa datosEmpresa;
	
	public Factura () {}
	
		
	
	public Factura(int idFactura, Date fecha, Double totalNeto, Double iva, Double total) {
	
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.totalNeto = totalNeto;
		this.iva = iva;
		this.total = total;
	}

	

	public Factura(Date fecha, Double totalNeto, Double iva, Double total) {		
		this.fecha = fecha;
		this.totalNeto = totalNeto;
		this.iva = iva;
		this.total = total;
	}




	@Autowired
	public Factura(Cliente cliente) {
		this.cliente = cliente;		
	}			
	
//	@Autowired
//	public void setDatosEmpresa(DatosEmpresa datosEmpresa) {
//		this.datosEmpresa = datosEmpresa;
//	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTotalNeto() {
		return totalNeto;
	}

	public void setTotalNeto(Double totalNeto) {
		this.totalNeto = totalNeto;
	}
	
	public void setTotalNeto(Double subtotal, boolean bool) {		
		this.totalNeto = totalNeto +  subtotal;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	

//	public DatosEmpresa getDatosEmpresa() {
//		return datosEmpresa;
//	}


	@Override
	public String toString() {
		//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
		return "Factura [idFactura=" + idFactura + ", fecha=" + fecha + ", totalNeto=" + totalNeto + ", iva=" + iva
				+ ", total=" + total + ", cliente=" + cliente +"]"; //", datosEmpresa=" + datosEmpresa + "]";
	}


	
	
	
	
	

}
