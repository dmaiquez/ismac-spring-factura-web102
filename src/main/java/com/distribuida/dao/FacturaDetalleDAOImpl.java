package com.distribuida.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;


@Repository
public class FacturaDetalleDAOImpl implements FacturaDetalleDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<FacturaDetalle> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();		
		return session.createQuery("from FacturaDetalle", FacturaDetalle.class).getResultList();
	}

	@Override
	@Transactional
	public FacturaDetalle findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<FacturaDetalle> query = session.createQuery("select FD from FacturaDetalle FD where FD.idFacturaDetalle =: id", FacturaDetalle.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void add(FacturaDetalle facturaDetalle) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(facturaDetalle);
	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		FacturaDetalle factura = session.get(FacturaDetalle.class, id);
		session.delete(factura);
	}

	@Override
	@Transactional
	public List<FacturaDetalle> findAll(String parametro) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<FacturaDetalle> query = session.createQuery(
				" select FD "
				+ " from FacturaDetalle FD "
				+ " where FD.cantidad like : parametro "
				+ " or FD.subtotal like : parametro "
				, FacturaDetalle.class );
		query.setParameter("parametro", "%"+parametro+"%");
		return query.getResultList();
	}




	
	
}
