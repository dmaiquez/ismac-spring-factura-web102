package com.distribuida.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.distribuida.entities.Producto;

@Repository
public class ProductoDAOImpl implements ProductoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	//id_producto	nombre	descripcion	precio	stock
	
	
	@Override
	@Transactional
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();		
		return session.createQuery("select pr from Producto pr",Producto.class).getResultList();
	}

	@Override
	@Transactional
	public Producto findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Producto> consulta = session.createQuery("select pr from Producto pr where pr.idProducto=:id",Producto.class);
		consulta.setParameter("id", id);
		return consulta.getSingleResult();
	}

	@Override
	@Transactional
	public void add(Producto producto) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
// HQL adminte INSERT INTO...SELECT y no admite INSERT INTO .... VALUES		
//		Query query1 = session.createQuery("insert into Producto (nombre, descripcion, precio, stock) "
//				+ " select pr.nombre, pr.descripcion, pr.precio, pr.stock from Producto pr ");
//		query1.executeUpdate();
		session.save(producto);
				
	}

	@Override
	@Transactional
	public void up(Producto producto) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query2= session.createQuery("update Producto set nombre=:nombre, descripcion=:descripcion, precio=:precio, stock=:stock where idProducto=:id_producto");
		query2.setParameter("nombre", producto.getNombre());
		query2.setParameter("descripcion", producto.getDescripcion());
		query2.setParameter("precio",producto.getPrecio());
		query2.setParameter("stock", producto.getStock());
		query2.setParameter("id_producto", producto.getIdProducto());
		query2.executeUpdate();
	}
	
	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query3 = session.createQuery("delete Producto where idProducto=:id_producto");
		query3.setParameter("id_producto", id);
		query3.executeUpdate();
	}

	@Override
	@Transactional
	public List<Producto> findAll(String parametroDeBusqueda) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Query<Producto> query4 = session.createQuery(
				"select pr"
				+ " from Producto pr"
				+ " where pr.nombre like : parametroDeBusqueda"
				+ " or pr.descripcion like : parametroDeBusqueda"
				+ " or pr.precio like : parametroDeBusqueda"
				+ " or pr.stock like : parametroDeBusqueda"				
				, Producto.class);
		query4.setParameter("parametroDeBusqueda", "%"+parametroDeBusqueda+"%");
		
		return query4.getResultList();
	}



}
