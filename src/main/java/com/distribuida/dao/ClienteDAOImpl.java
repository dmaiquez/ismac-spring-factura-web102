package com.distribuida.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.distribuida.entities.Cliente;
import com.distribuida.entities.Producto;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub		
		Session session = sessionFactory.getCurrentSession();		
		return session.createQuery("from Cliente", Cliente.class).getResultList();
	}

	@Override
	@Transactional
	public Cliente findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();		
		return session.get(Cliente.class, id);
	}

	@Override
	@Transactional
	public void add(Cliente cliente) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cliente);		
	}

	
	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Cliente cliente = session.get(Cliente.class, id);
		session.delete(cliente);
	}

	
	///id_cliente	cedula	nombre	apellido	edad	fecha_nac	direccion	telefono	correo
	
	
	@Override
	@Transactional
	public List<Cliente> findAll(String parametroDeBusqueda) {
		// TODO Auto-generated method stub		
		Session session = sessionFactory.getCurrentSession();
		//Query<Cliente> consulta = session.createQuery("select cl from Cliente cl where cl.cedula like : cedula", Cliente.class);
		Query<Cliente> consulta = session.createQuery(
				" select cl "
				+ " from Cliente cl "
				+ " where cl.cedula like : parametroDeBusqueda"
				+ " or cl.nombre like : parametroDeBusqueda"
				+ " or cl.apellido like : parametroDeBusqueda"
				+ " or cl.edad like : parametroDeBusqueda"
				+ " or cl.fechaNacimiento like : parametroDeBusqueda"
				+ " or cl.direccion like : parametroDeBusqueda"
				+ " or cl.telefono like : parametroDeBusqueda"
				+ " or cl.correo like : parametroDeBusqueda"
				, Cliente.class);
		consulta.setParameter("parametroDeBusqueda", "%"+parametroDeBusqueda+"%");		
		
		return consulta.getResultList();
	}
	
	
}
